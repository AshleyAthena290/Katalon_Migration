import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 6.1 Biometric Login - User authenticates via biometrics
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/6-1-biometric-login.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: biometrics enrolled.
    Mobile.tap(findTestObject('Android/biometricloginhappyflow/usebiometric'), 10)
    // Authenticate using test biometric fixture.
    Mobile.verifyElementVisible(findTestObject('Android/biometricloginhappyflow/homedashboard'), 10)
} finally {
    Mobile.closeApplication()
}
