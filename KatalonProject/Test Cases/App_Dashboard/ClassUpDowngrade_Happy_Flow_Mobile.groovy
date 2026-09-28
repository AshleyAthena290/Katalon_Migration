import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 4.2 2Ps Class Up & Downgrade - Acknowledge class level-up celebratory drawer
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/4-2-2ps-class-up-downgrade.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: NGA has flagged a customer type upgrade to Privilege/Premier.
    Mobile.verifyElementVisible(findTestObject('Android/classupdowngrade/congratulationsyouvebeenupgraded'), 10)
    Mobile.tap(findTestObject('Android/classupdowngrade/viewyournewdashboard'), 10)
    // Business rule: a push notification is also sent whenever there is a level up or down.
    Mobile.verifyElementVisible(findTestObject('Android/classupdowngrade/home'), 10)
} finally {
    Mobile.closeApplication()
}
