import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function 48: Installment Conversion - Secure2U EDW
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-48-installment-conversion-secure2u-edw.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user confirmed an Installment Conversion request and reached Secure2U authorisation.
    // TODO: Object Repository has no captured object for the numeric Secure2U passcode pad on the
    // verification screen; the createsecure2u keypad objects below are reused as the closest available match.
    Mobile.tap(findTestObject('Android/createsecure2u/row1key11'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row2key25'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row3key39'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row1key22'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row2key14'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row3key28'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/confirm'), 10)

    // Business rule: after successful SFTP file transfer, the installment data is sent to EDW.
    // Failed EDW transmission is retried by system or scheduler (TBC); existing mapping file format is used.
    // These are backend-only assertions; no UI element exists to verify EDW transmission directly.
} finally {
    Mobile.closeApplication()
}
