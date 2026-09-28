import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.4.1 Tf Set Mng Sch Trf List - Filter the scheduled/recurring transfer list
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-4-1-tf-set-mng-sch-trf-list.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: at least one active scheduled or recurring transfer exists.
    Mobile.verifyElementVisible(findTestObject('Android/transfersettingsmanagescheduledlist/titleheader'), 10)
    Mobile.tap(findTestObject('Android/transfersettingsmanagescheduledlist/filtericon'), 10)
    Mobile.tap(findTestObject('Android/transfersettingsmanagescheduledlist/applybutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/transfersettingsmanagescheduledlist/beneficiaryname'), 10)
} finally {
    Mobile.closeApplication()
}
