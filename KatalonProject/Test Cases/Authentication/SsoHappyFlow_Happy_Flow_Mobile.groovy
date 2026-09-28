import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 19.0 SSO Integration - User authenticates via enterprise SSO (happy path)
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/19-0-sso-integration.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: SSO configured for tenant.
    Mobile.tap(findTestObject('Android/ssohappyflow/signinwithsso'), 10)
    // Follow SSO provider fixture to complete auth.
    Mobile.verifyElementVisible(findTestObject('Android/ssohappyflow/homedashboard'), 10)
} finally {
    Mobile.closeApplication()
}
