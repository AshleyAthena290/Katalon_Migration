import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

KeywordUtil.logInfo('FSD happy flow: ETB credit-card customer without existing M2U ID')
Mobile.startApplication(GlobalVariable.appPath, false)
try {
    Mobile.tap(findTestObject('Object Repository/Onboarding/ImAMaybankCustomer'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/AcknowledgementCheckbox'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/IAgreeConsent'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/RegisterWithCreditCard'), 10)
    Mobile.setText(findTestObject('Object Repository/Onboarding/CreditCardNumber'), GlobalVariable.cardNumber, 10)
    Mobile.setText(findTestObject('Object Repository/Onboarding/CreditCardExpiryDate'), GlobalVariable.cardExpiryDate, 10)
    Mobile.setText(findTestObject('Object Repository/Onboarding/CreditCardPin'), GlobalVariable.cardPin, 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/AccountDetailsNext'), 10)
    Mobile.setText(findTestObject('Object Repository/Onboarding/CreateUsername'), GlobalVariable.newUsername, 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/CreateUsernameConfirm'), 10)
    Mobile.setText(findTestObject('Object Repository/Onboarding/NewPassword'), GlobalVariable.newPassword, 10)
    Mobile.setText(findTestObject('Object Repository/Onboarding/ConfirmPassword'), GlobalVariable.newPassword, 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/CreatePasswordConfirm'), 10)
    KeywordUtil.logInfo('Select the default security image required by the FSD.')
    Mobile.tap(findTestObject('Object Repository/Onboarding/SecurityImages'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/SecurityImageNext'), 10)
    Mobile.setText(findTestObject('Object Repository/Onboarding/Otp'), GlobalVariable.otp, 10)
    KeywordUtil.logInfo('Submit SMS OTP through the referenced A&A verification screen.')
    Mobile.verifyElementVisible(findTestObject('Object Repository/Onboarding/M2UAccessCreated'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/AccessProceed'), 10)
    Mobile.setText(findTestObject('Object Repository/Onboarding/Nickname'), GlobalVariable.nickname, 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/SaveNext'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/Proceed'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/AllowOnce'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/AllowNotification'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/AccountList'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/Confirm'), 10)
    KeywordUtil.logInfo('Complete A&A biometric setup with the approved test fixture, then choose Setup Later.')
    Mobile.tap(findTestObject('Object Repository/Onboarding/SetupLater'), 10)
    Mobile.verifyElementVisible(findTestObject('Object Repository/Onboarding/ExploreTheApp'), 10)
    Mobile.tap(findTestObject('Object Repository/Onboarding/ExploreTheApp'), 10)
} finally {
    Mobile.closeApplication()
}
