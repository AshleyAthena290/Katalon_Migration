import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.2.4 Recipient - Remove Fr Tab - Remove a beneficiary from the All tab
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-2-4-recipient-remove-fr-tab.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: beneficiary exists in the All tab.
    Mobile.tap(findTestObject('Android/recipientremovefromtab/remove'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/recipientremovefromtab/popuptitle'), 10)
    Mobile.tap(findTestObject('Android/recipientremovefromtab/removebutton'), 10)
    // Business rule: removing from the All tab also removes the beneficiary from Frequent, Favourite, and Custom tabs.
    Mobile.verifyElementVisible(findTestObject('Android/recipientremovefromtab/statusimagestatus'), 10)
    Mobile.tap(findTestObject('Android/recipientremovefromtab/donebutton'), 10)
} finally {
    Mobile.closeApplication()
}
