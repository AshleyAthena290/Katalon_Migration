import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function: Increase Credit Limit - Permanent
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-increase-credit-limit-permanent.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.verifyElementExist(findTestObject('Android/maindashboard/quickactions'), 10)

    // TODO: Object Repository has no captured object for the Increase Credit Limit - Permanent screen.
    // TODO: Run appium-scaffold --screen IncreaseCreditLimitPermanent --namespace maybank-mobile, then
    // replace the TODOs below with real objects.

    // Business rule: eligible range is [current credit limit + 1mio] up to the lower of the MOB-based
    // percentage increase or configured max nominal increase; capped at IDR 50,000,000 (manual CID review).
    // TODO: Mobile.setText(findTestObject('Android/increase-credit-limit-permanent/amount'), '58000000', 10)

    // Business rule: on [Confirm], if the new limit exceeds IDR 50,000,000, navigate to "NPWP number"
    // screen; otherwise navigate directly to the T&C screen.
    // TODO: Mobile.tap(findTestObject('Android/increase-credit-limit-permanent/confirm'), 10)

    // NPWP screen: "Does your NPWP have the same number as your e-KTP?" Yes/No radio.
    // If Yes, auto-populate existing e-KTP from BE; if No, show "Upload your NPWP" section
    // (Photo Library / Take Photo / Choose File / Cancel options).
    // TODO: Mobile.tap(findTestObject('Android/increase-credit-limit-permanent/npwpsameasektpyes'), 10)
} finally {
    Mobile.closeApplication()
}
