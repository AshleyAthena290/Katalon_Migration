"""Generate 20 Katalon happy-flow scripts from the App Dashboard (Banking & Wealth) FSD.

Source: Input/FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx

Scope: one happy-flow script per FSD functional section, excluding the
sections that are reference-only or describe error/blocked states rather than
a happy path:
  - 4.1 Benefits Tiers (Ref. only)
  - 15.0 ErrConn. Lost&Serv Unavail
  - 17.0 Hard_Soft Block
This leaves exactly 20 sections / happy flows.

Output style mirrors the existing `Test Cases/Account_Dashboard/` scaffold:
flat `<Name>_Happy_Flow_Mobile.groovy` files directly under
`Test Cases/App_Dashboard/`, with FSD/traceability header comments and
Precondition/Action/Business rule comments instead of separate Scripts/,
Object Repository .rs, and .tc descriptor files.
"""

from __future__ import annotations

import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PROJECT = ROOT / "KatalonProject"
TEST_CASES = PROJECT / "Test Cases" / "App_Dashboard"

FSD_SOURCE = "FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx"
ARTIFACT_SLUG = "fsd-app-dashboard-banking-wealth-v2-0-20260421"


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
    ("HomeTopBar", "1.0 Home-Top Bar (All)",
     "Home top bar profile and notification access",
     [("note", "Precondition: user is logged in and on the App Dashboard home screen."),
      ("verify", "Profile picture"),
      ("tap", "Notification icon"),
      ("note", "Business rule: if unread notifications > 0, the notification icon shows a red dot."),
      ("verify", "Notifications")]),
    ("QuickActions", "3.0 Quick Actions (All)",
     "Launch a Quick Action from the home dashboard",
     [("note", "Precondition: user is on the home dashboard with Quick Actions configured."),
      ("verify", "Quick Actions"),
      ("tap", "Transfer"),
      ("note", "Business rule: if the action is unavailable, show a disabled message instead of navigating."),
      ("verify", "Transfer")]),
    ("MainDisplayAmount", "2.0 Main Display Amt (All)",
     "Toggle balance visibility and open account details",
     [("note", "Precondition: user has a primary account with a non-empty main display amount."),
      ("tap", "Eye Icon"),
      ("tap", "Product Name"),
      ("note", "Business rule: non-IDR currency balances are converted and displayed with the account's currency code."),
      ("verify", "Account Details")]),
    ("PrivilegePremier", "4.0 2Ps-Privilege & Premier",
     "View 2Ps rewards & benefits and explore tiers",
     [("note", "Precondition: user is a 2Ps (Privilege or Premier) customer."),
      ("tap", "Features tab"),
      ("verify", "Benefits (list)"),
      ("tap", "Explore all tiers & benefits"),
      ("verify", "Benefits & Tiers")]),
    ("ClassUpDowngrade", "4.2 2Ps Class Up & Downgrade",
     "Acknowledge class level-up celebratory drawer",
     [("note", "Precondition: NGA has flagged a customer type upgrade to Privilege/Premier."),
      ("verify", "Congratulations! You've been upgraded"),
      ("tap", "View your new dashboard"),
      ("note", "Business rule: a push notification is also sent whenever there is a level up or down."),
      ("verify", "Home")]),
    ("ForYou", "5.0 For you (All)",
     "Open a For you tile",
     [("note", "Precondition: at least one active, non-expired 'For you' tile is configured."),
      ("verify", "For you tile 1"),
      ("tap", "For you tile 1"),
      ("verify", "For you")]),
    ("SBento", "6.1 S Bento (All)",
     "Open S Bento details",
     [("note", "Precondition: S Bento widget is configured for the active dashboard/ecosystem."),
      ("verify", "S Bento"),
      ("tap", "S Bento"),
      ("verify", "Details")]),
    ("MBento", "6.2 M Bento (All)",
     "Open M Bento destination",
     [("note", "Precondition: M Bento is displayed based on configurable time/account criteria."),
      ("verify", "M Bento"),
      ("tap", "M Bento"),
      ("note", "Business rule: tapping M Bento navigates to either an existing NGA screen or a web page."),
      ("verify", "Details")]),
    ("LBento", "6.3 L Bento (All)",
     "Open the Money Out tile from L Bento",
     [("note", "Precondition: L Bento is available with the default widget or Money Out data present."),
      ("verify", "L Bento"),
      ("tap", "Money out tile"),
      ("verify", "Money Out")]),
    ("SearchEcosystemSlider", "7.0 Search & Ecosys Slider(All)",
     "Switch ecosystem and open search",
     [("note", "Precondition: user has access to more than one ecosystem view (Banking/Wealth)."),
      ("tap", "[>]"),
      ("verify", "Ecosystem indicator dots"),
      ("tap", "Search icon"),
      ("verify", "Search")]),
    ("Navbar", "8.0 Navbar (All)",
     "Navigate between Accounts and Home via the navbar",
     [("note", "Precondition: navbar is visible at Level 0 (primary sections)."),
      ("tap", "Accounts"),
      ("verify", "Accounts"),
      ("tap", "Home"),
      ("verify", "Home")]),
    ("NavbarMenu", "9.0 Navbar Menu (All)",
     "Open the menu and search for an item",
     [("note", "Precondition: user opens the Menu from the navbar."),
      ("tap", "Menu"),
      ("verify", "Menu"),
      ("setText", "Search Bar", "Transfer"),
      ("note", "Business rule: menu search covers items listed in the Menu, e.g. Apply/Accounts."),
      ("verify", "Search results")]),
    ("TempBanner", "10.0 Temp Banner (All)",
     "Open and dismiss a regulatory-update temp banner",
     [("note", "Precondition: a regulatory-update temporary banner is active on the default dashboard."),
      ("verify", "Temp Banner - Regulatory updates"),
      ("tap", "Temp Banner - Regulatory updates"),
      ("verify", "Regulatory updates"),
      ("tap", "Okay"),
      ("verify", "Home")]),
    ("ActionList", "10.1 Action List",
     "Open action nudge list and act on a Credit Card Activation item",
     [("note", "Precondition: user is logged in with at least one pending action, e.g. Credit Card Activation."),
      ("tap", "Action icon"),
      ("verify", "Actions"),
      ("tap", "Credit Card Activation"),
      ("note", "Business rule: Credit Card Activation links to the specific card for activation."),
      ("verify", "Card Activation")]),
    ("CCHolderApplyCASA", "11.0 CC Holder Only-Apply CASA",
     "CC-holder-only customer applies for a Savings Account",
     [("note", "Precondition: user only holds a credit card and has no CASA account."),
      ("tap", "Apply now"),
      ("verify", "New application"),
      ("tap", "Savings Account"),
      ("verify", "Savings Account Application")]),
    ("DashboardManagement", "12.0 Dashboard Management",
     "Set the default home dashboard view",
     [("note", "Precondition: user opens Settings > Home dashboard view."),
      ("tap", "Set home dashboard"),
      ("verify", "Home dashboard view"),
      ("tap", "Home view slider"),
      ("tap", "Set"),
      ("verify", "Home")]),
    ("PreLogin", "13.0 Pre-Login (All)",
     "Pre-login dashboard prompts login",
     [("note", "Precondition: user has logged out or the session has not been established (pre-login state)."),
      ("verify", "Profile picture"),
      ("tap", "Log in icon"),
      ("verify", "Log in")]),
    ("PreBinded", "14.0 Pre-Binded(Explore Dboard)",
     "Pre-binded zero-state customer opens an account",
     [("note", "Precondition: customer has no bound account yet (zero state / pre-binded)."),
      ("verify", "Pre-binded description"),
      ("tap", "Open account"),
      ("verify", "Open an account")]),
    ("ForcedUpdate", "16.0 Forced Update",
     "Acknowledge forced OS update prompt",
     [("note", "Precondition: device OS/app version is below the minimum required version on launch."),
      ("verify", "Update your device OS"),
      ("tap", "Update now"),
      ("verify", "App Store")]),
    ("S2UCoolingOffPeriod", "18.0 S2U Cooling off Period",
     "View Secure2u cooling-off period notice and proceed",
     [("note", "Precondition: Secure2u setup was just completed and the cooling-off countdown has started."),
      ("verify", "Secure2u activation"),
      ("verify", "Cooling off period"),
      ("tap", "Proceed"),
      ("verify", "Home")]),
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
