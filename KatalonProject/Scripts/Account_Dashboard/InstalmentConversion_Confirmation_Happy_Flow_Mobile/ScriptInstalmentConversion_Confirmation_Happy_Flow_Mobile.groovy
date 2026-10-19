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

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function: Instalment Conversion - Confirmation
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-instalment-conversion-confirmation.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    Mobile.verifyElementExist(findTestObject('Android/maindashboard/quickactions'), 10)

    // TODO: Object Repository has no captured object for the Instalment Conversion - Confirmation screen.
    // TODO: Run appium-scaffold --screen InstalmentConversionConfirmation --namespace maybank-mobile, then
    // replace the TODOs below with real objects.

    // Business rule: confirmation screen displays each transaction's Merchant, Amount, Tenure,
    // Monthly instalment, Admin fee, and Conversion fee.
    // TODO: Mobile.verifyElementExist(findTestObject('Android/instalment-conversion-confirmation/merchant1'), 10)

    // Business rule: [Edit] hyperlink returns to Select Transaction screen; confirming edits skips T&C
    // and returns directly to the Confirmation page with updated values.
    // TODO: Mobile.tap(findTestObject('Android/instalment-conversion-confirmation/edit'), 10)

    // Business rule: [Confirm] navigates to the [A&A] Input Passcode (Secure2U) flow; once authentication
    // completes, the system navigates to the Acknowledgement screen.
    // TODO: Mobile.tap(findTestObject('Android/instalment-conversion-confirmation/confirm'), 10)
} finally {
    Mobile.closeApplication()
}
