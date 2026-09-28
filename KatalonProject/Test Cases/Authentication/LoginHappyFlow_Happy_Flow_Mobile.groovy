import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 1.0 Login - Successful Login - User logs in with valid credentials
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/1-0-login-successful-login.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user has a registered account.
    Mobile.tap(findTestObject('Android/loginhappyflow/usernamefield'), 10)
    Mobile.setText(findTestObject('Android/loginhappyflow/usernamefield'), 'testuser', 10)
    Mobile.tap(findTestObject('Android/loginhappyflow/passwordfield'), 10)
    Mobile.setText(findTestObject('Android/loginhappyflow/passwordfield'), 'password123', 10)
    Mobile.tap(findTestObject('Android/loginhappyflow/loginbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/loginhappyflow/homedashboard'), 10)
} finally {
    Mobile.closeApplication()
}
