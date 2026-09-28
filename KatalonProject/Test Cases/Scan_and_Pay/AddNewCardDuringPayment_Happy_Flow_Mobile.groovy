import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 4.0 Add Card During Payment - Add card and pay in same flow
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/4-0-add-card-during-payment.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user chooses Add New Card.
    Mobile.setText(findTestObject('Android/addnewcardduringpayment/cardnumber'), '4111111111111111', 10)
    Mobile.setText(findTestObject('Android/addnewcardduringpayment/expiry'), '1225', 10)
    Mobile.setText(findTestObject('Android/addnewcardduringpayment/cvv'), '123', 10)
    Mobile.tap(findTestObject('Android/addnewcardduringpayment/addandpay'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/addnewcardduringpayment/paymentsuccess'), 10)
} finally {
    Mobile.closeApplication()
}
