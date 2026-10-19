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

// FSD: FSD_Account Dashboard_Time Deposits_v2.0@20260624.xlsx | Feature: 1.1.1 Time Deposit Details - View Time Deposit details and access Manage actions
// Traceability: artifacts/fsd-account-dashboard-time-deposits-v2-0-20260624/test-cases/1-1-1-time-deposit-details.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication(GlobalVariable.appPath, false)

try {
    // Precondition: user navigated from the Time Deposit dashboard to a selected TD placement.
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdetails/productname'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdetails/accountnumber'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdetails/principalamount'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdetails/placementdate'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdetails/tenure'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdetails/maturitydate'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdetails/interestrate'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdetails/maturityinstruction'), 10)
    // Business rule: Update maturity instruction and Early withdrawal are only shown for app-opened, active TD accounts.
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdetails/updatematurityinstruction'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdetails/earlywithdrawal'), 10)
    Mobile.tap(findTestObject('Android/timedepositdetails/viewstatementbutton'), 10)
    // Business rule: [<] back button returns to the Time Deposit Dashboard.
    Mobile.tap(findTestObject('Android/timedepositdetails/backbutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdetails/timedepositdashboardscreen'), 10)
} finally {
    Mobile.closeApplication()
}
