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

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 3.0 Quick Actions (All) - Launch a Quick Action from the home dashboard
// Figma: [UI] Home Dashboard - ID (For Development), frame "homeappdashboard_Banking" (375x812) - node-id 15477-223634
// Screen tiles (left to right): Transfer, Pay Bills, Top Up, Cardless Withdrawal
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/3-0-quick-actions-all.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below use Figma-confirmed labels as placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user is on the home dashboard with Quick Actions configured.
    Mobile.verifyElementVisible(findTestObject('Android/quickactions/transfer'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/quickactions/paybills'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/quickactions/topup'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/quickactions/cardlesswithdrawal'), 10)
    Mobile.tap(findTestObject('Android/quickactions/transfer'), 10)
    // Business rule: if the action is unavailable, show a disabled message instead of navigating.
    Mobile.verifyElementVisible(findTestObject('Android/quickactions/transfer'), 10)
} finally {
    Mobile.closeApplication()
}
