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

// FSD: FSD_Account Dashboard_Time Deposits_v2.0@20260624.xlsx | Feature: 1.1.1.2 Manage- EarlyWithdrawal - Submit an early withdrawal and confirm via the acknowledgement screen
// Traceability: artifacts/fsd-account-dashboard-time-deposits-v2-0-20260624/test-cases/1-1-1-2-manage-earlywithdrawal.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication(GlobalVariable.appPath, false)

try {
    // Precondition: TD account was opened via the app, is active, and passes the early-withdrawal soft-check cut-off.
    Mobile.tap(findTestObject('Android/timedepositearlywithdrawal/earlywithdrawal'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositearlywithdrawal/earlywithdrawaltitle'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositearlywithdrawal/earlywithdrawaldisclaimer'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositearlywithdrawal/closingamount'), 10)
    Mobile.tap(findTestObject('Android/timedepositearlywithdrawal/withdrawaldetailstooltip'), 10)
    // Business rule: penalty applies for Conventional TD; cancellation charge applies for Shariah TD.
    Mobile.verifyElementVisible(findTestObject('Android/timedepositearlywithdrawal/withdrawalamount'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositearlywithdrawal/transfertoaccount'), 10)
    Mobile.tap(findTestObject('Android/timedepositearlywithdrawal/nextbutton'), 10)
    // Business rule: T&C screen is not applicable for the early-withdrawal feature.
    Mobile.verifyElementVisible(findTestObject('Android/timedepositearlywithdrawal/confirmationtitle'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositearlywithdrawal/confirmationclosingamount'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositearlywithdrawal/confirmationtransferto'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositearlywithdrawal/confirmationpersonaldetails'), 10)
    Mobile.tap(findTestObject('Android/timedepositearlywithdrawal/confirmbutton'), 10)
    // Business rule: Confirm navigates to the [A&A] Input Passcode flow before the withdrawal is submitted.
    Mobile.verifyElementVisible(findTestObject('Android/timedepositearlywithdrawal/acknowledgementstatusimage'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositearlywithdrawal/acknowledgementrefid'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositearlywithdrawal/acknowledgementwithdrawalamount'), 10)
    // Business rule: destination account balance updates in real time and a push notification/email is sent on success.
    Mobile.tap(findTestObject('Android/timedepositearlywithdrawal/donebutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositearlywithdrawal/timedepositdashboardscreen'), 10)
} finally {
    Mobile.closeApplication()
}
