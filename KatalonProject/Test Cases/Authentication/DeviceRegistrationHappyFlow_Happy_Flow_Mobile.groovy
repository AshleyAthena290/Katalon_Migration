import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 10.0 Device Registration - Register a new device for remembered device list
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/10-0-device-registration.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user completes login on a new device.
    Mobile.tap(findTestObject('Android/deviceregistrationhappyflow/rememberthisdevice'), 10)
    Mobile.tap(findTestObject('Android/deviceregistrationhappyflow/registerdevice'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/deviceregistrationhappyflow/deviceregisteredconfirmation'), 10)
} finally {
    Mobile.closeApplication()
}
