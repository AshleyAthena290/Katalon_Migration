import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function: Credit Card Dashboard
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-credit-card-dashboard.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // MainDashboard: entry point after successful login.
    Mobile.verifyElementExist(findTestObject('Android/maindashboard/quickactions'), 10)
    Mobile.tap(findTestObject('Android/maindashboard/accounts'), 10)

    // TODO: Object Repository has no captured object for the "Credit Card" tab/tile on the Accounts screen.
    // TODO: Run appium-scaffold --screen CreditCardDashboard --namespace maybank-mobile against the live app,
    // then tap the real "Credit Card" tab object here.
    // Business rule: Cards tab displays Credit Card before Debit Card; sequence inverts if the user
    // has no credit card; empty state (no tabs) is shown if neither card type exists.

    // Business rule: sorting is by activation date ascending (pending activation first), then
    // alphabetically A-Z/0-9 grouped by status: Active, Temporarily blocked, Blocked.

    // TODO: Object Repository has no captured object for an individual credit card list item.
    // TODO: Tap the first credit card item once scaffolded; expected navigation is Credit Card Details screen.
} finally {
    Mobile.closeApplication()
}
