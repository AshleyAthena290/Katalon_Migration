import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 2.0 Scan Bill - Bill Payment - Scan bill QR and pay bill
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/2-0-scan-bill-bill-payment.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: bill QR contains Biller ID and amount.
    Mobile.tap(findTestObject('Android/billpaymentviascan/scanbill'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/billpaymentviascan/billername'), 10)
    Mobile.setText(findTestObject('Android/billpaymentviascan/amount'), '120.50', 10)
    Mobile.tap(findTestObject('Android/billpaymentviascan/pay'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/billpaymentviascan/paymentconfirmation'), 10)
} finally {
    Mobile.closeApplication()
}
