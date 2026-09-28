import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 18.0 Authentication Audit - User views audit of recent auth events
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/18-0-authentication-audit.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: audit records exist.
    Mobile.tap(findTestObject('Android/authaudithappyflow/securitysettings'), 10)
    Mobile.tap(findTestObject('Android/authaudithappyflow/authenticationaudit'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/authaudithappyflow/recenteventslist'), 10)
} finally {
    Mobile.closeApplication()
}
