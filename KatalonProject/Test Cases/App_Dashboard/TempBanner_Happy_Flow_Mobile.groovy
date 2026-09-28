import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 10.0 Temp Banner (All) - Open and dismiss a regulatory-update temp banner
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/10-0-temp-banner-all.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: a regulatory-update temporary banner is active on the default dashboard.
    Mobile.verifyElementVisible(findTestObject('Android/tempbanner/tempbannerregulatoryupdates'), 10)
    Mobile.tap(findTestObject('Android/tempbanner/tempbannerregulatoryupdates'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/tempbanner/regulatoryupdates'), 10)
    Mobile.tap(findTestObject('Android/tempbanner/okay'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/tempbanner/home'), 10)
} finally {
    Mobile.closeApplication()
}
