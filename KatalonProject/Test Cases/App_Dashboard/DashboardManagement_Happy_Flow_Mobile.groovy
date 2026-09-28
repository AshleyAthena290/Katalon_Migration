import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 12.0 Dashboard Management - Set the default home dashboard view
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/12-0-dashboard-management.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user opens Settings > Home dashboard view.
    Mobile.tap(findTestObject('Android/dashboardmanagement/sethomedashboard'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/dashboardmanagement/homedashboardview'), 10)
    Mobile.tap(findTestObject('Android/dashboardmanagement/homeviewslider'), 10)
    Mobile.tap(findTestObject('Android/dashboardmanagement/set'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/dashboardmanagement/home'), 10)
} finally {
    Mobile.closeApplication()
}
