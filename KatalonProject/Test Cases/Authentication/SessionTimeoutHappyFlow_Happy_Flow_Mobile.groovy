import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 7.0 Session Timeout - User session times out and is re-authenticated
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/7-0-session-timeout.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user is logged in.
    // Simulate inactivity until session timeout.
    Mobile.verifyElementVisible(findTestObject('Android/sessiontimeouthappyflow/sessionexpiredscreen'), 10)
    Mobile.tap(findTestObject('Android/sessiontimeouthappyflow/relogin'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/sessiontimeouthappyflow/homedashboard'), 10)
} finally {
    Mobile.closeApplication()
}
