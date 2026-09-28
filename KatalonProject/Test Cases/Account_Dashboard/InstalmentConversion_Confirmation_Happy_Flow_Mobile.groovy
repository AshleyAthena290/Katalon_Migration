import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function: Instalment Conversion - Confirmation
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-instalment-conversion-confirmation.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.verifyElementExist(findTestObject('Android/maindashboard/quickactions'), 10)

    // TODO: Object Repository has no captured object for the Instalment Conversion - Confirmation screen.
    // TODO: Run appium-scaffold --screen InstalmentConversionConfirmation --namespace maybank-mobile, then
    // replace the TODOs below with real objects.

    // Business rule: confirmation screen displays each transaction's Merchant, Amount, Tenure,
    // Monthly instalment, Admin fee, and Conversion fee.
    // TODO: Mobile.verifyElementExist(findTestObject('Android/instalment-conversion-confirmation/merchant1'), 10)

    // Business rule: [Edit] hyperlink returns to Select Transaction screen; confirming edits skips T&C
    // and returns directly to the Confirmation page with updated values.
    // TODO: Mobile.tap(findTestObject('Android/instalment-conversion-confirmation/edit'), 10)

    // Business rule: [Confirm] navigates to the [A&A] Input Passcode (Secure2U) flow; once authentication
    // completes, the system navigates to the Acknowledgement screen.
    // TODO: Mobile.tap(findTestObject('Android/instalment-conversion-confirmation/confirm'), 10)
} finally {
    Mobile.closeApplication()
}
