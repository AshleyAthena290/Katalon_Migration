import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 5.0 Security Image Setup - User sets security image successfully
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/5-0-security-image-setup.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user is in security setup flow.
    Mobile.tap(findTestObject('Android/securityimagesetuphappyflow/choosesecurityimage'), 10)
    Mobile.tap(findTestObject('Android/securityimagesetuphappyflow/defaultimage'), 10)
    Mobile.tap(findTestObject('Android/securityimagesetuphappyflow/saveimage'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/securityimagesetuphappyflow/securityimagesavedconfirmation'), 10)
} finally {
    Mobile.closeApplication()
}
