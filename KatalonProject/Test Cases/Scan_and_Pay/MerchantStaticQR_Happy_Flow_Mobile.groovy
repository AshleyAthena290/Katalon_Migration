import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 2.1 Merchant Static QR - Pay using merchant static QR code from gallery
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/2-1-merchant-static-qr.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user selects QR image from gallery.
    Mobile.tap(findTestObject('Android/merchantstaticqr/importqrfromgallery'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/merchantstaticqr/merchantdetails'), 10)
    Mobile.tap(findTestObject('Android/merchantstaticqr/pay'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/merchantstaticqr/success'), 10)
} finally {
    Mobile.closeApplication()
}
