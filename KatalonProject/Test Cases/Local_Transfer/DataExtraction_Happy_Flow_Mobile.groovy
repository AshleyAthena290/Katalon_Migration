import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.5 Data Extraction - Verify Local Transfer data extraction module availability
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-5-data-extraction.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: Local Transfer data extraction module is configured in NGBO/back office.
    Mobile.verifyElementVisible(findTestObject('Android/dataextraction/localtransfer'), 10)
    // Business rule: scheduled/recurring SKN/RTGS transactions and their recurring originations are covered per extraction notes.
} finally {
    Mobile.closeApplication()
}
