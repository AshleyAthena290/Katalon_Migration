import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

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
