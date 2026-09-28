"""Generate 20 Katalon happy-flow scripts from the Local Transfer FSD.

Source: Input/FSD_Local_Transfer_v2.0@20260612.xlsx

Scope: 20 happy flows covering the FSD's functional sections, excluding
reference-only sheets (`1.1.2.1 LLD & FOREX Matrix`, `1.1.7.1 Receipt w
Theme`). The end-to-end transfer journey (sections 1.0 through 1.1.8) is
combined into a single "LocalTransfer" happy flow since those sections are
sequential steps of one flow rather than independent features:
  1.  LocalTransfer                        (1.0 - 1.1.8)
  2.  RecipientCreateNewList                (1.2)
  3.  RecipientAddNote                      (1.2.1)
  4.  RecipientAddToFavourite               (1.2.2)
  5.  RecipientEditFavourite                (1.2.3)
  6.  RecipientRemoveFromTab                (1.2.4)
  7.  RecipientEditDeleteNote               (1.2.5)
  8.  ManageFavouriteDashboard              (1.3)
  9.  ManageFavouriteDetailGroup            (1.3.1)
  10. ManageFavouriteAddFromAccountNumber   (1.3.2)
  11. ManageFavouriteAddFromRecentTransfer  (1.3.3)
  12. ManageFavouriteFinal                  (1.3.4)
  13. ManageFavouriteEditRemoveGroup        (1.3.5)
  14. TransferSettingsManageScheduledDashboard (1.4)
  15. TransferSettingsManageScheduledList   (1.4.1)
  16. TransferSettingsRemoveRecurringDetail (1.4.2)
  17. TransferSettingsManageLimitDashboard  (1.4.3)
  18. TransferSettingsManageLimitList       (1.4.4)
  19. TransferSettingsManageLimitDetail     (1.4.5)
  20. DataExtraction                        (1.5)

Output style mirrors the existing `Test Cases/Account_Dashboard/` scaffold:
flat `<Name>_Happy_Flow_Mobile.groovy` files with FSD/traceability header
comments and Precondition/Action/Business rule comments.
"""

from __future__ import annotations

import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PROJECT = ROOT / "KatalonProject"
TEST_CASES = PROJECT / "Test Cases" / "Local_Transfer"

FSD_SOURCE = "FSD_Local_Transfer_v2.0@20260612.xlsx"
ARTIFACT_SLUG = "fsd-local-transfer-v2-0-20260612"


def slugify(value: str) -> str:
    return re.sub(r"[^a-z0-9]+", "-", value.lower()).strip("-")


def control_slug(value: str) -> str:
    return re.sub(r"[^a-z0-9]+", "", value.lower())


