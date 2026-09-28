import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function 92: CC Activation - Secure2U FMA
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-92-cc-activation-secure2u-fma.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user has reached the Secure2U passcode authorisation step from Credit Card Activation.
    Mobile.verifyElementExist(findTestObject('Android/activesecure2u/whatissecure2u'), 10)
    Mobile.verifyElementExist(findTestObject('Android/activesecure2u/approvetransactionssafelyandquicklywithamemorablepasscode'), 10)

    // Fields: Passcode (Numeric, mandatory) validated by Secure2U.
    // TODO: Object Repository has no captured object for the numeric Secure2U passcode input pad on the
    // verification screen; the createsecure2u keypad objects below are reused as the closest available match.
    Mobile.tap(findTestObject('Android/createsecure2u/row1key11'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row2key25'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row3key39'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row1key22'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row2key14'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row3key28'), 10)

    // Action: [OK] submits the correct passcode and proceeds with the card activation request.
    // TODO: Object Repository has no captured object for the OK/Cancel actions on this specific screen.
    // Business rule: data is sent to FMS for fraud monitoring before Cardlink processes the request.
} finally {
    Mobile.closeApplication()
}
