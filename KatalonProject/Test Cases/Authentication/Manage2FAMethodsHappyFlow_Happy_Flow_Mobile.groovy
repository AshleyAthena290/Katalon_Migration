import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 15.0 Manage 2FA Methods - User adds/removes 2FA methods
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/15-0-manage-2fa-methods.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user is logged in.
    Mobile.tap(findTestObject('Android/manage2famethodshappyflow/securitysettings'), 10)
    Mobile.tap(findTestObject('Android/manage2famethodshappyflow/twofactormethods'), 10)
    Mobile.tap(findTestObject('Android/manage2famethodshappyflow/addmethod'), 10)
    Mobile.tap(findTestObject('Android/manage2famethodshappyflow/sms'), 10)
    Mobile.tap(findTestObject('Android/manage2famethodshappyflow/save'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/manage2famethodshappyflow/2famethodpresentinlist'), 10)
} finally {
    Mobile.closeApplication()
}
