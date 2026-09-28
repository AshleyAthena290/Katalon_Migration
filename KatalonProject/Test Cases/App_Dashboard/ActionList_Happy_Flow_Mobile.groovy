import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 10.1 Action List - Open action nudge list and act on a Credit Card Activation item
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/10-1-action-list.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user is logged in with at least one pending action, e.g. Credit Card Activation.
    Mobile.tap(findTestObject('Android/actionlist/actionicon'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/actionlist/actions'), 10)
    Mobile.tap(findTestObject('Android/actionlist/creditcardactivation'), 10)
    // Business rule: Credit Card Activation links to the specific card for activation.
    Mobile.verifyElementVisible(findTestObject('Android/actionlist/cardactivation'), 10)
} finally {
    Mobile.closeApplication()
}
