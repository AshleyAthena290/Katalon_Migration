import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.3.4 Manage Fav - Final - Confirm a successful add-to-favourites request
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-3-4-manage-fav-final.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: the add-to-favourites request has been submitted for confirmation.
    Mobile.verifyElementVisible(findTestObject('Android/managefavouritefinal/statusimagestatus'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/managefavouritefinal/accountholdername'), 10)
    Mobile.tap(findTestObject('Android/managefavouritefinal/donebutton'), 10)
} finally {
    Mobile.closeApplication()
}
