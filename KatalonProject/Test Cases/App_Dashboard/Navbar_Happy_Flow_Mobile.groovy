import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 8.0 Navbar (All) - Navigate between Accounts and Home via the navbar
// Figma: [UI] Home Dashboard - ID (For Development), frame "homeappdashboard_Banking" (375x812) - node-id 15477-223634
// Navbar tabs (left to right): Home, Accounts, 2Ps, Interact, Menu
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/8-0-navbar-all.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below use Figma-confirmed labels as placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: navbar is visible at Level 0 (primary sections).
    Mobile.tap(findTestObject('Android/navbar/accounts'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/navbar/accounts'), 10)
    Mobile.tap(findTestObject('Android/navbar/home'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/navbar/home'), 10)
} finally {
    Mobile.closeApplication()
}
