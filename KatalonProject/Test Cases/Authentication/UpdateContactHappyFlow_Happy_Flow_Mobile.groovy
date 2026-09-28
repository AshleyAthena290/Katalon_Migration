import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 13.0 Update Contact Details - User updates recovery contact details
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/13-0-update-contact-details.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user is logged in.
    Mobile.tap(findTestObject('Android/updatecontacthappyflow/profile'), 10)
    Mobile.tap(findTestObject('Android/updatecontacthappyflow/contactdetails'), 10)
    Mobile.setText(findTestObject('Android/updatecontacthappyflow/mobilenumber'), '+60123456789', 10)
    Mobile.tap(findTestObject('Android/updatecontacthappyflow/save'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/updatecontacthappyflow/contactupdatedconfirmation'), 10)
} finally {
    Mobile.closeApplication()
}
