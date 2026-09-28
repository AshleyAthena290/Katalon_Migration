import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

KeywordUtil.logInfo('FSD happy flow: ETB with existing M2U ID')
Mobile.startApplication(GlobalVariable.appPath, false)
try {
    Mobile.tap(findTestObject('Object Repository/Onboarding/ImAMaybankCustomer'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/AcknowledgementCheckbox'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/IAgreeConsent'), 10)
    Mobile.setText(findTestObject('Object Repository/Onboarding/Username'), GlobalVariable.m2uUsername, 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/Next'), 10)
    KeywordUtil.logInfo('Complete A&A security-image verification using the approved test fixture.')
    Mobile.setText(findTestObject('Object Repository/Onboarding/Password'), GlobalVariable.m2uPassword, 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/LogIn'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/Proceed'), 10)
    Mobile.setText(findTestObject('Object Repository/Onboarding/Nickname'), GlobalVariable.nickname, 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/SaveNext'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/Proceed'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/AllowOnce'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/AllowNotification'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/AccountList'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/Confirm'), 10)
    KeywordUtil.logInfo('Complete A&A biometric setup with the approved test fixture, then choose Setup Later.')
    Mobile.tap(findTestObject('Object Repository/Onboarding/SetupLater'), 10)
    Mobile.verifyElementVisible(findTestObject('Object Repository/Onboarding/GoToDashboard'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/GoToDashboard'), 10)
} finally {
    Mobile.closeApplication()
}