# Each step is one of:
#   ("verify", "Human label")           -> Mobile.verifyElementVisible
#   ("tap", "Human label")              -> Mobile.tap
#   ("setText", "Human label", "value") -> Mobile.setText
#   ("note", "Precondition/Action/Business rule text") -> plain comment
FLOWS: list[tuple[str, str, str, list[tuple]]] = [
    ("LocalTransfer", "1.0 - 1.1.8 Transfer Intro to Notification",
     "End-to-end local transfer to an existing beneficiary",
     [("note", "Precondition: user is logged in with an active primary account and at least one beneficiary."),
      ("tap", "Get Started"),
      ("verify", "Search Beneficiaries"),
      ("tap", "Beneficiary Lists selection"),
      ("setText", "Amount", "500000"),
      ("tap", "Input Amount Next button"),
      ("tap", "Transfer Details Next button"),
      ("verify", "Confirmation Title header"),
      ("tap", "Confirm button"),
      ("verify", "Status Icon & Status"),
      ("tap", "Done button"),
      ("note", "Business rule: push and email notification is sent to the sender upon a successful transfer."),
      ("verify", "Search Beneficiaries")]),
    ("RecipientCreateNewList", "1.2 Recipient - Create New",
     "Create a new custom recipient list",
     [("note", "Precondition: user navigates to Recipient list management from the Transfer Landing Page."),
      ("tap", "Add Recipient button"),
      ("setText", "List Name", "Family"),
      ("tap", "Select Recipients"),
      ("tap", "Save button"),
      ("tap", "Create list button"),
      ("note", "Business rule: the (+) Create New List button is hidden once the maximum number of lists is reached."),
      ("verify", "Selected Recipients Section")]),
    ("RecipientAddNote", "1.2.1 Recipient - Add Note",
     "Add a nickname note to a beneficiary",
     [("note", "Precondition: beneficiary exists in the All, Frequent, Favourite, or Custom list."),
      ("tap", "Long press Beneficiary"),
      ("tap", "Add nickname"),
      ("setText", "Nickname", "MyFriend"),
      ("tap", "Save nickname button"),
      ("verify", "Beneficiary Nickname")]),
    ("RecipientAddToFavourite", "1.2.2 Recipient - Add to Fav",
     "Add a beneficiary to a favourites list",
     [("note", "Precondition: beneficiary is long-pressed from the Transfer Landing Page."),
      ("tap", "Add to favourites"),
      ("verify", "Select a favourites list title"),
      ("tap", "Favourites list"),
      ("note", "Business rule: adding to the Favourites list requires Secure2u authorisation."),
      ("tap", "Save button"),
      ("verify", "Status Image & Status"),
      ("tap", "Done button")]),
    ("RecipientEditFavourite", "1.2.3 Recipient - Edit Fav",
     "Edit a beneficiary's favourite list membership",
     [("note", "Precondition: beneficiary is already saved to a favourites list."),
      ("tap", "Edit favourites list"),
      ("tap", "Favourites list"),
      ("tap", "Save button"),
      ("verify", "Status Image & Status")]),
    ("RecipientRemoveFromTab", "1.2.4 Recipient - Remove Fr Tab",
     "Remove a beneficiary from the All tab",
     [("note", "Precondition: beneficiary exists in the All tab."),
      ("tap", "Remove"),
      ("verify", "Pop up Title"),
      ("tap", "Remove button"),
      ("note", "Business rule: removing from the All tab also removes the beneficiary from Frequent, Favourite, and Custom tabs."),
      ("verify", "Status Image & Status"),
      ("tap", "Done button")]),
    ("RecipientEditDeleteNote", "1.2.5 Recipient - Edit Del Note",
     "Edit an existing beneficiary nickname",
     [("note", "Precondition: beneficiary already has a nickname set."),
      ("tap", "Edit Nickname"),
      ("setText", "Beneficiary Nickname", "BestFriend"),
      ("tap", "Save button"),
      ("verify", "Beneficiary Nickname")]),
    ("ManageFavouriteDashboard", "1.3 Manage Fav - Dashboard",
     "Open the Manage Favourite List dashboard",
     [("note", "Precondition: user navigates to Manage Favourite List from Settings or the Transfer Landing Page."),
      ("verify", "Manage lists Title"),
      ("tap", "Local/Overseas Tab"),
      ("verify", "Favourite Group List")]),
    ("ManageFavouriteDetailGroup", "1.3.1 Manage Fav - Detail Group",
     "Open a favourites/custom group and add a recipient",
     [("note", "Precondition: user opens a favourites/custom group from the Manage Favourite dashboard."),
      ("tap", "Favourites Title"),
      ("tap", "Add recipient button"),
      ("verify", "Drawer title"),
      ("tap", "Past transfers"),
      ("verify", "Account Number")]),
    ("ManageFavouriteAddFromAccountNumber", "1.3.2 Manage Fav Add fr Acct No",
     "Add a new favourite by entering an account number",
     [("note", "Precondition: user chooses to add a new favourite by entering an account number."),
      ("setText", "Account Number", "1234567890"),
      ("setText", "Nickname", "NewFriend"),
      ("tap", "Next button"),
      ("note", "Business rule: mandatory-field checking is performed before proceeding."),
      ("verify", "Reminder message")]),
    ("ManageFavouriteAddFromRecentTransfer", "1.3.3 Mng Fav Add fr Recent Trf",
     "Add a favourite from a recent/past transfer",
     [("note", "Precondition: user chooses to add a favourite from a recent/past transfer."),
      ("tap", "Beneficiary List"),
      ("setText", "Nickname", "RecentFriend"),
      ("tap", "Next button"),
      ("verify", "Title header")]),
    ("ManageFavouriteFinal", "1.3.4 Manage Fav - Final",
     "Confirm a successful add-to-favourites request",
     [("note", "Precondition: the add-to-favourites request has been submitted for confirmation."),
      ("verify", "Status Image & Status"),
      ("verify", "Account Holder Name"),
      ("tap", "Done button")]),
    ("ManageFavouriteEditRemoveGroup", "1.3.5 Mng Fav Edit Remove Grp",
     "Remove a favourites/custom list",
     [("note", "Precondition: user opens an existing favourites/custom list to manage it from Settings."),
      ("tap", "Trash Icon"),
      ("verify", "Remove List button"),
      ("tap", "Remove List button"),
      ("verify", "Remove button"),
      ("tap", "Remove button"),
      ("verify", "Status Image & Status")]),
    ("TransferSettingsManageScheduledDashboard", "1.4 Tf Set Mng Sch Trf Dboard",
     "Open the Manage Scheduled Transfer dashboard",
     [("note", "Precondition: user opens Settings > Manage Scheduled Transfer dashboard."),
      ("tap", "Transfer selection"),
      ("verify", "Menu options")]),
    ("TransferSettingsManageScheduledList", "1.4.1 Tf Set Mng Sch Trf List",
     "Filter the scheduled/recurring transfer list",
     [("note", "Precondition: at least one active scheduled or recurring transfer exists."),
      ("verify", "Title Header"),
      ("tap", "Filter icon"),
      ("tap", "Apply button"),
      ("verify", "Beneficiary Name")]),
    ("TransferSettingsRemoveRecurringDetail", "1.4.2 Tf Set Rmv Recur Detail",
     "Cancel a scheduled/recurring transfer",
     [("note", "Precondition: user opens a scheduled/recurring transaction detail screen."),
      ("tap", "Cancel button"),
      ("verify", "Title"),
      ("tap", "Cancel button confirm"),
      ("verify", "Status Image & Status"),
      ("tap", "Done button")]),
    ("TransferSettingsManageLimitDashboard", "1.4.3 Tf Set Mng Limit Dboard",
     "Open the Manage Limits dashboard",
     [("note", "Precondition: user opens Settings > Manage Limits dashboard."),
      ("tap", "Transfer limits"),
      ("verify", "Menu options")]),
    ("TransferSettingsManageLimitList", "1.4.4 Tf Set Mng Limit List",
     "Open the transfer limit list for a transfer mode",
     [("note", "Precondition: user opens the transfer limit list for a specific transfer mode."),
      ("verify", "Reminder message"),
      ("tap", "Menu Transfer Mode"),
      ("verify", "Transfer mode selections")]),
    ("TransferSettingsManageLimitDetail", "1.4.5 Tf Set Mng Limit Det",
     "Update a transfer limit",
     [("note", "Precondition: user selects a specific transfer mode's limit detail screen."),
      ("verify", "Current Limit"),
      ("tap", "Select new limit selection"),
      ("tap", "Save Button"),
      ("note", "Business rule: for ID, a successful limit update takes effect immediately with no cooling-off period."),
      ("verify", "Status Image & Status"),
      ("tap", "Done")]),
    ("DataExtraction", "1.5 Data Extraction",
     "Verify Local Transfer data extraction module availability",
     [("note", "Precondition: Local Transfer data extraction module is configured in NGBO/back office."),
      ("verify", "Local Transfer"),
      ("note", "Business rule: scheduled/recurring SKN/RTGS transactions and their recurring originations are covered per extraction notes.")]),
]


