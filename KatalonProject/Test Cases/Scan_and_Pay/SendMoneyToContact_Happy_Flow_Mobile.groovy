import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 4.1 Send Money via QR to Contact - Send money to contact by scanning their QR
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/4-1-send-money-via-qr-to-contact.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: contact has QR code linked to account.
    Mobile.tap(findTestObject('Android/sendmoneytocontact/scan'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/sendmoneytocontact/contactname'), 10)
    Mobile.setText(findTestObject('Android/sendmoneytocontact/amount'), '20', 10)
    Mobile.tap(findTestObject('Android/sendmoneytocontact/send'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/sendmoneytocontact/success'), 10)
} finally {
    Mobile.closeApplication()
}
