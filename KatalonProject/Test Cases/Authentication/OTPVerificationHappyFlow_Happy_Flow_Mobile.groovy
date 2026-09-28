import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 9.0 OTP Verification - OTP verification during sensitive flows
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/9-0-otp-verification.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: OTP-triggering action performed.
    Mobile.setText(findTestObject('Android/otpverificationhappyflow/otpfield'), '123456', 10)
    Mobile.tap(findTestObject('Android/otpverificationhappyflow/submitotp'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/otpverificationhappyflow/successconfirmation'), 10)
} finally {
    Mobile.closeApplication()
}
