import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 18.0 S2U Cooling off Period - View Secure2u cooling-off period notice and proceed
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/18-0-s2u-cooling-off-period.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: Secure2u setup was just completed and the cooling-off countdown has started.
    Mobile.verifyElementVisible(findTestObject('Android/s2ucoolingoffperiod/secure2uactivation'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/s2ucoolingoffperiod/coolingoffperiod'), 10)
    Mobile.tap(findTestObject('Android/s2ucoolingoffperiod/proceed'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/s2ucoolingoffperiod/home'), 10)
} finally {
    Mobile.closeApplication()
}
