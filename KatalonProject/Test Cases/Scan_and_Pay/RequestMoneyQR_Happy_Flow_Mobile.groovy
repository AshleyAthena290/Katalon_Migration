import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 3.0 Request Money via QR - Merchant requests amount via dynamic QR
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/3-0-request-money-via-qr.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: merchant generates dynamic QR.
    Mobile.tap(findTestObject('Android/requestmoneyqr/scanqr'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/requestmoneyqr/requestedamount'), 10)
    Mobile.tap(findTestObject('Android/requestmoneyqr/approve'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/requestmoneyqr/requestcompleted'), 10)
} finally {
    Mobile.closeApplication()
}
