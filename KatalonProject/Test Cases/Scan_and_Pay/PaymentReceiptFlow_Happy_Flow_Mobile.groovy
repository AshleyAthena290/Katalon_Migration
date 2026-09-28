import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 6.0 Receipt View and Share - View and share payment receipt
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/6-0-receipt-view-and-share.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: completed payment.
    Mobile.tap(findTestObject('Android/paymentreceiptflow/viewreceipt'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/paymentreceiptflow/receiptdetails'), 10)
    Mobile.tap(findTestObject('Android/paymentreceiptflow/share'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/paymentreceiptflow/sharesheetopen'), 10)
} finally {
    Mobile.closeApplication()
}
