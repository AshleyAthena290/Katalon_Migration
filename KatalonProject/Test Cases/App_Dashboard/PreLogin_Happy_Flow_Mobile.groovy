import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 13.0 Pre-Login (All) - Pre-login dashboard prompts login
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/13-0-pre-login-all.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user has logged out or the session has not been established (pre-login state).
    Mobile.verifyElementVisible(findTestObject('Android/prelogin/profilepicture'), 10)
    Mobile.tap(findTestObject('Android/prelogin/loginicon'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/prelogin/login'), 10)
} finally {
    Mobile.closeApplication()
}
