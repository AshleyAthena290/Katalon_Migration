import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 14.0 Pre-Binded(Explore Dboard) - Pre-binded zero-state customer opens an account
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/14-0-pre-binded-explore-dboard.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: customer has no bound account yet (zero state / pre-binded).
    Mobile.verifyElementVisible(findTestObject('Android/prebinded/prebindeddescription'), 10)
    Mobile.tap(findTestObject('Android/prebinded/openaccount'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/prebinded/openanaccount'), 10)
} finally {
    Mobile.closeApplication()
}
