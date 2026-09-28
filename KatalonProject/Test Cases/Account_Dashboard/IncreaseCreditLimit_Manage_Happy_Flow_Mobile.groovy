import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function: Increase Credit Limit - Manage
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-increase-credit-limit-manage.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.verifyElementExist(findTestObject('Android/maindashboard/quickactions'), 10)
    Mobile.tap(findTestObject('Android/maindashboard/accounts'), 10)

    // TODO: Object Repository has no captured object for Manage Credit Card > Increase Credit Limit entry link.
    // TODO: Run appium-scaffold --screen IncreaseCreditLimitManage --namespace maybank-mobile, then tap the
    // real "Increase credit limit" hyperlink here (only shown if the card is eligible).

    // Business rule: option greyed out if a request was already submitted within the last 6 months, with
    // message "You can increase your limit once every 6 months." and "Earliest next request date: [date]".
    // TODO: Mobile.verifyElementText(findTestObject('Android/increase-credit-limit-manage/currentlimit'), '<IDR current limit>')

    // Limit Type radio: Permanent / Temporary, no default selection.
    // TODO: Mobile.tap(findTestObject('Android/increase-credit-limit-manage/limittypepermanent'), 10)

    // Business rule: tapping [Confirm] validates all mandatory fields; missing selection shows
    // "Select a limit type to proceed".
    // TODO: Mobile.tap(findTestObject('Android/increase-credit-limit-manage/confirm'), 10)
} finally {
    Mobile.closeApplication()
}
