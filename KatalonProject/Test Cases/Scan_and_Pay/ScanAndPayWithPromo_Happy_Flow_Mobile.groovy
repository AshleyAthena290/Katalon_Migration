import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 8.1 Promo Application - Apply promo code during scan & pay
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/8-1-promo-application.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.tap(findTestObject('Android/scanandpaywithpromo/scan'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/scanandpaywithpromo/paymentdetails'), 10)
    Mobile.setText(findTestObject('Android/scanandpaywithpromo/promocode'), 'PROMO10', 10)
    Mobile.tap(findTestObject('Android/scanandpaywithpromo/apply'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/scanandpaywithpromo/promoapplied'), 10)
    Mobile.tap(findTestObject('Android/scanandpaywithpromo/pay'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/scanandpaywithpromo/paymentsuccess'), 10)
} finally {
    Mobile.closeApplication()
}
