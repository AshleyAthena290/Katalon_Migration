import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 10.1 Payment Settings - Configure scan & pay preferences and limits
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/10-1-payment-settings.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.tap(findTestObject('Android/paymentsettingsflow/settings'), 10)
    Mobile.tap(findTestObject('Android/paymentsettingsflow/scanpaysettings'), 10)
    Mobile.setText(findTestObject('Android/paymentsettingsflow/dailylimit'), '1000', 10)
    Mobile.tap(findTestObject('Android/paymentsettingsflow/save'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/paymentsettingsflow/settingssaved'), 10)
} finally {
    Mobile.closeApplication()
}
