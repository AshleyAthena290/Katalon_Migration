"""Generate Katalon happy-flow Test Cases from the Account Dashboard Time Deposits FSD.

Source: Input/Batch 2 For Katalon/FSD_Account Dashboard_Time Deposits_v2.0@20260624.xlsx

Produces, directly in the final Katalon Test Case format (mirrors ETB Onboarding):
  Test Cases/Account_Dashboard/<Name>.tc              <- TestCaseEntity descriptor
  Scripts/Account_Dashboard/<Name>/Script<Name>.groovy <- full Katalon script body

Four happy flows are generated, one per end-to-end journey covered by the FSD:
  1. TimeDepositDashboard   - 1.1 Time Deposit- Dashboard
  2. TimeDepositDetails     - 1.1.1 Time Deposit Details
  3. TimeDepositUpdateMaturity - 1.1.1.1 / .1.1 / .1.2 / .1.3 (Manage > Update maturity > Confirmation > Acknowledgement)
  4. TimeDepositEarlyWithdrawal - 1.1.1.2 / .2.1 / .2.2 / .2.3 (Manage > Early withdrawal > Confirmation > Acknowledgement)

Each step is one of:
  ("note", "text")                 -> plain comment (precondition/action/business rule)
  ("verify", "Human label")        -> Mobile.verifyElementVisible
  ("tap", "Human label")           -> Mobile.tap
  ("setText", "Human label", "v")  -> Mobile.setText
"""

from __future__ import annotations

import re
import uuid
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PROJECT = ROOT / "KatalonProject"
TEST_CASES = PROJECT / "Test Cases" / "Account_Dashboard"
SCRIPTS = PROJECT / "Scripts" / "Account_Dashboard"

FSD_SOURCE = "FSD_Account Dashboard_Time Deposits_v2.0@20260624.xlsx"
ARTIFACT_SLUG = "fsd-account-dashboard-time-deposits-v2-0-20260624"
TAG = "FSD_Account Dashboard_Time Deposits_v2.0@20260624; happy flow"

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

FLOWS: list[tuple[str, str, str, list[tuple]]] = [
    ("TimeDepositDashboard", "1.1 Time Deposit- Dashboard",
     "View the Time Deposit dashboard, mask/unmask total deposits, and open a placement",
     [("note", "Precondition: user has at least one active Time Deposit placement and is on the Account Dashboard."),
      ("verify", "Total Deposits"),
      ("verify", "Based on indicative rates tooltip"),
      ("tap", "Eye Icon"),
      ("note", "Business rule: eye icon masks/unmasks the total deposits; first-time tap shows a coach mark."),
      ("verify", "Time Deposits Card"),
      ("verify", "Maturity Date"),
      ("verify", "TD Status Label"),
      ("tap", "Sort By"),
      ("note", "Business rule: Sort By options follow the preset toggle order regardless of CASA/TD mix."),
      ("tap", "Sort By Close Button"),
      ("note", "Business rule: Time Deposit data is fetched with caching; auto-collapsible sticky header reacts to scroll direction."),
      ("tap", "Time Deposit Card Item"),
      ("note", "Business rule: tapping a placement redirects to the Time Deposit Details screen."),
      ("verify", "Time Deposit Details Screen")]),
    ("TimeDepositDetails", "1.1.1 Time Deposit Details",
     "View Time Deposit details and access Manage actions",
     [("note", "Precondition: user navigated from the Time Deposit dashboard to a selected TD placement."),
      ("verify", "Product Name"),
      ("verify", "Account Number"),
      ("verify", "Principal Amount"),
      ("verify", "Placement Date"),
      ("verify", "Tenure"),
      ("verify", "Maturity Date"),
      ("verify", "Interest Rate"),
      ("verify", "Maturity Instruction"),
      ("note", "Business rule: Update maturity instruction and Early withdrawal are only shown for app-opened, active TD accounts."),
      ("verify", "Update Maturity Instruction"),
      ("verify", "Early Withdrawal"),
      ("tap", "View Statement Button"),
      ("note", "Business rule: [<] back button returns to the Time Deposit Dashboard."),
      ("tap", "Back Button"),
      ("verify", "Time Deposit Dashboard Screen")]),
    ("TimeDepositUpdateMaturity", "1.1.1.1 Manage- Update Maturity",
     "Update the maturity instruction and confirm via the acknowledgement screen",
     [("note", "Precondition: TD account was opened via the app, is active, and passes the update-maturity soft-check cut-off."),
      ("tap", "Update Maturity Instruction"),
      ("verify", "Update Maturity Instruction Title"),
      ("verify", "Current Maturity Instruction"),
      ("tap", "Maturity Instruction Dropdown"),
      ("note", "Business rule: drawer lists Auto-rollover (principal & interest), Auto-rollover (principal only), and Disburse funds."),
      ("tap", "Auto-rollover Principal Only Option"),
      ("verify", "Transfer To Account"),
      ("verify", "Maturity Instruction Alert"),
      ("tap", "Next Button"),
      ("note", "Business rule: T&C screen is not applicable for the update-maturity feature."),
      ("verify", "Confirmation Title"),
      ("verify", "Confirmation Maturity Instruction"),
      ("verify", "Confirmation Transfer To"),
      ("verify", "Confirmation Personal Details"),
      ("tap", "Confirm Button"),
      ("note", "Business rule: Confirm navigates to the [A&A] Input Passcode flow before the update is submitted."),
      ("verify", "Acknowledgement Status Image"),
      ("verify", "Acknowledgement RefID"),
      ("verify", "Acknowledgement Maturity Instruction"),
      ("note", "Business rule: a push notification and email are sent only when the update is successful; no receipt is issued."),
      ("tap", "Done Button"),
      ("verify", "Time Deposit Details Screen")]),
    ("TimeDepositEarlyWithdrawal", "1.1.1.2 Manage- EarlyWithdrawal",
     "Submit an early withdrawal and confirm via the acknowledgement screen",
     [("note", "Precondition: TD account was opened via the app, is active, and passes the early-withdrawal soft-check cut-off."),
      ("tap", "Early Withdrawal"),
      ("verify", "Early Withdrawal Title"),
      ("verify", "Early Withdrawal Disclaimer"),
      ("verify", "Closing Amount"),
      ("tap", "Withdrawal Details Tooltip"),
      ("note", "Business rule: penalty applies for Conventional TD; cancellation charge applies for Shariah TD."),
      ("verify", "Withdrawal Amount"),
      ("verify", "Transfer To Account"),
      ("tap", "Next Button"),
      ("note", "Business rule: T&C screen is not applicable for the early-withdrawal feature."),
      ("verify", "Confirmation Title"),
      ("verify", "Confirmation Closing Amount"),
      ("verify", "Confirmation Transfer To"),
      ("verify", "Confirmation Personal Details"),
      ("tap", "Confirm Button"),
      ("note", "Business rule: Confirm navigates to the [A&A] Input Passcode flow before the withdrawal is submitted."),
      ("verify", "Acknowledgement Status Image"),
      ("verify", "Acknowledgement RefID"),
      ("verify", "Acknowledgement Withdrawal Amount"),
      ("note", "Business rule: destination account balance updates in real time and a push notification/email is sent on success."),
      ("tap", "Done Button"),
      ("verify", "Time Deposit Dashboard Screen")]),
]


