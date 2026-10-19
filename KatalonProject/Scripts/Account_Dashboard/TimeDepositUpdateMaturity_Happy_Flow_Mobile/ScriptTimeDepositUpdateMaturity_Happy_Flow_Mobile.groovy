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

// FSD: FSD_Account Dashboard_Time Deposits_v2.0@20260624.xlsx | Feature: 1.1.1.1 Manage- Update Maturity - Update the maturity instruction and confirm via the acknowledgement screen
// Traceability: artifacts/fsd-account-dashboard-time-deposits-v2-0-20260624/test-cases/1-1-1-1-manage-update-maturity.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication(GlobalVariable.appPath, false)

try {
    // Precondition: TD account was opened via the app, is active, and passes the update-maturity soft-check cut-off.
    Mobile.tap(findTestObject('Android/timedepositupdatematurity/updatematurityinstruction'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositupdatematurity/updatematurityinstructiontitle'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositupdatematurity/currentmaturityinstruction'), 10)
    Mobile.tap(findTestObject('Android/timedepositupdatematurity/maturityinstructiondropdown'), 10)
    // Business rule: drawer lists Auto-rollover (principal & interest), Auto-rollover (principal only), and Disburse funds.
    Mobile.tap(findTestObject('Android/timedepositupdatematurity/autorolloverprincipalonlyoption'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositupdatematurity/transfertoaccount'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositupdatematurity/maturityinstructionalert'), 10)
    Mobile.tap(findTestObject('Android/timedepositupdatematurity/nextbutton'), 10)
    // Business rule: T&C screen is not applicable for the update-maturity feature.
    Mobile.verifyElementVisible(findTestObject('Android/timedepositupdatematurity/confirmationtitle'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositupdatematurity/confirmationmaturityinstruction'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositupdatematurity/confirmationtransferto'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositupdatematurity/confirmationpersonaldetails'), 10)
    Mobile.tap(findTestObject('Android/timedepositupdatematurity/confirmbutton'), 10)
    // Business rule: Confirm navigates to the [A&A] Input Passcode flow before the update is submitted.
    Mobile.verifyElementVisible(findTestObject('Android/timedepositupdatematurity/acknowledgementstatusimage'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositupdatematurity/acknowledgementrefid'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositupdatematurity/acknowledgementmaturityinstruction'), 10)
    // Business rule: a push notification and email are sent only when the update is successful; no receipt is issued.
    Mobile.tap(findTestObject('Android/timedepositupdatematurity/donebutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositupdatematurity/timedepositdetailsscreen'), 10)
} finally {
    Mobile.closeApplication()
}
