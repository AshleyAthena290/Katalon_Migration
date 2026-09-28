import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function: Credit Card Details - Transactions
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-credit-card-details-transactions.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.verifyElementExist(findTestObject('Android/maindashboard/quickactions'), 10)
    Mobile.tap(findTestObject('Android/maindashboard/accounts'), 10)

    // TODO: Object Repository has no captured object for Credit Card Details > Transactions tab.
    // TODO: Run appium-scaffold --screen CreditCardDetailsTransactions --namespace maybank-mobile, then
    // navigate into a card's Transactions tab here.

    // Business rule: transactions listed in descending date order (YTD + last 24 months), grouped by
    // date ("Today" label for today's transactions), only 10 rows shown per page.
    // TODO: Mobile.verifyElementExist(findTestObject('Android/credit-card-details-transactions/transactionlist'), 10)

    // Business rule: "View All Transactions" button only shown when more than 10 transactions exist;
    // tapping it navigates to the Transaction History screen.
    // TODO: Mobile.tap(findTestObject('Android/credit-card-details-transactions/viewalltransactions'), 10)

    // Business rule: tapping a transaction opens the transaction detail screen, from which the user
    // may view and share the receipt.
    // TODO: Mobile.tap(findTestObject('Android/credit-card-details-transactions/transactionitem'), 10)
} finally {
    Mobile.closeApplication()
}
