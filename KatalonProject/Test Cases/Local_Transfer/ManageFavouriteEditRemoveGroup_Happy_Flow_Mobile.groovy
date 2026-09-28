import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.3.5 Mng Fav Edit Remove Grp - Remove a favourites/custom list
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-3-5-mng-fav-edit-remove-grp.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user opens an existing favourites/custom list to manage it from Settings.
    Mobile.tap(findTestObject('Android/managefavouriteeditremovegroup/trashicon'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/managefavouriteeditremovegroup/removelistbutton'), 10)
    Mobile.tap(findTestObject('Android/managefavouriteeditremovegroup/removelistbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/managefavouriteeditremovegroup/removebutton'), 10)
    Mobile.tap(findTestObject('Android/managefavouriteeditremovegroup/removebutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/managefavouriteeditremovegroup/statusimagestatus'), 10)
} finally {
    Mobile.closeApplication()
}
