import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 17.0 Recovery Options - User configures recovery options successfully
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/17-0-recovery-options.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user is logged in.
    Mobile.tap(findTestObject('Android/recoveryoptionshappyflow/recoveryoptions'), 10)
    Mobile.tap(findTestObject('Android/recoveryoptionshappyflow/addrecoveryemail'), 10)
    Mobile.setText(findTestObject('Android/recoveryoptionshappyflow/recoveryemail'), 'recovery@example.com', 10)
    Mobile.tap(findTestObject('Android/recoveryoptionshappyflow/save'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/recoveryoptionshappyflow/recoveryconfigured'), 10)
} finally {
    Mobile.closeApplication()
}
