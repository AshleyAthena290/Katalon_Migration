import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.4.5 Tf Set Mng Limit Det - Update a transfer limit
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-4-5-tf-set-mng-limit-det.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user selects a specific transfer mode's limit detail screen.
    Mobile.verifyElementVisible(findTestObject('Android/transfersettingsmanagelimitdetail/currentlimit'), 10)
    Mobile.tap(findTestObject('Android/transfersettingsmanagelimitdetail/selectnewlimitselection'), 10)
    Mobile.tap(findTestObject('Android/transfersettingsmanagelimitdetail/savebutton'), 10)
    // Business rule: for ID, a successful limit update takes effect immediately with no cooling-off period.
    Mobile.verifyElementVisible(findTestObject('Android/transfersettingsmanagelimitdetail/statusimagestatus'), 10)
    Mobile.tap(findTestObject('Android/transfersettingsmanagelimitdetail/done'), 10)
} finally {
    Mobile.closeApplication()
}
