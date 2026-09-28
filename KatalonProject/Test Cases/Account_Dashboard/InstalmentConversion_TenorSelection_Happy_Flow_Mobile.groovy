import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function 43: Installment Conversion - Tenor Selection
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-43-installment-conversion-tenor-selection.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.verifyElementExist(findTestObject('Android/maindashboard/quickactions'), 10)

    // TODO: Object Repository has no captured object for the Installment Conversion - Tenor Selection screen.
    // TODO: Run appium-scaffold --screen InstalmentConversionTenorSelection --namespace maybank-mobile, then
    // replace the TODOs below with real objects.

    // Fields displayed: Merchant Name, Transaction Amount, Tenure Options (from BO NGA), Interest Rate,
    // Monthly Repayment, Admin Fee (both calculated by BE NGA and shown in IDR).
    // TODO: Mobile.verifyElementExist(findTestObject('Android/instalment-conversion-tenor/merchantname'), 10)
    // TODO: Mobile.verifyElementExist(findTestObject('Android/instalment-conversion-tenor/transactionamount'), 10)

    // Business rule: only one tenure can be selected per transaction.
    // TODO: Mobile.tap(findTestObject('Android/instalment-conversion-tenor/tenureoption1'), 10)

    // Business rule: tapping [Next] without a tenure selection shows an error; [Back] returns to the
    // transaction selection screen.
    // TODO: Mobile.tap(findTestObject('Android/instalment-conversion-tenor/next'), 10)
} finally {
    Mobile.closeApplication()
}
