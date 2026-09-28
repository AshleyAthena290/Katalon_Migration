import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.3 Manage Fav - Dashboard - Open the Manage Favourite List dashboard
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-3-manage-fav-dashboard.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user navigates to Manage Favourite List from Settings or the Transfer Landing Page.
    Mobile.verifyElementVisible(findTestObject('Android/managefavouritedashboard/manageliststitle'), 10)
    Mobile.tap(findTestObject('Android/managefavouritedashboard/localoverseastab'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/managefavouritedashboard/favouritegrouplist'), 10)
} finally {
    Mobile.closeApplication()
}
