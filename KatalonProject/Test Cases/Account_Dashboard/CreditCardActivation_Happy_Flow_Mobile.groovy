import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function: Credit Cards Activation
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-credit-cards-activation.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Entry point: App/home dashboard > Action list > Credit Card pending activation.
    Mobile.verifyElementExist(findTestObject('Android/maindashboard/quickactions'), 10)

    // TODO: Object Repository has no captured object for the "Activate now" action list item.
    // TODO: Run appium-scaffold --screen CreditCardActivation --namespace maybank-mobile, then tap
    // the real "Activate now" object here.
    // Business rule: tapping [Activate now] validates card type by BIN (Visa/Mastercard allowed to
    // proceed; JCB shows a pop-up per the JCB CC Activation flow instead).

    // New card PIN entry reuses the passcode keypad UI captured under createsecure2u.
    // Business rule: PIN must contain 6 digits, must not contain 3+ consecutive or 3+ repeated numbers.
    Mobile.verifyElementExist(findTestObject('Android/createsecure2u/mustcontain68digits'), 10)
    Mobile.verifyElementExist(findTestObject('Android/createsecure2u/mustnotcontain3ormoreconsecutivenumberseg123400'), 10)
    Mobile.verifyElementExist(findTestObject('Android/createsecure2u/mustnotcontain3ormorerepeatednumberseg111000'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row1key11'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row2key25'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row3key39'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row1key22'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row2key14'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row3key28'), 10)

    // Confirm PIN must match New PIN before proceeding to the Secure2U (A&A) passcode flow.
    Mobile.verifyElementExist(findTestObject('Android/createsecure2u/confirmpasscode'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/confirm'), 10)

    // Expected result: successful Secure2U authorisation and card activation shows the Activation
    // Successful screen with a Done button; failed activation shows Request Unsuccessful screen instead.
    // TODO: Object Repository has no captured object for Activation Successful / Request Unsuccessful screens.
} finally {
    Mobile.closeApplication()
}
