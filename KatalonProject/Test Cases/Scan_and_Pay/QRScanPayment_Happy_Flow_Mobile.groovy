import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 1.1 QR Payment - Quick Pay - Quick-pay flow via QR code scanning
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/1-1-qr-payment-quick-pay.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: app has network connectivity.
    Mobile.tap(findTestObject('Android/qrscanpayment/scanqrbutton'), 10)
    // Use test fixture QR payload.
    Mobile.tap(findTestObject('Android/qrscanpayment/confirmpayment'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/qrscanpayment/receiptscreen'), 10)
} finally {
    Mobile.closeApplication()
}
