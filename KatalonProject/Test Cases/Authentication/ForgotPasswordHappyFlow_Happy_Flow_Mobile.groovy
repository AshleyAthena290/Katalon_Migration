import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 3.0 Forgot Password - User recovers password via OTP
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/3-0-forgot-password.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user has registered phone/email.
    Mobile.tap(findTestObject('Android/forgotpasswordhappyflow/forgotpasswordlink'), 10)
    Mobile.setText(findTestObject('Android/forgotpasswordhappyflow/registeredemailorphone'), 'testuser@example.com', 10)
    Mobile.tap(findTestObject('Android/forgotpasswordhappyflow/requestotp'), 10)
    // Business rule: OTP delivered to registered channel in non-production fixture.
    Mobile.setText(findTestObject('Android/forgotpasswordhappyflow/otpfield'), '123456', 10)
    Mobile.tap(findTestObject('Android/forgotpasswordhappyflow/proceed'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/forgotpasswordhappyflow/resetpasswordscreen'), 10)
} finally {
    Mobile.closeApplication()
}
