import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Authentication & Authorisation_v3.0@20260507.xlsx | Feature: 16.0 Secure2U Approval - User completes Secure2u approval flow
// Traceability: artifacts/fsd-auth-and-authz-v3-0-20260507/test-cases/16-0-secure2u-approval.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: Secure2u is configured for the account.
    Mobile.tap(findTestObject('Android/secure2uapprovalhappyflow/initiatesecure2urequest'), 10)
    // Approve using the Secure2u test fixture.
    Mobile.verifyElementVisible(findTestObject('Android/secure2uapprovalhappyflow/approvalacceptedscreen'), 10)
} finally {
    Mobile.closeApplication()
}
