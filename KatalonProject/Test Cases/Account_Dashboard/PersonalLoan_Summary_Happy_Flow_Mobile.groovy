import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function: Personal Loan Summary
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-personal-loan-summary.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.verifyElementExist(findTestObject('Android/maindashboard/quickactions'), 10)
    Mobile.tap(findTestObject('Android/maindashboard/accounts'), 10)

    // TODO: Object Repository has no captured object for Personal Loan Details > Summary tab.
    // TODO: Run appium-scaffold --screen PersonalLoanSummary --namespace maybank-mobile, then navigate
    // into a Personal Loan account's Summary tab here.

    // Business rule: Summary tab is read-only display information; no editing functionality is available.
    // TODO: Mobile.verifyElementExist(findTestObject('Android/personal-loan-summary/outstandingbalance'), 10)

    // Business rule: Admin fee & Provision fee are deducted directly at disbursement (one-time); no
    // special handling is required on the Transactions screen for these two fees.

    // Business rule: quick actions show both Pay and View Statements for Personal Loan (View Statements
    // only for Mortgage Loan; hidden entirely for Auto Loan); each tile is subject to configuration.
    // TODO: Mobile.tap(findTestObject('Android/personal-loan-summary/pay'), 10)
    // TODO: Mobile.tap(findTestObject('Android/personal-loan-summary/viewstatements'), 10)
} finally {
    Mobile.closeApplication()
}
