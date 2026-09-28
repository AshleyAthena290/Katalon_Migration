import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 11.0 Remember Me - User enables remember-me for faster login
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/11-0-remember-me.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: login screen visible.
    Mobile.tap(findTestObject('Android/remembermehappyflow/remembermecheckbox'), 10)
    Mobile.tap(findTestObject('Android/remembermehappyflow/loginbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/remembermehappyflow/nextloginusesremembereddevicecredential'), 10)
} finally {
    Mobile.closeApplication()
}
