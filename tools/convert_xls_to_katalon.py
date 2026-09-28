"""Convert the onboarding workbook into a Katalon mobile test scaffold."""

from __future__ import annotations

import html
import re
import uuid
from pathlib import Path

import pandas as pd


ROOT = Path(__file__).resolve().parents[1]
SOURCE = ROOT / "ETB_Onboarding_v2.0_Test_Cases.xls"
PROJECT = ROOT / "KatalonProject"
OBJECTS = PROJECT / "Object Repository" / "Onboarding"
SCRIPTS = PROJECT / "Scripts"
TEST_CASES = PROJECT / "Test Cases" / "Onboarding"


def xml(value: object) -> str:
    return html.escape(str(value), quote=True)


def clean_text(value: object) -> str:
    if pd.isna(value):
        return ""
    return str(value).replace("\\n", "\n").strip()


def groovy(value: object) -> str:
    return str(value).replace("\\", "\\\\").replace("'", "\\'").replace("\n", "\\n")


def object_name(label: str) -> str:
    words = re.findall(r"[A-Za-z0-9]+", label)
    name = "".join(word[:1].upper() + word[1:] for word in words)
    return name or "UnnamedControl"


def controls_for(row: dict[str, str]) -> list[tuple[str, str]]:
    text = " ".join(row.values())
    labels = re.findall(r"[\"“]([^\"”]+)[\"”]", text)
    labels += re.findall(r"\[([^\]]+)\]", text)
    known = [
        ("OnboardingLandingScreen", "Onboarding Landing screen"),
        ("LanguageDropdown", "Language dropdown"),
        ("AcknowledgementCheckbox", "Acknowledgement checkbox"),
        ("ConsentContent", "Consent content"),
        ("LoginScreen", "Login screen"),
    ]
    result: list[tuple[str, str]] = known[:]
    seen = {name for name, _ in result}
    for label in labels:
        label = label.strip()
        if not label or label.lower() in {"id", "en"}:
            continue
        name = object_name(label)
        if name not in seen:
            result.append((name, label))
            seen.add(name)
    return result


def object_xml(name: str, label: str) -> str:
    guid = str(uuid.uuid5(uuid.NAMESPACE_URL, f"katalon://onboarding/{name}"))
    selector = f"//*[@text=\"{label}\" or @content-desc=\"{label}\"]"
    return f'''<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
    <description>Generated from ETB_Onboarding_v2.0_Test_Cases.xls. Confirm the selector against the app build.</description>
    <name>{xml(name)}</name>
    <tag></tag>
    <elementGuidId>{guid}</elementGuidId>
    <selectorCollection>
        <entry>
            <key>XPATH</key>
            <value>{xml(selector)}</value>
        </entry>
    </selectorCollection>
    <selectorMethod>XPATH</selectorMethod>
    <smartSelectorEnabled>false</smartSelectorEnabled>
    <dynamicObjectProperties/>
    <webElementProperties/>
    <mobileElementProperties/>
    <performanceValidated>false</performanceValidated>
</MobileElementEntity>
'''


def script_for(row: dict[str, str], controls: list[tuple[str, str]]) -> str:
    test_id = row["Test Case ID"]
    lines = [
        "import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject",
        "import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile",
        "import com.kms.katalon.core.util.KeywordUtil",
        "import internal.GlobalVariable",
        "",
        f"KeywordUtil.logInfo('Starting {test_id}')",
        "Mobile.startApplication(GlobalVariable.appPath, false)",
        "try {",
        f"    KeywordUtil.logInfo('Precondition: {groovy(row['Preconditions'])}')",
    ]
    by_label = {label.lower(): name for name, label in controls}
    steps = [step.strip() for step in row["Test Steps"].splitlines() if step.strip()]
    for step in steps:
        step_text = re.sub(r"^\d+\.\s*", "", step)
        lines.append(f"    KeywordUtil.logInfo('Step: {groovy(step_text)}')")
        labels = re.findall(r"[\"“]([^\"”]+)[\"”]", step_text)
        labels += re.findall(r"\[([^\]]+)\]", step_text)
        target = next((by_label.get(label.strip().lower()) for label in labels if label.strip().lower() in by_label), None)
        if target:
            lines.append(f"    Mobile.tap(findTestObject('Object Repository/Onboarding/{target}'), 10)")
        else:
            lines.append("    // Map this manual action to a concrete mobile keyword after confirming the app control.")
    lines.extend([
        f"    KeywordUtil.logInfo('Expected: {groovy(row['Expected Result'])}')",
        "} finally {",
        "    Mobile.closeApplication()",
        "}",
    ])
    return "\n".join(lines) + "\n"


