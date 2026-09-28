import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.0 - 1.1.8 Transfer Intro to Notification - End-to-end local transfer to an existing beneficiary
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-0-1-1-8-transfer-intro-to-notification.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user is logged in with an active primary account and at least one beneficiary.
    Mobile.tap(findTestObject('Android/localtransfer/getstarted'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/localtransfer/searchbeneficiaries'), 10)
    Mobile.tap(findTestObject('Android/localtransfer/beneficiarylistsselection'), 10)
    Mobile.setText(findTestObject('Android/localtransfer/amount'), '500000', 10)
    Mobile.tap(findTestObject('Android/localtransfer/inputamountnextbutton'), 10)
    Mobile.tap(findTestObject('Android/localtransfer/transferdetailsnextbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/localtransfer/confirmationtitleheader'), 10)
    Mobile.tap(findTestObject('Android/localtransfer/confirmbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/localtransfer/statusiconstatus'), 10)
    Mobile.tap(findTestObject('Android/localtransfer/donebutton'), 10)
    // Business rule: push and email notification is sent to the sender upon a successful transfer.
    Mobile.verifyElementVisible(findTestObject('Android/localtransfer/searchbeneficiaries'), 10)
} finally {
    Mobile.closeApplication()
}
