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

// FSD: FSD_App Dashboard_Banking & Wealth_v2.0@20260421.xlsx | Feature: 18.0 S2U Cooling off Period - View Secure2u cooling-off period notice and proceed
// Traceability: artifacts/fsd-app-dashboard-banking-wealth-v2-0-20260421/test-cases/18-0-s2u-cooling-off-period.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: Secure2u setup was just completed and the cooling-off countdown has started.
    Mobile.verifyElementVisible(findTestObject('Android/s2ucoolingoffperiod/secure2uactivation'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/s2ucoolingoffperiod/coolingoffperiod'), 10)
    Mobile.tap(findTestObject('Android/s2ucoolingoffperiod/proceed'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/s2ucoolingoffperiod/home'), 10)
} finally {
    Mobile.closeApplication()
}
