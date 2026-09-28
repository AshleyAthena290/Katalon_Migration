import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.4.4 Tf Set Mng Limit List - Open the transfer limit list for a transfer mode
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-4-4-tf-set-mng-limit-list.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user opens the transfer limit list for a specific transfer mode.
    Mobile.verifyElementVisible(findTestObject('Android/transfersettingsmanagelimitlist/remindermessage'), 10)
    Mobile.tap(findTestObject('Android/transfersettingsmanagelimitlist/menutransfermode'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/transfersettingsmanagelimitlist/transfermodeselections'), 10)
} finally {
    Mobile.closeApplication()
}
