import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function: Credit Card Details - Manage
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-credit-card-details-manage.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.verifyElementExist(findTestObject('Android/maindashboard/quickactions'), 10)
    Mobile.tap(findTestObject('Android/maindashboard/accounts'), 10)

    // TODO: Object Repository has no captured object for Credit Card Details > Manage tab.
    // TODO: Run appium-scaffold --screen CreditCardDetailsManage --namespace maybank-mobile, then navigate
    // into a card's Manage tab here.

    // Manage Features Matrix (enable = clickable, disable = greyed out and not actionable):
    // Nickname, Xcash (only if active NGBO offering), Installment Conversion (hidden for corporate card),
    // Increase Credit Limit (greyed out if MOB < 6 months / pending / within 6 months of last approval),
    // Apply Supplementary Card, Card PIN Reset, Block Card, Unblock Card (shown only if blocked by app),
    // Replace Card (hidden for corporate card), Treats Conversion Setting (only shown for Whitecard).
    // TODO: Mobile.verifyElementExist(findTestObject('Android/credit-card-details-manage/xcash'), 10)
    // TODO: Mobile.verifyElementExist(findTestObject('Android/credit-card-details-manage/installmentconversion'), 10)
    // TODO: Mobile.verifyElementExist(findTestObject('Android/credit-card-details-manage/increasecreditlimit'), 10)
    // TODO: Mobile.verifyElementExist(findTestObject('Android/credit-card-details-manage/blockcard'), 10)
} finally {
    Mobile.closeApplication()
}