def object_ref(flow_slug: str, label: str) -> str:
    return f"findTestObject('Android/{flow_slug}/{control_slug(label)}')"


def script_body(flow_name: str, section: str, requirement: str, steps: list[tuple]) -> str:
    flow_slug = slugify(flow_name)
    artifact_path = f"artifacts/{ARTIFACT_SLUG}/test-cases/{slugify(section)}.test-cases.json"
    lines = [
        "import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject",
        "",
        "import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile",
        "",
        f"// FSD: {FSD_SOURCE} | Feature: {section} - {requirement}",
        f"// Traceability: {artifact_path}",
        "// TODO: Replace with the configured Maybank Android application path or APK.",
        "// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.",
        "Mobile.startApplication('path/to/Maybank.apk', false)",
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
    return "\n".join(lines) + "\n"


def main() -> None:
    TEST_CASES.mkdir(parents=True, exist_ok=True)
    for flow_name, section, requirement, steps in FLOWS:
        (TEST_CASES / f"{flow_name}_Happy_Flow_Mobile.groovy").write_text(
            script_body(flow_name, section, requirement, steps), encoding="utf-8", newline="\n"
        )
    print(f"Generated {len(FLOWS)} happy-flow scripts under {TEST_CASES}")


if __name__ == "__main__":
    main()
