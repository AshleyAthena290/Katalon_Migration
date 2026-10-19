"""Convert a flat happy-flow .groovy scaffold into proper Katalon Test Case
assets, mirroring the ETB Onboarding structure:

  Test Cases/<Folder>/<Name>.tc              <- TestCaseEntity descriptor
  Scripts/<Folder>/<Name>/Script<Name>.groovy <- full Katalon script body

The original flat .groovy files under Test Cases/<Folder> are removed once
their content has been relocated under Scripts/.

Usage: python tools/convert_folder_to_tc.py <FolderName> [--tag "..."] [--desc-prefix "..."]
"""

from __future__ import annotations

import argparse
import re
import uuid
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PROJECT = ROOT / "KatalonProject"

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

FSD_FEATURE_RE = re.compile(r"^// FSD:.*\| Feature:\s*(?P<feature>.+)$")
PLAIN_FEATURE_RE = re.compile(r"^// Feature:\s*(?P<feature>.+)$")


def escape_xml(value: str) -> str:
    return (
        value.replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace('"', "&quot;")
    )


def extract_description(lines: list[str]) -> str:
    for line in lines:
        stripped = line.strip()
        match = FSD_FEATURE_RE.match(stripped) or PLAIN_FEATURE_RE.match(stripped)
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


def test_case_xml(folder: str, name: str, description: str, tag: str) -> str:
    guid = uuid.uuid5(uuid.NAMESPACE_URL, f"katalon://{folder.lower()}/test-case/{name}")
    return f'''<?xml version="1.0" encoding="UTF-8"?>
<TestCaseEntity>
    <description>{escape_xml(description)}</description>
    <name>{name}</name>
    <tag>{escape_xml(tag)}</tag>
    <comment></comment>
    <testCaseGuid>{guid}</testCaseGuid>
    <testCaseId>Test Cases/{folder}/{name}</testCaseId>
    <isReuseDriver>false</isReuseDriver>
    <isRunNextCaseAutomatically>false</isRunNextCaseAutomatically>
    <testCaseType>Mobile</testCaseType>
</TestCaseEntity>
'''


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("folder", help="Test Cases subfolder to convert, e.g. Interbank_Transfer")
    parser.add_argument("--tag", default="happy flow", help="Tag value for the generated .tc descriptors")
    args = parser.parse_args()

    test_cases_dir = PROJECT / "Test Cases" / args.folder
    scripts_dir = PROJECT / "Scripts" / args.folder

    groovy_files = sorted(test_cases_dir.glob("*.groovy"))
    if not groovy_files:
        print(f"No .groovy scaffold files found under Test Cases/{args.folder}")
        return

    scripts_dir.mkdir(parents=True, exist_ok=True)
    for path in groovy_files:
        name = path.stem
        lines = path.read_text(encoding="utf-8").splitlines()
        description = extract_description(lines) or name.replace("_", " ")
        body = strip_placeholder_imports(lines)

        script_dir = scripts_dir / name
        script_dir.mkdir(parents=True, exist_ok=True)
        script_content = STANDARD_HEADER + "\n" + "\n".join(body) + "\n"
        (script_dir / f"Script{name}.groovy").write_text(script_content, encoding="utf-8")

        (test_cases_dir / f"{name}.tc").write_text(
            test_case_xml(args.folder, name, description, args.tag), encoding="utf-8"
        )

        path.unlink()
        print(f"Converted {name}")

    print(f"Converted {len(groovy_files)} {args.folder} scaffold scripts into Test Case assets")


if __name__ == "__main__":
    main()
