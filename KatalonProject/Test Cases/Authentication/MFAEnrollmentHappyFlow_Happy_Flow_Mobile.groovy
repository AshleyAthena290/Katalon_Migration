import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 4.0 MFA Enrollment - User enrolls a new MFA method
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/4-0-mfa-enrollment.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user is logged in.
    Mobile.tap(findTestObject('Android/mfaenrollmenthappyflow/securitysettings'), 10)
    Mobile.tap(findTestObject('Android/mfaenrollmenthappyflow/addauthenticationmethod'), 10)
    Mobile.tap(findTestObject('Android/mfaenrollmenthappyflow/smsotp'), 10)
    Mobile.setText(findTestObject('Android/mfaenrollmenthappyflow/phonenumberfield'), '+60123456789', 10)
    Mobile.tap(findTestObject('Android/mfaenrollmenthappyflow/sendotp'), 10)
    Mobile.setText(findTestObject('Android/mfaenrollmenthappyflow/otpfield'), '123456', 10)
    Mobile.tap(findTestObject('Android/mfaenrollmenthappyflow/confirm'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/mfaenrollmenthappyflow/mfamethodlisted'), 10)
} finally {
    Mobile.closeApplication()
}
