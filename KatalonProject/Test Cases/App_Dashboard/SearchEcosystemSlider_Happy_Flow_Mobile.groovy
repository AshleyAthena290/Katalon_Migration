import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 7.0 Search & Ecosys Slider(All) - Switch ecosystem and open search
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/7-0-search-ecosys-slider-all.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user has access to more than one ecosystem view (Banking/Wealth).
    Mobile.tap(findTestObject('Android/searchecosystemslider/'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/searchecosystemslider/ecosystemindicatordots'), 10)
    Mobile.tap(findTestObject('Android/searchecosystemslider/searchicon'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/searchecosystemslider/search'), 10)
} finally {
    Mobile.closeApplication()
}
