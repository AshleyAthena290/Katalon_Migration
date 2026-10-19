"""Convert the flat App_Dashboard happy-flow .groovy scaffold into proper Katalon
Test Case assets, mirroring the ETB Onboarding structure:

  Test Cases/App_Dashboard/<Name>.tc              <- TestCaseEntity descriptor
  Scripts/App_Dashboard/<Name>/Script<Name>.groovy <- full Katalon script body

The original flat .groovy files under Test Cases/App_Dashboard are removed once
their content has been relocated under Scripts/.
"""

from __future__ import annotations

import re
import uuid
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PROJECT = ROOT / "KatalonProject"
TEST_CASES = PROJECT / "Test Cases" / "App_Dashboard"
SCRIPTS = PROJECT / "Scripts" / "App_Dashboard"

STANDARD_HEADER = """import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
"""

FEATURE_RE = re.compile(r"^// FSD:.*\| Feature:\s*(?P<feature>.+)$")


def escape_xml(value: str) -> str:
    return (
        value.replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace('"', "&quot;")
    )


def extract_description(lines: list[str]) -> str:
    for line in lines:
        match = FEATURE_RE.match(line.strip())
        if match:
            return match.group("feature").strip()
    return ""


def strip_placeholder_imports(lines: list[str]) -> list[str]:
    """Drop the two placeholder import lines (and the blank lines around them)
    that the draft scaffold used in place of the standard Katalon header."""
    body = [
        line
        for line in lines
        if not line.startswith("import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject")
        and not line.startswith("import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile")
    ]
    while body and body[0].strip() == "":
        body.pop(0)
    return body


def test_case_xml(name: str, description: str) -> str:
    guid = uuid.uuid5(uuid.NAMESPACE_URL, f"katalon://app-dashboard/test-case/{name}")
    return f'''<?xml version="1.0" encoding="UTF-8"?>
<TestCaseEntity>
    <description>{escape_xml(description)}</description>
    <name>{name}</name>
    <tag>FSD_App Dashboard_Banking &amp; Wealth_v2.0@20260421; happy flow</tag>
    <comment></comment>
    <testCaseGuid>{guid}</testCaseGuid>
    <testCaseId>Test Cases/App_Dashboard/{name}</testCaseId>
    <isReuseDriver>false</isReuseDriver>
    <isRunNextCaseAutomatically>false</isRunNextCaseAutomatically>
    <testCaseType>Mobile</testCaseType>
</TestCaseEntity>
'''


def main() -> None:
    SCRIPTS.mkdir(parents=True, exist_ok=True)
    groovy_files = sorted(TEST_CASES.glob("*.groovy"))
    if not groovy_files:
        print("No .groovy scaffold files found under Test Cases/App_Dashboard")
        return

    for path in groovy_files:
        name = path.stem
        lines = path.read_text(encoding="utf-8").splitlines()
        description = extract_description(lines) or name.replace("_", " ")
        body = strip_placeholder_imports(lines)

        script_dir = SCRIPTS / name
        script_dir.mkdir(parents=True, exist_ok=True)
        script_content = STANDARD_HEADER + "\n" + "\n".join(body) + "\n"
        (script_dir / f"Script{name}.groovy").write_text(script_content, encoding="utf-8")

        (TEST_CASES / f"{name}.tc").write_text(test_case_xml(name, description), encoding="utf-8")

        path.unlink()
        print(f"Converted {name}")

    print(f"Converted {len(groovy_files)} App_Dashboard scaffold scripts into Test Case assets")


if __name__ == "__main__":
    main()
