import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function: Credit Card Details - Summary
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-credit-card-details-summary.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.verifyElementExist(findTestObject('Android/maindashboard/quickactions'), 10)
    Mobile.tap(findTestObject('Android/maindashboard/accounts'), 10)

    // TODO: Object Repository has no captured object for Credit Card Details > Summary tab.
    // TODO: Run appium-scaffold --screen CreditCardDetailsSummary --namespace maybank-mobile, then navigate
    // into a card's Summary tab here.

    // Validation rules (display-only, IDR currency): Credit Limit, Available Credit Limit,
    // Last Statement Billed Amount (shows "0" if overpaid/CR), Minimum Payment Amount,
    // Remaining Unpaid Balance, Payment Due Date in DDMonthYYYY format.
    // TODO: Mobile.verifyElementExist(findTestObject('Android/credit-card-details-summary/creditlimit'), 10)
    // TODO: Mobile.verifyElementExist(findTestObject('Android/credit-card-details-summary/availablecreditlimit'), 10)
    // TODO: Mobile.verifyElementExist(findTestObject('Android/credit-card-details-summary/lastStatementBilledAmount'), 10)
    // TODO: Mobile.verifyElementExist(findTestObject('Android/credit-card-details-summary/minimumPaymentAmount'), 10)
    // TODO: Mobile.verifyElementExist(findTestObject('Android/credit-card-details-summary/remainingUnpaidBalance'), 10)
    // TODO: Mobile.verifyElementExist(findTestObject('Android/credit-card-details-summary/paymentDueDate'), 10)

    // Business rule: no edit function shall be available in the Summary tab.
} finally {
    Mobile.closeApplication()
}