def test_case_xml(row: dict[str, str]) -> str:
    test_id = row["Test Case ID"]
    guid = str(uuid.uuid5(uuid.NAMESPACE_URL, f"katalon://test-case/{test_id}"))
    description = (
        f"Feature: {row['Feature']}\n\n"
        f"{row['Description / Title']}\n\n"
        f"Preconditions: {row['Preconditions']}\n\n"
        f"Steps:\n{row['Test Steps']}\n\n"
        f"Expected result: {row['Expected Result']}\n\n"
        "Generated scaffold: validate selectors and app configuration before execution."
    )
    return f'''<?xml version="1.0" encoding="UTF-8"?>
<TestCaseEntity>
    <description>{xml(description)}</description>
    <name>{xml(test_id)}</name>
    <tag>{xml(row['Feature'])}</tag>
    <comment></comment>
    <testCaseGuid>{guid}</testCaseGuid>
    <testCaseId>Test Cases/Onboarding/{xml(test_id)}</testCaseId>
    <isReuseDriver>false</isReuseDriver>
    <isRunNextCaseAutomatically>false</isRunNextCaseAutomatically>
    <testCaseType>Mobile</testCaseType>
</TestCaseEntity>
'''


def main() -> None:
    data = pd.read_excel(SOURCE).fillna("")
    rows = [{str(key): clean_text(value) for key, value in row.items()} for row in data.to_dict("records")]
    all_controls: dict[str, str] = {}
    for row in rows:
        for name, label in controls_for(row):
            all_controls.setdefault(name, label)

    OBJECTS.mkdir(parents=True, exist_ok=True)
    SCRIPTS.mkdir(parents=True, exist_ok=True)
    TEST_CASES.mkdir(parents=True, exist_ok=True)
    for name, label in sorted(all_controls.items()):
        (OBJECTS / f"{name}.rs").write_text(object_xml(name, label), encoding="utf-8")
    for row in rows:
        test_id = row["Test Case ID"]
        (SCRIPTS / test_id).mkdir(parents=True, exist_ok=True)
        (SCRIPTS / test_id / f"Script{test_id}.groovy").write_text(
            script_for(row, controls_for(row)), encoding="utf-8"
        )
        (TEST_CASES / f"{test_id}.tc").write_text(test_case_xml(row), encoding="utf-8")

    (PROJECT / "Profiles").mkdir(parents=True, exist_ok=True)
    (PROJECT / "Profiles" / "default.glbl").write_text('''<?xml version="1.0" encoding="UTF-8"?>
<GlobalVariableEntities>
    <description>Set appPath to the APK or IPA used by the test environment.</description>
    <name>default</name>
    <tag></tag>
    <defaultProfile>true</defaultProfile>
    <GlobalVariableEntity>
        <description>Absolute path to the mobile application package.</description>
        <initValue>""</initValue>
        <name>appPath</name>
        <tag></tag>
        <valueType>STRING</valueType>
    </GlobalVariableEntity>
</GlobalVariableEntities>
''', encoding="utf-8")
    print(f"Generated {len(rows)} test cases and {len(all_controls)} mobile objects in {PROJECT}")


if __name__ == "__main__":
    main()
