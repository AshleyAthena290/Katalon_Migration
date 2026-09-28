"""Generate 20 Katalon happy-flow scripts from the Scan & Pay FSD.

Source: Input/FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx

Creates 20 flat `<Name>_Happy_Flow_Mobile.groovy` files under
`KatalonProject/Test Cases/Scan_and_Pay` following existing generator style.
"""

from __future__ import annotations

import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PROJECT = ROOT / "KatalonProject"
TEST_CASES = PROJECT / "Test Cases" / "Scan_and_Pay"

FSD_SOURCE = "FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx"
ARTIFACT_SLUG = "fsd-scan-and-pay-v2-0-20260612"


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
    ("ScanToPay", "1.0 Scan - Scan to Pay", "Customer scans merchant QR and completes payment",
     [("note", "Precondition: customer on Scan tab with camera permission."), ("tap", "Scan QR button"),
      ("note", "Simulate camera scan of merchant QR."), ("verify", "Payment details screen"),
      ("setText", "Amount field", "50"), ("tap", "Pay button"), ("verify", "Payment success")]),

    ("QRScanPayment", "1.1 QR Payment - Quick Pay", "Quick-pay flow via QR code scanning",
     [("note", "Precondition: app has network connectivity."), ("tap", "Scan QR button"),
      ("note", "Use test fixture QR payload."), ("tap", "Confirm payment"), ("verify", "Receipt screen")]),

    ("BillPaymentViaScan", "2.0 Scan Bill - Bill Payment", "Scan bill QR and pay bill",
     [("note", "Precondition: bill QR contains Biller ID and amount."), ("tap", "Scan bill"),
      ("verify", "Biller name"), ("setText", "Amount", "120.50"), ("tap", "Pay"), ("verify", "Payment confirmation")]),

    ("MerchantStaticQR", "2.1 Merchant Static QR", "Pay using merchant static QR code from gallery",
     [("note", "Precondition: user selects QR image from gallery."), ("tap", "Import QR from gallery"),
      ("verify", "Merchant details"), ("tap", "Pay"), ("verify", "Success")]),

    ("RequestMoneyQR", "3.0 Request Money via QR", "Merchant requests amount via dynamic QR",
     [("note", "Precondition: merchant generates dynamic QR."), ("tap", "Scan QR"),
      ("verify", "Requested amount"), ("tap", "Approve"), ("verify", "Request completed")]),

    ("PaymentWithSavedCard", "3.1 Saved Card Payment", "Complete payment using saved card on file",
     [("note", "Precondition: user has saved card."), ("tap", "Select saved card"),
      ("tap", "Pay"), ("verify", "3DS or OTP screen"), ("note", "Complete 3DS using fixture."),
      ("verify", "Payment success")]),

    ("AddNewCardDuringPayment", "4.0 Add Card During Payment", "Add card and pay in same flow",
     [("note", "Precondition: user chooses Add New Card."), ("setText", "Card number", "4111111111111111"),
      ("setText", "Expiry", "1225"), ("setText", "CVV", "123"), ("tap", "Add and Pay"),
      ("verify", "Payment success")]),

    ("SendMoneyToContact", "4.1 Send Money via QR to Contact", "Send money to contact by scanning their QR",
     [("note", "Precondition: contact has QR code linked to account."), ("tap", "Scan"),
      ("verify", "Contact name"), ("setText", "Amount", "20"), ("tap", "Send"), ("verify", "Success")]),

    ("SplitBillFlow", "5.0 Split Bill", "Split bill among multiple payers using QR split feature",
     [("note", "Precondition: merchant/organiser creates split request."), ("tap", "Scan split QR"),
      ("setText", "Share amount", "25"), ("tap", "Confirm"), ("verify", "Split accepted")]),

    ("RefundRequestFlow", "5.1 Refund Request", "Initiate refund flow after paying via scan",
     [("note", "Precondition: payment exists and is refundable."), ("tap", "Transactions"),
      ("tap", "Select payment"), ("tap", "Request refund"), ("verify", "Refund submitted")]),

    ("PaymentReceiptFlow", "6.0 Receipt View and Share", "View and share payment receipt",
     [("note", "Precondition: completed payment."), ("tap", "View receipt"),
      ("verify", "Receipt details"), ("tap", "Share"), ("verify", "Share sheet open")]),

    ("ViewTransactionHistory", "6.1 Transaction History", "View recent scan & pay transactions",
     [("tap", "Transactions tab"), ("verify", "Recent transactions list"), ("tap", "Transaction item"),
      ("verify", "Transaction detail")]),

    ("FavoriteMerchantFlow", "7.0 Favourite Merchant", "Add merchant to favourites after payment",
     [("note", "Precondition: payment completed."), ("tap", "Add to favourites"), ("verify", "Merchant in favourites")]),

    ("SaveQRCodeAsPayee", "7.1 Save QR as Payee", "Save scanned QR as a payee for future use",
     [("tap", "Scan"), ("note", "Scan merchant QR"), ("tap", "Save as payee"), ("setText", "Nickname", "Cafe"),
      ("tap", "Save"), ("verify", "Payee saved")]),

    ("OfflineQRCodeFlow", "8.0 Offline QR", "Process offline QR payloads (no network) using local validation",
     [("note", "Precondition: offline QR payload available."), ("tap", "Scan offline QR"),
      ("verify", "Offline payload parsed"), ("tap", "Store for later"), ("verify", "Stored pending payments")]),

    ("ScanAndPayWithPromo", "8.1 Promo Application", "Apply promo code during scan & pay",
     [("tap", "Scan"), ("verify", "Payment details"), ("setText", "Promo code", "PROMO10"),
      ("tap", "Apply"), ("verify", "Promo applied"), ("tap", "Pay"), ("verify", "Payment success")]),

    ("ScanAndPayWithLoyalty", "9.0 Loyalty Redemption", "Redeem loyalty points during scan & pay",
     [("note", "Precondition: user has loyalty points."), ("tap", "Use loyalty"), ("verify", "Points applied"),
      ("tap", "Pay"), ("verify", "Success")]),

    ("CancelPendingPayment", "9.1 Cancel Pending Payment", "Cancel an in-progress payment request",
     [("note", "Precondition: payment in pending state."), ("tap", "Pending payments"),
      ("tap", "Cancel"), ("verify", "Cancelled status")]),

    ("RetryFailedPayment", "10.0 Retry Failed Payment", "Retry a failed payment via scan",
     [("note", "Precondition: failed transaction exists."), ("tap", "Transactions"), ("tap", "Failed item"),
      ("tap", "Retry"), ("verify", "Success on retry")]),

    ("PaymentSettingsFlow", "10.1 Payment Settings", "Configure scan & pay preferences and limits",
     [("tap", "Settings"), ("tap", "Scan & Pay settings"), ("setText", "Daily limit", "1000"),
      ("tap", "Save"), ("verify", "Settings saved")]),
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
