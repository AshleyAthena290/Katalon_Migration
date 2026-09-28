import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 20.0 Account Recovery - User performs account recovery via support flow
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/20-0-account-recovery.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user begins recovery flow.
    Mobile.tap(findTestObject('Android/accountrecoveryhappyflow/contactsupport'), 10)
    Mobile.tap(findTestObject('Android/accountrecoveryhappyflow/startrecovery'), 10)
    Mobile.setText(findTestObject('Android/accountrecoveryhappyflow/customerreference'), 'REF12345', 10)
    Mobile.tap(findTestObject('Android/accountrecoveryhappyflow/submit'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/accountrecoveryhappyflow/recoverysubmittedconfirmation'), 10)
} finally {
    Mobile.closeApplication()
}
