import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 14.0 View Active Sessions - User views active sessions list
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/14-0-view-active-sessions.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: multiple active sessions exist.
    Mobile.tap(findTestObject('Android/viewsessionshappyflow/securitysettings'), 10)
    Mobile.tap(findTestObject('Android/viewsessionshappyflow/activesessions'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/viewsessionshappyflow/sessionlistvisible'), 10)
} finally {
    Mobile.closeApplication()
}
