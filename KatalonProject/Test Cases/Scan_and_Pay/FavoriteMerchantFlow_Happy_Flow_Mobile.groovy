import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 7.0 Favourite Merchant - Add merchant to favourites after payment
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/7-0-favourite-merchant.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: payment completed.
    Mobile.tap(findTestObject('Android/favoritemerchantflow/addtofavourites'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/favoritemerchantflow/merchantinfavourites'), 10)
} finally {
    Mobile.closeApplication()
}
