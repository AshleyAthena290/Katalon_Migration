import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 16.0 Forced Update - Acknowledge forced OS update prompt
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/16-0-forced-update.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: device OS/app version is below the minimum required version on launch.
    Mobile.verifyElementVisible(findTestObject('Android/forcedupdate/updateyourdeviceos'), 10)
    Mobile.tap(findTestObject('Android/forcedupdate/updatenow'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/forcedupdate/appstore'), 10)
} finally {
    Mobile.closeApplication()
}
