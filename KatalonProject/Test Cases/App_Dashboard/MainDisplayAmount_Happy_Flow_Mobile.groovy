import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 2.0 Main Display Amt (All) - Toggle balance visibility and open account details
// Figma: [UI] Home Dashboard - ID (For Development), frame "homeappdashboard_Banking" (375x812) - node-id 15477-223634
// Screen text: "Total available credit limit" -> "IDR 12,000,699.00" (eye toggle) | "Total outstanding balance: IDR 3,000,000.00" (info icon)
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/2-0-main-display-amt-all.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below use Figma-confirmed labels as placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user has a primary account with a non-empty main display amount.
    Mobile.verifyElementVisible(findTestObject('Android/maindisplayamount/totalavailablecreditlimit'), 10)
    Mobile.tap(findTestObject('Android/maindisplayamount/eyeicon'), 10)
    Mobile.tap(findTestObject('Android/maindisplayamount/totaloutstandingbalanceinfoicon'), 10)
    // Business rule: non-IDR currency balances are converted and displayed with the account's currency code.
    Mobile.verifyElementVisible(findTestObject('Android/maindisplayamount/accountdetails'), 10)
} finally {
    Mobile.closeApplication()
}
