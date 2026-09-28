import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.3.1 Manage Fav - Detail Group - Open a favourites/custom group and add a recipient
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-3-1-manage-fav-detail-group.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user opens a favourites/custom group from the Manage Favourite dashboard.
    Mobile.tap(findTestObject('Android/managefavouritedetailgroup/favouritestitle'), 10)
    Mobile.tap(findTestObject('Android/managefavouritedetailgroup/addrecipientbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/managefavouritedetailgroup/drawertitle'), 10)
    Mobile.tap(findTestObject('Android/managefavouritedetailgroup/pasttransfers'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/managefavouritedetailgroup/accountnumber'), 10)
} finally {
    Mobile.closeApplication()
}
