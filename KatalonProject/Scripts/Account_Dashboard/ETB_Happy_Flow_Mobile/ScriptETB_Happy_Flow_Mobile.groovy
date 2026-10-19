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

// TODO: Replace with the configured Maybank Android application path or APK.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Onboarding landing screen: select the existing Maybank customer path.
    Mobile.verifyElementExist(findTestObject('Android/login/imamaybankcustomer'), 10)
    Mobile.verifyElementText(findTestObject('Android/login/imamaybankcustomer'), "I'm a Maybank customer")
    Mobile.tap(findTestObject('Android/login/imamaybankcustomer'), 10)

    // Permission/Consent screen.
    Mobile.verifyElementExist(findTestObject('Android/acknowledgement/acknowledgementandconsent'), 10)
    // The available object exposes "Acknowledgement and consent"; the FSD title is
    // "Select Acknowledgment and Consent". Keep this assertion aligned to the object.
    Mobile.verifyElementText(findTestObject('Android/acknowledgement/acknowledgementandconsent'), 'Acknowledgement and consent')

    // TODO: Add the acknowledgement checkbox object; it is not in the supplied repository objects.
    // TODO: Tap the acknowledgement checkbox before submitting consent.
    Mobile.tap(findTestObject('Android/acknowledgement2/iagreeconsent'), 10)

    // FSD expected result: navigate to the Login screen.
    Mobile.verifyElementExist(findTestObject('Android/username/username'), 10)
    Mobile.verifyElementText(findTestObject('Android/username/username'), 'Username')

    // TODO: The supplied repository has no Login Next button object.
    // TODO: Tap Login Next after providing a valid NGA username.
    Mobile.setText(findTestObject('Android/username/username2'), 'validNgaUsername', 10)
} finally {
    Mobile.closeApplication()
}
