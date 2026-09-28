import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 5.0 Split Bill - Split bill among multiple payers using QR split feature
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/5-0-split-bill.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: merchant/organiser creates split request.
    Mobile.tap(findTestObject('Android/splitbillflow/scansplitqr'), 10)
    Mobile.setText(findTestObject('Android/splitbillflow/shareamount'), '25', 10)
    Mobile.tap(findTestObject('Android/splitbillflow/confirm'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/splitbillflow/splitaccepted'), 10)
} finally {
    Mobile.closeApplication()
}
