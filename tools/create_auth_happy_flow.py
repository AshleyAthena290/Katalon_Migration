"""Generate 20 Katalon happy-flow scripts from the Authentication & Authorisation FSD.

Source: Input/FSD_Authentication & Authorisation_v3.0@20260507.xlsx

Output: 20 flat `<Name>_Happy_Flow_Mobile.groovy` files under
`KatalonProject/Test Cases/Authentication` following the project's
existing generator style.
"""

from __future__ import annotations

import re
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PROJECT = ROOT / "KatalonProject"
TEST_CASES = PROJECT / "Test Cases" / "Authentication"

FSD_SOURCE = "FSD_Authentication & Authorisation_v3.0@20260507.xlsx"
ARTIFACT_SLUG = "fsd-auth-and-authz-v3-0-20260507"


def slugify(value: str) -> str:
    return re.sub(r"[^a-z0-9]+", "-", value.lower()).strip("-")


def control_slug(value: str) -> str:
    return re.sub(r"[^a-z0-9]+", "", value.lower())


# Each step is one of:
#   ("verify", "Human label")           -> Mobile.verifyElementVisible
#   ("tap", "Human label")              -> Mobile.tap
#   ("setText", "Human label", "value") -> Mobile.setText
#   ("note", "Precondition/Action/Business rule text") -> plain comment
FLOWS: list[tuple[str, str, str, list[tuple]]] = [
    ("LoginHappyFlow", "1.0 Login - Successful Login", "User logs in with valid credentials",
     [("note", "Precondition: user has a registered account."),
      ("tap", "Username field"), ("setText", "Username field", "testuser"),
      ("tap", "Password field"), ("setText", "Password field", "password123"),
      ("tap", "Login button"), ("verify", "Home dashboard")]),

    ("LogoutHappyFlow", "1.1 Logout - Successful Logout", "User logs out safely",
     [("note", "Precondition: user is logged in."), ("tap", "Profile menu"),
      ("tap", "Logout button"), ("verify", "Login screen")]),

    ("ChangePasswordHappyFlow", "2.0 Change Password", "User changes password successfully",
     [("note", "Precondition: user is logged in."), ("tap", "Settings"),
      ("tap", "Change password"), ("setText", "Current password", "password123"),
      ("setText", "New password", "newPassword123"), ("setText", "Confirm new password", "newPassword123"),
      ("tap", "Save button"), ("verify", "Password changed confirmation")]),

    ("ForgotPasswordHappyFlow", "3.0 Forgot Password", "User recovers password via OTP",
     [("note", "Precondition: user has registered phone/email."), ("tap", "Forgot password link"),
      ("setText", "Registered email or phone", "testuser@example.com"), ("tap", "Request OTP"),
      ("note", "Business rule: OTP delivered to registered channel in non-production fixture."),
      ("setText", "OTP field", "123456"), ("tap", "Proceed"), ("verify", "Reset password screen")]),

    ("MFAEnrollmentHappyFlow", "4.0 MFA Enrollment", "User enrolls a new MFA method",
     [("note", "Precondition: user is logged in."), ("tap", "Security settings"),
      ("tap", "Add authentication method"), ("tap", "SMS OTP"),
      ("setText", "Phone number field", "+60123456789"), ("tap", "Send OTP"),
      ("setText", "OTP field", "123456"), ("tap", "Confirm"), ("verify", "MFA method listed")]),

    ("MFALoginHappyFlow", "4.1 MFA Login", "User logs in with MFA enabled",
     [("note", "Precondition: user has MFA configured."), ("tap", "Username field"),
      ("setText", "Username field", "mfauser"), ("tap", "Password field"),
      ("setText", "Password field", "password123"), ("tap", "Login button"),
      ("setText", "OTP field", "123456"), ("tap", "Verify"), ("verify", "Home dashboard")]),

    ("SecurityImageSetupHappyFlow", "5.0 Security Image Setup", "User sets security image successfully",
     [("note", "Precondition: user is in security setup flow."), ("tap", "Choose security image"),
      ("tap", "Default image"), ("tap", "Save image"), ("verify", "Security image saved confirmation")]),

    ("BiometricEnrollmentHappyFlow", "6.0 Biometric Enrollment", "User enrolls fingerprint/face for auth",
     [("note", "Precondition: device supports biometrics."), ("tap", "Enable biometrics"),
      ("note", "Follow device biometric fixture to complete enrollment."), ("verify", "Biometric enabled state")]),

    ("BiometricLoginHappyFlow", "6.1 Biometric Login", "User authenticates via biometrics",
     [("note", "Precondition: biometrics enrolled."), ("tap", "Use biometric"),
      ("note", "Authenticate using test biometric fixture."), ("verify", "Home dashboard")]),

    ("SessionTimeoutHappyFlow", "7.0 Session Timeout", "User session times out and is re-authenticated",
     [("note", "Precondition: user is logged in."), ("note", "Simulate inactivity until session timeout."),
      ("verify", "Session expired screen"), ("tap", "Re-login"), ("verify", "Home dashboard")]),

    ("AccountLockoutHappyFlow", "8.0 Account Lockout", "Account locks after configured failed attempts",
     [("note", "Precondition: account exists and is unlocked."),
      ("tap", "Username field"), ("setText", "Username field", "lockuser"),
      ("tap", "Password field"), ("setText", "Password field", "wrong1"), ("tap", "Login button"),
      ("tap", "Password field"), ("setText", "Password field", "wrong2"), ("tap", "Login button"),
      ("tap", "Password field"), ("setText", "Password field", "wrong3"), ("tap", "Login button"),
      ("verify", "Account locked message")]),

    ("OTPVerificationHappyFlow", "9.0 OTP Verification", "OTP verification during sensitive flows",
     [("note", "Precondition: OTP-triggering action performed."), ("setText", "OTP field", "123456"),
      ("tap", "Submit OTP"), ("verify", "Success confirmation")]),

    ("DeviceRegistrationHappyFlow", "10.0 Device Registration", "Register a new device for remembered device list",
     [("note", "Precondition: user completes login on a new device."), ("tap", "Remember this device"),
      ("tap", "Register device"), ("verify", "Device registered confirmation")]),

    ("RememberMeHappyFlow", "11.0 Remember Me", "User enables remember-me for faster login",
     [("note", "Precondition: login screen visible."), ("tap", "Remember me checkbox"),
      ("tap", "Login button"), ("verify", "Next login uses remembered device/credential")]),

    ("RevokeDeviceHappyFlow", "12.0 Revoke Device", "User revokes a registered device from their profile",
     [("note", "Precondition: user has at least one registered device."), ("tap", "Registered devices"),
      ("tap", "Device options"), ("tap", "Revoke"), ("verify", "Device removed from list")]),

    ("UpdateContactHappyFlow", "13.0 Update Contact Details", "User updates recovery contact details",
     [("note", "Precondition: user is logged in."), ("tap", "Profile"), ("tap", "Contact details"),
      ("setText", "Mobile number", "+60123456789"), ("tap", "Save"), ("verify", "Contact updated confirmation")]),

    ("ViewSessionsHappyFlow", "14.0 View Active Sessions", "User views active sessions list",
     [("note", "Precondition: multiple active sessions exist."), ("tap", "Security settings"),
      ("tap", "Active sessions"), ("verify", "Session list visible")]),

    ("Manage2FAMethodsHappyFlow", "15.0 Manage 2FA Methods", "User adds/removes 2FA methods",
     [("note", "Precondition: user is logged in."), ("tap", "Security settings"),
      ("tap", "Two-factor methods"), ("tap", "Add method"), ("tap", "SMS"), ("tap", "Save"),
      ("verify", "2FA method present in list")]),

    ("Secure2UApprovalHappyFlow", "16.0 Secure2U Approval", "User completes Secure2u approval flow",
     [("note", "Precondition: Secure2u is configured for the account."), ("tap", "Initiate Secure2u request"),
      ("note", "Approve using the Secure2u test fixture."), ("verify", "Approval accepted screen")]),

    ("RecoveryOptionsHappyFlow", "17.0 Recovery Options", "User configures recovery options successfully",
     [("note", "Precondition: user is logged in."), ("tap", "Recovery options"), ("tap", "Add recovery email"),
      ("setText", "Recovery email", "recovery@example.com"), ("tap", "Save"), ("verify", "Recovery configured")]),

    ("AuthAuditHappyFlow", "18.0 Authentication Audit", "User views audit of recent auth events",
     [("note", "Precondition: audit records exist."), ("tap", "Security settings"), ("tap", "Authentication audit"),
      ("verify", "Recent events list")]),

    ("SsoHappyFlow", "19.0 SSO Integration", "User authenticates via enterprise SSO (happy path)",
     [("note", "Precondition: SSO configured for tenant."), ("tap", "Sign in with SSO"),
      ("note", "Follow SSO provider fixture to complete auth."), ("verify", "Home dashboard")]),

    ("AccountRecoveryHappyFlow", "20.0 Account Recovery", "User performs account recovery via support flow",
     [("note", "Precondition: user begins recovery flow."), ("tap", "Contact support"),
      ("tap", "Start recovery"), ("setText", "Customer reference", "REF12345"), ("tap", "Submit"),
      ("verify", "Recovery submitted confirmation")]),
]


