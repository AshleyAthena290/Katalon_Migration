package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile default : Absolute path to the APK or IPA</p>
     */
    public static Object appPath
     
    /**
     * <p>Profile default : Approved M2U test username</p>
     */
    public static Object m2uUsername
     
    /**
     * <p>Profile default : Approved M2U test password</p>
     */
    public static Object m2uPassword
     
    /**
     * <p>Profile default : Approved debit-card test number</p>
     */
    public static Object cardNumber
     
    /**
     * <p>Profile default : Approved card expiry test value</p>
     */
    public static Object cardExpiryDate
     
    /**
     * <p>Profile default : Approved card PIN test value</p>
     */
    public static Object cardPin
     
    /**
     * <p>Profile default : Approved new username test value</p>
     */
    public static Object newUsername
     
    /**
     * <p>Profile default : Approved new password test value</p>
     */
    public static Object newPassword
     
    /**
     * <p>Profile default : Approved nickname test value</p>
     */
    public static Object nickname
     
    /**
     * <p>Profile default : Approved SMS OTP test value</p>
     */
    public static Object otp
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables('default')
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
    
            appPath = selectedVariables['appPath']
            m2uUsername = selectedVariables['m2uUsername']
            m2uPassword = selectedVariables['m2uPassword']
            cardNumber = selectedVariables['cardNumber']
            cardExpiryDate = selectedVariables['cardExpiryDate']
            cardPin = selectedVariables['cardPin']
            newUsername = selectedVariables['newUsername']
            newPassword = selectedVariables['newPassword']
            nickname = selectedVariables['nickname']
            otp = selectedVariables['otp']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
