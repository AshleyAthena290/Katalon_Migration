import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 11.0 CC Holder Only-Apply CASA - CC-holder-only customer applies for a Savings Account
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/11-0-cc-holder-only-apply-casa.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user only holds a credit card and has no CASA account.
    Mobile.tap(findTestObject('Android/ccholderapplycasa/applynow'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/ccholderapplycasa/newapplication'), 10)
    Mobile.tap(findTestObject('Android/ccholderapplycasa/savingsaccount'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/ccholderapplycasa/savingsaccountapplication'), 10)
} finally {
    Mobile.closeApplication()
}
