import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 6.1 S Bento (All) - Open S Bento details
// Figma: [UI] Home Dashboard - ID (For Development), frame "homeappdashboard_Banking" (375x812) - node-id 15477-223634
// Screen tile: "Your TreatsPoints 110,330 - Expiring 30 Nov 2025"
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/6-1-s-bento-all.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below use Figma-confirmed labels as placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: S Bento widget is configured for the active dashboard/ecosystem.
    Mobile.verifyElementVisible(findTestObject('Android/sbento/yourtreatspoints'), 10)
    Mobile.tap(findTestObject('Android/sbento/yourtreatspoints'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/sbento/details'), 10)
} finally {
    Mobile.closeApplication()
}
