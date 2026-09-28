import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 12.0 Revoke Device - User revokes a registered device from their profile
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/12-0-revoke-device.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user has at least one registered device.
    Mobile.tap(findTestObject('Android/revokedevicehappyflow/registereddevices'), 10)
    Mobile.tap(findTestObject('Android/revokedevicehappyflow/deviceoptions'), 10)
    Mobile.tap(findTestObject('Android/revokedevicehappyflow/revoke'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/revokedevicehappyflow/deviceremovedfromlist'), 10)
} finally {
    Mobile.closeApplication()
}