def slugify(value: str) -> str:
    return re.sub(r"[^a-z0-9]+", "-", value.lower()).strip("-")


def control_slug(value: str) -> str:
    return re.sub(r"[^a-z0-9]+", "", value.lower())


def escape_xml(value: str) -> str:
    return (
        value.replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace('"', "&quot;")
    )


def object_ref(flow_slug: str, label: str) -> str:
    return f"findTestObject('Android/{flow_slug}/{control_slug(label)}')"


def script_body(name: str, section: str, requirement: str, steps: list[tuple]) -> str:
    flow_slug = slugify(name)
    artifact_path = f"artifacts/{ARTIFACT_SLUG}/test-cases/{slugify(section)}.test-cases.json"
    lines = [
        f"// FSD: {FSD_SOURCE} | Feature: {section} - {requirement}",
        f"// Traceability: {artifact_path}",
        "// TODO: Replace with the configured Maybank Android application path or APK.",
        "// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.",
        "Mobile.startApplication(GlobalVariable.appPath, false)",
        "",
        "try {",
    ]
    for step in steps:
        kind = step[0]
        if kind == "note":
            lines.append(f"    // {step[1]}")
        elif kind == "verify":
            lines.append(f"    Mobile.verifyElementVisible({object_ref(flow_slug, step[1])}, 10)")
        elif kind == "tap":
            lines.append(f"    Mobile.tap({object_ref(flow_slug, step[1])}, 10)")
        elif kind == "setText":
            lines.append(f"    Mobile.setText({object_ref(flow_slug, step[1])}, '{step[2]}', 10)")
        else:
            raise ValueError(f"Unknown step kind: {kind}")
    lines += ["} finally {", "    Mobile.closeApplication()", "}"]
    return STANDARD_HEADER + "\n" + "\n".join(lines) + "\n"


def test_case_xml(name: str, description: str) -> str:
    guid = uuid.uuid5(uuid.NAMESPACE_URL, f"katalon://account-dashboard-time-deposits/test-case/{name}")
    return f'''<?xml version="1.0" encoding="UTF-8"?>
<TestCaseEntity>
    <description>{escape_xml(description)}</description>
    <name>{name}_Happy_Flow_Mobile</name>
    <tag>{escape_xml(TAG)}</tag>
    <comment></comment>
    <testCaseGuid>{guid}</testCaseGuid>
    <testCaseId>Test Cases/Account_Dashboard/{name}_Happy_Flow_Mobile</testCaseId>
    <isReuseDriver>false</isReuseDriver>
    <isRunNextCaseAutomatically>false</isRunNextCaseAutomatically>
    <testCaseType>Mobile</testCaseType>
</TestCaseEntity>
'''


def main() -> None:
    TEST_CASES.mkdir(parents=True, exist_ok=True)
    SCRIPTS.mkdir(parents=True, exist_ok=True)
    for name, section, requirement, steps in FLOWS:
        case_name = f"{name}_Happy_Flow_Mobile"
        script_dir = SCRIPTS / case_name
        script_dir.mkdir(parents=True, exist_ok=True)
        (script_dir / f"Script{case_name}.groovy").write_text(
            script_body(name, section, requirement, steps), encoding="utf-8"
        )
        (TEST_CASES / f"{case_name}.tc").write_text(
            test_case_xml(name, f"{section} - {requirement}"), encoding="utf-8"
        )
        print(f"Generated {case_name}")
    print(f"Generated {len(FLOWS)} Time Deposits happy-flow Test Cases under {TEST_CASES}")


if __name__ == "__main__":
    main()
