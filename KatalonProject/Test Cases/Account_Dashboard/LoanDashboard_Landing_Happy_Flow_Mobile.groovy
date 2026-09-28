import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function: Loan Dashboard - Landing
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-loan-dashboard-landing.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.verifyElementExist(findTestObject('Android/maindashboard/quickactions'), 10)
    Mobile.tap(findTestObject('Android/maindashboard/accounts'), 10)

    // TODO: Object Repository has no captured object for the Loan/Financing Account Listing tab.
    // TODO: Run appium-scaffold --screen LoanDashboardLanding --namespace maybank-mobile, then replace
    // the TODOs below with real objects.

    // Business rule: lists Personal Loan, Auto Loan, and Mortgage Loan accounts (conventional and iB),
    // with status limited to Overdue, Active, or Closed (Closed shows for 90 days after settlement).
    // TODO: Mobile.verifyElementExist(findTestObject('Android/loan-dashboard-landing/loanlist'), 10)

    // Business rule: sorted by product category (Personal, Auto, Mortgage), then alphabetically within
    // each category by status order: Overdue, Active, Closed.

    // Business rule: by default max 3 loan items are shown; additional items require scrolling.

    // Business rule: if no active loans, shows "No loan/financing" message with an "Apply now"
    // hyperlink (Drop 1 scope: PL/KTA only) navigating to the Apply Loan flow.
    // TODO: Mobile.tap(findTestObject('Android/loan-dashboard-landing/applynow'), 10)
} finally {
    Mobile.closeApplication()
}
