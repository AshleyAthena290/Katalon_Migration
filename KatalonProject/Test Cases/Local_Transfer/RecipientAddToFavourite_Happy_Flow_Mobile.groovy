import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.2.2 Recipient - Add to Fav - Add a beneficiary to a favourites list
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-2-2-recipient-add-to-fav.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: beneficiary is long-pressed from the Transfer Landing Page.
    Mobile.tap(findTestObject('Android/recipientaddtofavourite/addtofavourites'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/recipientaddtofavourite/selectafavouriteslisttitle'), 10)
    Mobile.tap(findTestObject('Android/recipientaddtofavourite/favouriteslist'), 10)
    // Business rule: adding to the Favourites list requires Secure2u authorisation.
    Mobile.tap(findTestObject('Android/recipientaddtofavourite/savebutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/recipientaddtofavourite/statusimagestatus'), 10)
    Mobile.tap(findTestObject('Android/recipientaddtofavourite/donebutton'), 10)
} finally {
    Mobile.closeApplication()
}
