import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.2 Recipient - Create New - Create a new custom recipient list
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-2-recipient-create-new.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user navigates to Recipient list management from the Transfer Landing Page.
    Mobile.tap(findTestObject('Android/recipientcreatenewlist/addrecipientbutton'), 10)
    Mobile.setText(findTestObject('Android/recipientcreatenewlist/listname'), 'Family', 10)
    Mobile.tap(findTestObject('Android/recipientcreatenewlist/selectrecipients'), 10)
    Mobile.tap(findTestObject('Android/recipientcreatenewlist/savebutton'), 10)
    Mobile.tap(findTestObject('Android/recipientcreatenewlist/createlistbutton'), 10)
    // Business rule: the (+) Create New List button is hidden once the maximum number of lists is reached.
    Mobile.verifyElementVisible(findTestObject('Android/recipientcreatenewlist/selectedrecipientssection'), 10)
} finally {
    Mobile.closeApplication()
}
