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

// FSD: FSD_Account Dashboard_Financing_v2.0@20260618.xlsx | Feature: Function 92: CC Activation - Secure2U FMA
// Traceability: artifacts/fsd-account-dashboard-financing-v2-0-20260618/test-cases/function-92-cc-activation-secure2u-fma.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: user has reached the Secure2U passcode authorisation step from Credit Card Activation.
    Mobile.verifyElementExist(findTestObject('Android/activesecure2u/whatissecure2u'), 10)
    Mobile.verifyElementExist(findTestObject('Android/activesecure2u/approvetransactionssafelyandquicklywithamemorablepasscode'), 10)

    // Fields: Passcode (Numeric, mandatory) validated by Secure2U.
    // TODO: Object Repository has no captured object for the numeric Secure2U passcode input pad on the
    // verification screen; the createsecure2u keypad objects below are reused as the closest available match.
    Mobile.tap(findTestObject('Android/createsecure2u/row1key11'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row2key25'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row3key39'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row1key22'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row2key14'), 10)
    Mobile.tap(findTestObject('Android/createsecure2u/row3key28'), 10)

    // Action: [OK] submits the correct passcode and proceeds with the card activation request.
    // TODO: Object Repository has no captured object for the OK/Cancel actions on this specific screen.
    // Business rule: data is sent to FMS for fraud monitoring before Cardlink processes the request.
} finally {
    Mobile.closeApplication()
}
