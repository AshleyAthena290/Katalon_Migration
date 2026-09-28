import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 7.1 Save QR as Payee - Save scanned QR as a payee for future use
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/7-1-save-qr-as-payee.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.tap(findTestObject('Android/saveqrcodeaspayee/scan'), 10)
    // Scan merchant QR
    Mobile.tap(findTestObject('Android/saveqrcodeaspayee/saveaspayee'), 10)
    Mobile.setText(findTestObject('Android/saveqrcodeaspayee/nickname'), 'Cafe', 10)
    Mobile.tap(findTestObject('Android/saveqrcodeaspayee/save'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/saveqrcodeaspayee/payeesaved'), 10)
} finally {
    Mobile.closeApplication()
}
