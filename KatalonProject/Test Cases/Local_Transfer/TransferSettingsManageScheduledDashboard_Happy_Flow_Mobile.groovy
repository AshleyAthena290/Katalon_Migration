import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.4 Tf Set Mng Sch Trf Dboard - Open the Manage Scheduled Transfer dashboard
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-4-tf-set-mng-sch-trf-dboard.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user opens Settings > Manage Scheduled Transfer dashboard.
    Mobile.tap(findTestObject('Android/transfersettingsmanagescheduleddashboard/transferselection'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/transfersettingsmanagescheduleddashboard/menuoptions'), 10)
} finally {
    Mobile.closeApplication()
}
