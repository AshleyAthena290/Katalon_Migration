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

// FSD: FSD_Account Dashboard_Time Deposits_v2.0@20260624.xlsx | Feature: 1.1 Time Deposit- Dashboard - View the Time Deposit dashboard, mask/unmask total deposits, and open a placement
// Traceability: artifacts/fsd-account-dashboard-time-deposits-v2-0-20260624/test-cases/1-1-time-deposit-dashboard.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication(GlobalVariable.appPath, false)

try {
    // Precondition: user has at least one active Time Deposit placement and is on the Account Dashboard.
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdashboard/totaldeposits'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdashboard/basedonindicativeratestooltip'), 10)
    Mobile.tap(findTestObject('Android/timedepositdashboard/eyeicon'), 10)
    // Business rule: eye icon masks/unmasks the total deposits; first-time tap shows a coach mark.
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdashboard/timedepositscard'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdashboard/maturitydate'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdashboard/tdstatuslabel'), 10)
    Mobile.tap(findTestObject('Android/timedepositdashboard/sortby'), 10)
    // Business rule: Sort By options follow the preset toggle order regardless of CASA/TD mix.
    Mobile.tap(findTestObject('Android/timedepositdashboard/sortbyclosebutton'), 10)
    // Business rule: Time Deposit data is fetched with caching; auto-collapsible sticky header reacts to scroll direction.
    Mobile.tap(findTestObject('Android/timedepositdashboard/timedepositcarditem'), 10)
    // Business rule: tapping a placement redirects to the Time Deposit Details screen.
    Mobile.verifyElementVisible(findTestObject('Android/timedepositdashboard/timedepositdetailsscreen'), 10)
} finally {
    Mobile.closeApplication()
}