def object_ref(flow_slug: str, label: str) -> str:
    return f"findTestObject('Android/{flow_slug}/{control_slug(label)}')"


def script_body(flow_name: str, section: str, requirement: str, steps: list[tuple]) -> str:
    flow_slug = slugify(flow_name)
    artifact_path = f"artifacts/{ARTIFACT_SLUG}/test-cases/{slugify(section)}.test-cases.json"
    lines = [
        "import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject",
        "",
        "import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile",
        "",
        f"// FSD: {FSD_SOURCE} | Feature: {section} - {requirement}",
        f"// Traceability: {artifact_path}",
        "// TODO: Replace with the configured Maybank Android application path or APK.",
        "// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.",
        "Mobile.startApplication('path/to/Maybank.apk', false)",
        "",
        "try {",
    ]
    for step in steps:
        kind = step[0]
        if kind == "note":
            lines.append(f"    // {step[1]}")
        elif kind == "verify":
            lines.append(f"    Mobile.verifyElementVisible({object_ref(flow_slug, step[1])}, 10)")
        elif kind == "tap":
            lines.append(f"    Mobile.tap({object_ref(flow_slug, step[1])}, 10)")
        elif kind == "setText":
            lines.append(f"    Mobile.setText({object_ref(flow_slug, step[1])}, '{step[2]}', 10)")
        else:
            raise ValueError(f"Unknown step kind: {kind}")
    lines += ["} finally {", "    Mobile.closeApplication()", "}"]
    return "\n".join(lines) + "\n"


def main() -> None:
    TEST_CASES.mkdir(parents=True, exist_ok=True)
    for flow_name, section, requirement, steps in FLOWS:
        (TEST_CASES / f"{flow_name}_Happy_Flow_Mobile.groovy").write_text(
            script_body(flow_name, section, requirement, steps), encoding="utf-8", newline="\n"
        )
    print(f"Generated {len(FLOWS)} happy-flow scripts under {TEST_CASES}")


if __name__ == "__main__":
    main()
