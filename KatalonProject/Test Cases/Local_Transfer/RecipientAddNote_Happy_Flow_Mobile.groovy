import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.2.1 Recipient - Add Note - Add a nickname note to a beneficiary
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-2-1-recipient-add-note.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: beneficiary exists in the All, Frequent, Favourite, or Custom list.
    Mobile.tap(findTestObject('Android/recipientaddnote/longpressbeneficiary'), 10)
    Mobile.tap(findTestObject('Android/recipientaddnote/addnickname'), 10)
    Mobile.setText(findTestObject('Android/recipientaddnote/nickname'), 'MyFriend', 10)
    Mobile.tap(findTestObject('Android/recipientaddnote/savenicknamebutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/recipientaddnote/beneficiarynickname'), 10)
} finally {
    Mobile.closeApplication()
}
