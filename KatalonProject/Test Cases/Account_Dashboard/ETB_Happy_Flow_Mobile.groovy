import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

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
