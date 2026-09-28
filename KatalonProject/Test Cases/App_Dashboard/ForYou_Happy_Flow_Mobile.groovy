import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 5.0 For you (All) - Open a For you tile
// Figma: [UI] Home Dashboard - ID (For Development), frame "homeappdashboard_Banking" (375x812) - node-id 15477-223634
// Screen tiles: "Apply for an account" | "IDR 10,000 Sweet Deals"
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/5-0-for-you-all.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below use Figma-confirmed labels as placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: at least one active, non-expired 'For you' tile is configured.
    Mobile.verifyElementVisible(findTestObject('Android/foryou/applyforanaccount'), 10)
    Mobile.tap(findTestObject('Android/foryou/applyforanaccount'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/foryou/foryou'), 10)
} finally {
    Mobile.closeApplication()
}
