import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// Feature: Interbank transfer - scheduled immediate transfer (now)
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.tap(findTestObject('Android/interbank/getstarted'), 10)
    Mobile.tap(findTestObject('Android/interbank/transfermenu'), 10)
    Mobile.tap(findTestObject('Android/interbank/interbankoption'), 10)
    Mobile.setText(findTestObject('Android/interbank/beneficiary_account_number'), '9876543210', 10)
    Mobile.setText(findTestObject('Android/interbank/beneficiary_name'), 'Scheduled Recipient', 10)
    Mobile.setText(findTestObject('Android/interbank/amount'), '300', 10)
    Mobile.tap(findTestObject('Android/interbank/schedule_toggle'), 10)
    Mobile.tap(findTestObject('Android/interbank/schedule_now_option'), 10)
    Mobile.tap(findTestObject('Android/interbank/nextbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/interbank/confirmationtitle'), 10)
    Mobile.tap(findTestObject('Android/interbank/confirmbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/interbank/successstatus'), 10)
    Mobile.tap(findTestObject('Android/interbank/donebutton'), 10)
} finally {
    Mobile.closeApplication()
}
