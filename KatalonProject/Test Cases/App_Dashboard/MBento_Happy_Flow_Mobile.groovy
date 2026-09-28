import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 6.2 M Bento (All) - Open M Bento destination
// Figma: [UI] Home Dashboard - ID (For Development), frame "homeappdashboard_Banking" (375x812) - node-id 15477-223634
// Screen tile: "Tabung - Start saving today and you'll have IDR 36.5 million waiting in 5 years!"
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/6-2-m-bento-all.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below use Figma-confirmed labels as placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: M Bento is displayed based on configurable time/account criteria.
    Mobile.verifyElementVisible(findTestObject('Android/mbento/tabung'), 10)
    Mobile.tap(findTestObject('Android/mbento/tabung'), 10)
    // Business rule: tapping M Bento navigates to either an existing NGA screen or a web page.
    Mobile.verifyElementVisible(findTestObject('Android/mbento/details'), 10)
} finally {
    Mobile.closeApplication()
}
