import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 9.0 Navbar Menu (All) - Open the menu and search for an item
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/9-0-navbar-menu-all.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user opens the Menu from the navbar.
    Mobile.tap(findTestObject('Android/navbarmenu/menu'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/navbarmenu/menu'), 10)
    Mobile.setText(findTestObject('Android/navbarmenu/searchbar'), 'Transfer', 10)
    // Business rule: menu search covers items listed in the Menu, e.g. Apply/Accounts.
    Mobile.verifyElementVisible(findTestObject('Android/navbarmenu/searchresults'), 10)
} finally {
    Mobile.closeApplication()
}
