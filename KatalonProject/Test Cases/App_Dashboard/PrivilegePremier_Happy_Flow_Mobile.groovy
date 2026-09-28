import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 4.0 2Ps-Privilege & Premier - View 2Ps rewards & benefits and explore tiers
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/4-0-2ps-privilege-premier.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user is a 2Ps (Privilege or Premier) customer.
    Mobile.tap(findTestObject('Android/privilegepremier/featurestab'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/privilegepremier/benefitslist'), 10)
    Mobile.tap(findTestObject('Android/privilegepremier/explorealltiersbenefits'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/privilegepremier/benefitstiers'), 10)
} finally {
    Mobile.closeApplication()
}
