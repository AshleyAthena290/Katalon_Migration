import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 1.0 Scan - Scan to Pay - Customer scans merchant QR and completes payment
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/1-0-scan-scan-to-pay.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: customer on Scan tab with camera permission.
    Mobile.tap(findTestObject('Android/scantopay/scanqrbutton'), 10)
    // Simulate camera scan of merchant QR.
    Mobile.verifyElementVisible(findTestObject('Android/scantopay/paymentdetailsscreen'), 10)
    Mobile.setText(findTestObject('Android/scantopay/amountfield'), '50', 10)
    Mobile.tap(findTestObject('Android/scantopay/paybutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/scantopay/paymentsuccess'), 10)
} finally {
    Mobile.closeApplication()
}
