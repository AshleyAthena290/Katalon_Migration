import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.3.2 Manage Fav Add fr Acct No - Add a new favourite by entering an account number
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-3-2-manage-fav-add-fr-acct-no.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user chooses to add a new favourite by entering an account number.
    Mobile.setText(findTestObject('Android/managefavouriteaddfromaccountnumber/accountnumber'), '1234567890', 10)
    Mobile.setText(findTestObject('Android/managefavouriteaddfromaccountnumber/nickname'), 'NewFriend', 10)
    Mobile.tap(findTestObject('Android/managefavouriteaddfromaccountnumber/nextbutton'), 10)
    // Business rule: mandatory-field checking is performed before proceeding.
    Mobile.verifyElementVisible(findTestObject('Android/managefavouriteaddfromaccountnumber/remindermessage'), 10)
} finally {
    Mobile.closeApplication()
}
