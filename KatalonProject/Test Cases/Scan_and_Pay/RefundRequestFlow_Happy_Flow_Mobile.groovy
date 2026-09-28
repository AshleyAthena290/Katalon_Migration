import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 5.1 Refund Request - Initiate refund flow after paying via scan
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/5-1-refund-request.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: payment exists and is refundable.
    Mobile.tap(findTestObject('Android/refundrequestflow/transactions'), 10)
    Mobile.tap(findTestObject('Android/refundrequestflow/selectpayment'), 10)
    Mobile.tap(findTestObject('Android/refundrequestflow/requestrefund'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/refundrequestflow/refundsubmitted'), 10)
} finally {
    Mobile.closeApplication()
}
