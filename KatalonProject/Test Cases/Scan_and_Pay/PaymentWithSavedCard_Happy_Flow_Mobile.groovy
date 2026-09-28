import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 3.1 Saved Card Payment - Complete payment using saved card on file
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/3-1-saved-card-payment.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user has saved card.
    Mobile.tap(findTestObject('Android/paymentwithsavedcard/selectsavedcard'), 10)
    Mobile.tap(findTestObject('Android/paymentwithsavedcard/pay'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/paymentwithsavedcard/3dsorotpscreen'), 10)
    // Complete 3DS using fixture.
    Mobile.verifyElementVisible(findTestObject('Android/paymentwithsavedcard/paymentsuccess'), 10)
} finally {
    Mobile.closeApplication()
}
