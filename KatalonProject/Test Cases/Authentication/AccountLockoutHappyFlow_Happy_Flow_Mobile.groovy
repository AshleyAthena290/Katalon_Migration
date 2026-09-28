import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 8.0 Account Lockout - Account locks after configured failed attempts
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/8-0-account-lockout.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: account exists and is unlocked.
    Mobile.tap(findTestObject('Android/accountlockouthappyflow/usernamefield'), 10)
    Mobile.setText(findTestObject('Android/accountlockouthappyflow/usernamefield'), 'lockuser', 10)
    Mobile.tap(findTestObject('Android/accountlockouthappyflow/passwordfield'), 10)
    Mobile.setText(findTestObject('Android/accountlockouthappyflow/passwordfield'), 'wrong1', 10)
    Mobile.tap(findTestObject('Android/accountlockouthappyflow/loginbutton'), 10)
    Mobile.tap(findTestObject('Android/accountlockouthappyflow/passwordfield'), 10)
    Mobile.setText(findTestObject('Android/accountlockouthappyflow/passwordfield'), 'wrong2', 10)
    Mobile.tap(findTestObject('Android/accountlockouthappyflow/loginbutton'), 10)
    Mobile.tap(findTestObject('Android/accountlockouthappyflow/passwordfield'), 10)
    Mobile.setText(findTestObject('Android/accountlockouthappyflow/passwordfield'), 'wrong3', 10)
    Mobile.tap(findTestObject('Android/accountlockouthappyflow/loginbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/accountlockouthappyflow/accountlockedmessage'), 10)
} finally {
    Mobile.closeApplication()
}
