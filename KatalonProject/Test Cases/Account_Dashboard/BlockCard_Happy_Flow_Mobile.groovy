import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function 68: Block Card - Secure2U FMA
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-68-block-card-secure2u-fma.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user tapped "Block Card" from Credit Card Details > Manage and reached Secure2U
    // authorisation.
    // TODO: Object Repository has no captured object for the numeric Secure2U passcode pad on the
    // verification screen; the createsecure2u keypad objects below are reused as the closest available match.
    Mobile.tap(findTestObject('Android/createsecure2u/row1key11'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row2key25'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row3key39'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row1key22'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row2key14'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row3key28'), 10)

    // Action: [OK] submits the correct passcode and proceeds with card blocking; [Cancel] cancels it.
    // TODO: Object Repository has no captured OK/Cancel objects for this specific screen.
    Mobile.tap(findTestObject('Android/createsecure2u/confirm'), 10)

    // Business rule: data is sent to FMS for fraud monitoring, then a block request with block code Y
    // is sent to Cardlink.
} finally {
    Mobile.closeApplication()
}
