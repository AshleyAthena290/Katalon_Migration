import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// Feature: Interbank transfer - requires OTP confirmation
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.tap(findTestObject('Android/interbank/getstarted'), 10)
    Mobile.tap(findTestObject('Android/interbank/transfermenu'), 10)
    Mobile.tap(findTestObject('Android/interbank/interbankoption'), 10)
    Mobile.setText(findTestObject('Android/interbank/beneficiary_account_number'), '6677889900', 10)
    Mobile.setText(findTestObject('Android/interbank/beneficiary_name'), 'OTP Recipient', 10)
    Mobile.setText(findTestObject('Android/interbank/amount'), '600', 10)
    Mobile.tap(findTestObject('Android/interbank/nextbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/interbank/otp_prompt'), 10)
    // NOTE: OTP retrieval must be handled by test environment or mocked; placeholder below
    Mobile.setText(findTestObject('Android/interbank/otp_field'), '000000', 10)
    Mobile.tap(findTestObject('Android/interbank/otp_submit_button'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/interbank/successstatus'), 10)
    Mobile.tap(findTestObject('Android/interbank/donebutton'), 10)
} finally {
    Mobile.closeApplication()
}
