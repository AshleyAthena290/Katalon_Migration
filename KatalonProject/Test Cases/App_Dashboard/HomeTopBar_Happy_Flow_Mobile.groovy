import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 1.0 Home-Top Bar (All) - Home top bar profile and notification access
// Figma: [UI] Home Dashboard - ID (For Development), frame "homeappdashboard_Banking" (375x812) - node-id 15477-223634
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/1-0-home-top-bar-all.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below use Figma-confirmed labels as placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user is logged in and on the App Dashboard home screen.
    Mobile.verifyElementVisible(findTestObject('Android/hometopbar/profilepicture'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/hometopbar/securityassistancebadge'), 10)
    Mobile.tap(findTestObject('Android/hometopbar/notificationicon'), 10)
    // Business rule: if unread notifications > 0, the notification icon shows a red dot.
    Mobile.verifyElementVisible(findTestObject('Android/hometopbar/notifications'), 10)
} finally {
    Mobile.closeApplication()
}
