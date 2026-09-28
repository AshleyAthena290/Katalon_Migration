import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 6.3 L Bento (All) - Open the Money Out tile from L Bento
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/6-3-l-bento-all.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: L Bento is available with the default widget or Money Out data present.
    Mobile.verifyElementVisible(findTestObject('Android/lbento/lbento'), 10)
    Mobile.tap(findTestObject('Android/lbento/moneyouttile'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/lbento/moneyout'), 10)
} finally {
    Mobile.closeApplication()
}
