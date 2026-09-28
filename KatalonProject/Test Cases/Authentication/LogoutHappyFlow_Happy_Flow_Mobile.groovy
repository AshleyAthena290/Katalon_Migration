import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 1.1 Logout - Successful Logout - User logs out safely
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/1-1-logout-successful-logout.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user is logged in.
    Mobile.tap(findTestObject('Android/logouthappyflow/profilemenu'), 10)
    Mobile.tap(findTestObject('Android/logouthappyflow/logoutbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/logouthappyflow/loginscreen'), 10)
} finally {
    Mobile.closeApplication()
}
