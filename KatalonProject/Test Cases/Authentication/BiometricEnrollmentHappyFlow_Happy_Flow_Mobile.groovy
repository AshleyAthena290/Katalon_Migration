import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 6.0 Biometric Enrollment - User enrolls fingerprint/face for auth
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/6-0-biometric-enrollment.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: device supports biometrics.
    Mobile.tap(findTestObject('Android/biometricenrollmenthappyflow/enablebiometrics'), 10)
    // Follow device biometric fixture to complete enrollment.
    Mobile.verifyElementVisible(findTestObject('Android/biometricenrollmenthappyflow/biometricenabledstate'), 10)
} finally {
    Mobile.closeApplication()
}
