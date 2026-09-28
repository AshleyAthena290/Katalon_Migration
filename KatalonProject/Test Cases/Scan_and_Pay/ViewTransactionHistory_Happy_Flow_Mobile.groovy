import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD Feedback_Scan & Pay_v2.0_20260612_Consolidated.xlsx | Feature: 6.1 Transaction History - View recent scan & pay transactions
// Traceability: artifacts/fsd-scan-and-pay-v2-0-20260612/test-cases/6-1-transaction-history.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.tap(findTestObject('Android/viewtransactionhistory/transactionstab'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/viewtransactionhistory/recenttransactionslist'), 10)
    Mobile.tap(findTestObject('Android/viewtransactionhistory/transactionitem'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/viewtransactionhistory/transactiondetail'), 10)
} finally {
    Mobile.closeApplication()
}
