import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 4.1 MFA Login - User logs in with MFA enabled
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/4-1-mfa-login.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user has MFA configured.
    Mobile.tap(findTestObject('Android/mfaloginhappyflow/usernamefield'), 10)
    Mobile.setText(findTestObject('Android/mfaloginhappyflow/usernamefield'), 'mfauser', 10)
    Mobile.tap(findTestObject('Android/mfaloginhappyflow/passwordfield'), 10)
    Mobile.setText(findTestObject('Android/mfaloginhappyflow/passwordfield'), 'password123', 10)
    Mobile.tap(findTestObject('Android/mfaloginhappyflow/loginbutton'), 10)
    Mobile.setText(findTestObject('Android/mfaloginhappyflow/otpfield'), '123456', 10)
    Mobile.tap(findTestObject('Android/mfaloginhappyflow/verify'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/mfaloginhappyflow/homedashboard'), 10)
} finally {
    Mobile.closeApplication()
}
