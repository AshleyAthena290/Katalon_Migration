import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.4.3 Tf Set Mng Limit Dboard - Open the Manage Limits dashboard
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-4-3-tf-set-mng-limit-dboard.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user opens Settings > Manage Limits dashboard.
    Mobile.tap(findTestObject('Android/transfersettingsmanagelimitdashboard/transferlimits'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/transfersettingsmanagelimitdashboard/menuoptions'), 10)
} finally {
    Mobile.closeApplication()
}
