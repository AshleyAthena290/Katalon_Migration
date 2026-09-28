import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// Feature: Interbank transfer - Happy flow via account number
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.tap(findTestObject('Android/interbank/getstarted'), 10)
    Mobile.tap(findTestObject('Android/interbank/transfermenu'), 10)
    Mobile.tap(findTestObject('Android/interbank/interbankoption'), 10)
    Mobile.setText(findTestObject('Android/interbank/beneficiary_account_number'), '1234567890', 10)
    Mobile.setText(findTestObject('Android/interbank/beneficiary_name'), 'John Doe', 10)
    Mobile.setText(findTestObject('Android/interbank/amount'), '1000', 10)
    Mobile.tap(findTestObject('Android/interbank/nextbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/interbank/confirmationtitle'), 10)
    Mobile.tap(findTestObject('Android/interbank/confirmbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/interbank/successstatus'), 10)
    Mobile.tap(findTestObject('Android/interbank/donebutton'), 10)
} finally {
    Mobile.closeApplication()
}
