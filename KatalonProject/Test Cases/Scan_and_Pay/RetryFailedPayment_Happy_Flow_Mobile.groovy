import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 10.0 Retry Failed Payment - Retry a failed payment via scan
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/10-0-retry-failed-payment.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: failed transaction exists.
    Mobile.tap(findTestObject('Android/retryfailedpayment/transactions'), 10)
    Mobile.tap(findTestObject('Android/retryfailedpayment/faileditem'), 10)
    Mobile.tap(findTestObject('Android/retryfailedpayment/retry'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/retryfailedpayment/successonretry'), 10)
} finally {
    Mobile.closeApplication()
}
