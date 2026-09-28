import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 2.0 Change Password - User changes password successfully
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/2-0-change-password.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user is logged in.
    Mobile.tap(findTestObject('Android/changepasswordhappyflow/settings'), 10)
    Mobile.tap(findTestObject('Android/changepasswordhappyflow/changepassword'), 10)
    Mobile.setText(findTestObject('Android/changepasswordhappyflow/currentpassword'), 'password123', 10)
    Mobile.setText(findTestObject('Android/changepasswordhappyflow/newpassword'), 'newPassword123', 10)
    Mobile.setText(findTestObject('Android/changepasswordhappyflow/confirmnewpassword'), 'newPassword123', 10)
    Mobile.tap(findTestObject('Android/changepasswordhappyflow/savebutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/changepasswordhappyflow/passwordchangedconfirmation'), 10)
} finally {
    Mobile.closeApplication()
}
