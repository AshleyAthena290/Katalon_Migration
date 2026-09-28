"""Generate Katalon happy flows and mobile objects from the ETB onboarding FSD."""

from __future__ import annotations

import html
import re
import uuid
from pathlib import Path

import pandas as pd


ROOT = Path(__file__).resolve().parents[1]
SOURCE = ROOT / "Input" / "FSD_ETB_Onboarding_v2.0@20260415.xlsx"
PROJECT = ROOT / "KatalonProject"
PROJECT_DESCRIPTOR = PROJECT / ".project"
CLASSPATH_DESCRIPTOR = PROJECT / ".classpath"
KATALON_DESCRIPTOR = PROJECT / "KatalonProject.prj"
OBJECTS = PROJECT / "Object Repository" / "Onboarding"
SCRIPTS = PROJECT / "Scripts"
PROFILES = PROJECT / "Profiles"
TEST_CASES = PROJECT / "Test Cases" / "ETB Onboarding"

COMMON = [
    ("ImAMaybankCustomer", "I'm a Maybank Customer"),
    ("AcknowledgementCheckbox", "Acknowledgement Checkbox"),
    ("IAgreeConsent", "I agree & consent"),
]
WITH_M2U = [
    ("Username", "Username"),
    ("Next", "Next"),
    ("Password", "Password"),
    ("LogIn", "Log in"),
    ("Proceed", "Proceed"),
    ("Nickname", "Nickname"),
    ("SaveNext", "Save & next"),
    ("AllowOnce", "Allow once"),
    ("AllowNotification", "Allow"),
    ("AccountList", "Account List"),
    ("Confirm", "Confirm"),
    ("SetupLater", "Setup Later"),
    ("GoToDashboard", "Go to Dashboard"),
]
WITHOUT_M2U = [
    ("RegisterWithDebitCard", "Register with debit card"),
    ("CardNumber", "Credit/Debit card number"),
    ("CardExpiryDate", "Credit/Debit card expiry date"),
    ("CardPin", "Credit/Debit card PIN"),
    ("AccountDetailsNext", "Next"),
    ("CreateUsername", "Username"),
    ("CreateUsernameConfirm", "Confirm"),
    ("NewPassword", "New Password"),
    ("ConfirmPassword", "Confirm Password"),
    ("CreatePasswordConfirm", "Confirm"),
    ("SecurityImages", "Security Images"),
    ("SecurityImageNext", "Next"),
    ("Otp", "OTP"),
    ("M2UAccessCreated", "Maybank2u access created"),
    ("AccessProceed", "Proceed"),
    ("ExploreTheApp", "Explore the app"),
]
CREDIT_CARD = [
    ("RegisterWithCreditCard", "Register with credit card"),
    ("CreditCardNumber", "Credit card number"),
    ("CreditCardExpiryDate", "Credit card expiry date"),
    ("CreditCardPin", "Credit card PIN"),
]


def escape_xml(value: object) -> str:
    return html.escape(str(value), quote=True)


def groovy(value: object) -> str:
    return str(value).replace("\\", "\\\\").replace("'", "\\'").replace("\n", "\\n")


def object_xml(name: str, label: str) -> str:
    guid = uuid.uuid5(uuid.NAMESPACE_URL, f"katalon://etb-onboarding/{name}")
    property_guid = lambda value: uuid.uuid5(uuid.NAMESPACE_URL, f"katalon://etb-onboarding/{name}/{value}")
    xpath = f"//*[@class = 'android.view.ViewGroup' and (@text = '' or . = '') and @content-desc = '{label}']"
    ui_automator = f'new UiSelector().description("{label}")'
    return f'''<?xml version="1.0" encoding="UTF-8"?>
<MobileElementEntity>
    <description>ETB FSD happy-flow object. Captured Katalon mobile schema; confirm device properties against the target app build.</description>
    <name>{escape_xml(name)}</name>
    <tag>FSD_ETB_Onboarding_v2.0@20260415</tag>
    <elementGuidId>{guid}</elementGuidId>
    <selectorMethod>BASIC</selectorMethod>
    <smartLocatorEnabled>false</smartLocatorEnabled>
    <useRalativeImagePath>false</useRalativeImagePath>
    <webElementProperties>
        <isSelected>false</isSelected>
        <matchCondition>equals</matchCondition>
        <name>enabled</name>
        <type>Main</type>
        <value>true</value>
        <webElementGuid>{property_guid('enabled')}</webElementGuid>
    </webElementProperties>
    <webElementProperties>
        <isSelected>false</isSelected>
        <matchCondition>equals</matchCondition>
        <name>class</name>
        <type>Main</type>
        <value>android.view.ViewGroup</value>
        <webElementGuid>{property_guid('class')}</webElementGuid>
    </webElementProperties>
    <webElementProperties>
        <isSelected>true</isSelected>
        <matchCondition>equals</matchCondition>
        <name>content-desc</name>
        <type>Main</type>
        <value>{escape_xml(label)}</value>
        <webElementGuid>{property_guid('content-desc')}</webElementGuid>
    </webElementProperties>
    <webElementProperties>
        <isSelected>false</isSelected>
        <matchCondition>equals</matchCondition>
        <name>displayed</name>
        <type>Main</type>
        <value>true</value>
        <webElementGuid>{property_guid('displayed')}</webElementGuid>
    </webElementProperties>
    <locatorCollection>
        <entry>
            <key>XPATH</key>
            <value>{escape_xml(xpath)}</value>
        </entry>
        <entry>
            <key>ID</key>
            <value></value>
        </entry>
        <entry>
            <key>ACCESSIBILITY</key>
            <value>{escape_xml(label)}</value>
        </entry>
        <entry>
            <key>CLASS_NAME</key>
            <value>android.view.ViewGroup</value>
        </entry>
        <entry>
            <key>ANDROID_UI_AUTOMATOR</key>
            <value>{escape_xml(ui_automator)}</value>
        </entry>
        <entry>
            <key>ATTRIBUTES</key>
            <value>{escape_xml(xpath)}</value>
        </entry>
        <entry>
            <key>NAME</key>
            <value></value>
        </entry>
        <entry>
            <key>ANDROID_VIEWTAG</key>
            <value></value>
        </entry>
        <entry>
            <key>IMAGE</key>
            <value></value>
        </entry>
        <entry>
            <key>CUSTOM</key>
            <value></value>
        </entry>
    </locatorCollection>
    <locatorStrategy>ATTRIBUTES</locatorStrategy>
    <platform>ANDROID</platform>
</MobileElementEntity>
'''


def ref(name: str) -> str:
    return f"findTestObject('Object Repository/Onboarding/{name}')"


def tap(name: str) -> str:
    return f"Mobile.tap({ref(name)}, 10)"


def set_text(name: str, variable: str) -> str:
    return f"Mobile.setText({ref(name)}, GlobalVariable.{variable}, 10)"


def header(test_name: str, requirement: str) -> list[str]:
    return [
        "import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject",
        "import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile",
        "import com.kms.katalon.core.util.KeywordUtil",
        "import internal.GlobalVariable",
        "",
        f"KeywordUtil.logInfo('{groovy(requirement)}')",
        "Mobile.startApplication(GlobalVariable.appPath, false)",
        "try {",
    ]


def footer() -> list[str]:
    return ["} finally {", "    Mobile.closeApplication()", "}"]


def with_m2u_script() -> str:
    lines = header("WithM2U", "FSD happy flow: ETB with existing M2U ID")
    lines += [
        f"    {tap('ImAMaybankCustomer')}",
        f"    {tap('AcknowledgementCheckbox')}",
        f"    {tap('IAgreeConsent')}",
        f"    {set_text('Username', 'm2uUsername')}",
        f"    {tap('Next')}",
        "    KeywordUtil.logInfo('Complete A&A security-image verification using the approved test fixture.')",
        f"    {set_text('Password', 'm2uPassword')}",
        f"    {tap('LogIn')}",
        f"    {tap('Proceed')}",
        f"    {set_text('Nickname', 'nickname')}",
        f"    {tap('SaveNext')}",
        f"    {tap('Proceed')}",
        f"    {tap('AllowOnce')}",
        f"    {tap('AllowNotification')}",
        f"    {tap('AccountList')}",
        f"    {tap('Confirm')}",
        "    KeywordUtil.logInfo('Complete A&A biometric setup with the approved test fixture, then choose Setup Later.')",
        f"    {tap('SetupLater')}",
        f"    Mobile.verifyElementVisible({ref('GoToDashboard')}, 10)",
        f"    {tap('GoToDashboard')}",
    ]
    lines += footer()
    return "\n".join(lines) + "\n"


def without_m2u_script() -> str:
    lines = header("WithoutM2U", "FSD happy flow: ETB without existing M2U ID, CASA/debit-card path")
    lines += [
        f"    {tap('ImAMaybankCustomer')}",
        f"    {tap('AcknowledgementCheckbox')}",
        f"    {tap('IAgreeConsent')}",
        f"    {tap('RegisterWithDebitCard')}",
        f"    {set_text('CardNumber', 'cardNumber')}",
        f"    {set_text('CardExpiryDate', 'cardExpiryDate')}",
        f"    {set_text('CardPin', 'cardPin')}",
        f"    {tap('AccountDetailsNext')}",
        f"    {set_text('CreateUsername', 'newUsername')}",
        f"    {tap('CreateUsernameConfirm')}",
        f"    {set_text('NewPassword', 'newPassword')}",
        f"    {set_text('ConfirmPassword', 'newPassword')}",
        f"    {tap('CreatePasswordConfirm')}",
        "    KeywordUtil.logInfo('Select the default security image required by the FSD.')",
        f"    {tap('SecurityImages')}",
        f"    {tap('SecurityImageNext')}",
        f"    {set_text('Otp', 'otp')}",
        "    KeywordUtil.logInfo('Submit SMS OTP through the referenced A&A verification screen.')",
        f"    Mobile.verifyElementVisible({ref('M2UAccessCreated')}, 10)",
        f"    {tap('AccessProceed')}",
        f"    {set_text('Nickname', 'nickname')}",
        f"    {tap('SaveNext')}",
        f"    {tap('Proceed')}",
        f"    {tap('AllowOnce')}",
        f"    {tap('AllowNotification')}",
        f"    {tap('AccountList')}",
        f"    {tap('Confirm')}",
        "    KeywordUtil.logInfo('Complete A&A biometric setup with the approved test fixture, then choose Setup Later.')",
        f"    {tap('SetupLater')}",
        f"    Mobile.verifyElementVisible({ref('ExploreTheApp')}, 10)",
        f"    {tap('ExploreTheApp')}",
    ]
    lines += footer()
    return "\n".join(lines) + "\n"


def credit_card_script() -> str:
    lines = header("WithCreditCard", "FSD happy flow: ETB credit-card customer without existing M2U ID")
    lines += [
        f"    {tap('ImAMaybankCustomer')}",
        f"    {tap('AcknowledgementCheckbox')}",
        f"    {tap('IAgreeConsent')}",
        f"    {tap('RegisterWithCreditCard')}",
        f"    {set_text('CreditCardNumber', 'cardNumber')}",
        f"    {set_text('CreditCardExpiryDate', 'cardExpiryDate')}",
        f"    {set_text('CreditCardPin', 'cardPin')}",
        f"    {tap('AccountDetailsNext')}",
        f"    {set_text('CreateUsername', 'newUsername')}",
        f"    {tap('CreateUsernameConfirm')}",
        f"    {set_text('NewPassword', 'newPassword')}",
        f"    {set_text('ConfirmPassword', 'newPassword')}",
        f"    {tap('CreatePasswordConfirm')}",
        "    KeywordUtil.logInfo('Select the default security image required by the FSD.')",
        f"    {tap('SecurityImages')}",
        f"    {tap('SecurityImageNext')}",
        f"    {set_text('Otp', 'otp')}",
        "    KeywordUtil.logInfo('Submit SMS OTP through the referenced A&A verification screen.')",
        f"    Mobile.verifyElementVisible({ref('M2UAccessCreated')}, 10)",
        f"    {tap('AccessProceed')}",
        f"    {set_text('Nickname', 'nickname')}",
        f"    {tap('SaveNext')}",
        f"    {tap('Proceed')}",
        f"    {tap('AllowOnce')}",
        f"    {tap('AllowNotification')}",
        f"    {tap('AccountList')}",
        f"    {tap('Confirm')}",
        "    KeywordUtil.logInfo('Complete A&A biometric setup with the approved test fixture, then choose Setup Later.')",
        f"    {tap('SetupLater')}",
        f"    Mobile.verifyElementVisible({ref('ExploreTheApp')}, 10)",
        f"    {tap('ExploreTheApp')}",
    ]
    lines += footer()
    return "\n".join(lines) + "\n"


def profile_xml() -> str:
    variables = [
        ("appPath", "Absolute path to the APK or IPA", ""),
        ("m2uUsername", "Approved M2U test username", ""),
        ("m2uPassword", "Approved M2U test password", ""),
        ("cardNumber", "Approved card test number", ""),
        ("cardExpiryDate", "Approved card expiry test value", ""),
        ("cardPin", "Approved card PIN test value", ""),
        ("newUsername", "Approved new username test value", ""),
        ("newPassword", "Approved new password test value", ""),
        ("nickname", "Approved nickname test value", ""),
        ("otp", "Approved SMS OTP test value", ""),
    ]
    entities = "\n".join(
        f'''    <GlobalVariableEntity>
        <description>{escape_xml(description)}</description>
        <initValue>"{escape_xml(value)}"</initValue>
        <name>{name}</name>
        <tag>FSD happy flow</tag>
        <valueType>STRING</valueType>
    </GlobalVariableEntity>'''
        for name, description, value in variables
    )
    return f'''<?xml version="1.0" encoding="UTF-8"?>
<GlobalVariableEntities>
    <description>ETB onboarding FSD happy-flow configuration. Populate with approved non-production values.</description>
    <name>default</name>
    <tag>FSD_ETB_Onboarding_v2.0@20260415</tag>
    <defaultProfile>true</defaultProfile>
{entities}
</GlobalVariableEntities>
'''


def test_case_xml(name: str, description: str) -> str:
    guid = uuid.uuid5(uuid.NAMESPACE_URL, f"katalon://etb-onboarding/test-case/{name}")
    return f'''<?xml version="1.0" encoding="UTF-8"?>
<TestCaseEntity>
    <description>{escape_xml(description)}</description>
    <name>{name}</name>
    <tag>FSD_ETB_Onboarding_v2.0@20260415; happy flow</tag>
    <comment></comment>
    <testCaseGuid>{guid}</testCaseGuid>
    <testCaseId>Test Cases/ETB Onboarding/{name}</testCaseId>
    <isReuseDriver>false</isReuseDriver>
    <isRunNextCaseAutomatically>false</isRunNextCaseAutomatically>
    <testCaseType>Mobile</testCaseType>
</TestCaseEntity>
'''


def project_descriptor() -> str:
    return '''<?xml version="1.0" encoding="UTF-8"?>
<projectDescription>
    <name>KatalonProject</name>
    <comment></comment>
    <projects></projects>
    <buildSpec>
        <buildCommand>
            <name>com.kms.katalon.project.builder</name>
            <arguments></arguments>
        </buildCommand>
    </buildSpec>
    <natures>
        <nature>com.kms.katalon.project.nature</nature>
    </natures>
</projectDescription>
'''


def classpath_descriptor() -> str:
    return '''<?xml version="1.0" encoding="UTF-8"?>
<classpath>
    <classpathentry kind="src" path="Keywords"/>
    <classpathentry kind="src" path="Scripts"/>
    <classpathentry kind="src" path="Test Cases"/>
    <classpathentry kind="src" path="Test Listeners"/>
    <classpathentry kind="src" path="Include"/>
    <classpathentry kind="con" path="com.kms.katalon.core.classpathcontainer"/>
    <classpathentry kind="output" path="bin"/>
</classpath>
'''


def katalon_descriptor() -> str:
     return '''<?xml version="1.0" encoding="UTF-8"?>
<Project>
    <description>ETB onboarding mobile happy-flow project.</description>
    <name>KatalonProject</name>
    <tag>FSD_ETB_Onboarding_v2.0@20260415</tag>
    <UUID>9236b607-5177-5435-baf7-e776b4ef37a7</UUID>
    <createdEdition>FREE</createdEdition>
    <createdVersion>11.4.0</createdVersion>
    <freeLicense>true</freeLicense>
    <modifiedEdition>FREE</modifiedEdition>
    <modifiedVersion>11.4.0</modifiedVersion>
    <pageLoadTimeout>0</pageLoadTimeout>
    <sourceContent>
        <sourceFolderList>
            <sourceFolderConfiguration>
                <url>Include/scripts/groovy</url>
            </sourceFolderConfiguration>
        </sourceFolderList>
        <systemFolderList>
            <systemFolderConfiguration>
                <url>Include/scripts/groovy</url>
            </systemFolderConfiguration>
            <systemFolderConfiguration>
                <url>Include/features</url>
            </systemFolderConfiguration>
            <systemFolderConfiguration>
                <url>Include/config</url>
            </systemFolderConfiguration>
        </systemFolderList>
    </sourceContent>
    <timeStampInProperties>false</timeStampInProperties>
    <type>MOBILE</type>
</Project>
'''


def main() -> None:
    workbook = pd.ExcelFile(SOURCE)
    required_sheets = {
        "1.0 ETB - Onboard Landing",
        "2.0 ETB - Consent",
        "3.0 ETB - w M2U Login Username",
        "10.0 ETB - wo M2U Acc Details",
        "17.0 ETB - wo M2U Final",
    }
    missing = required_sheets.difference(workbook.sheet_names)
    if missing:
        raise RuntimeError(f"FSD sheets missing: {sorted(missing)}")

    objects = dict(COMMON + WITH_M2U + WITHOUT_M2U + CREDIT_CARD)
    OBJECTS.mkdir(parents=True, exist_ok=True)
    (SCRIPTS / "ETB_Onboarding_Happy_Flow_With_M2U").mkdir(parents=True, exist_ok=True)
    (SCRIPTS / "ETB_Onboarding_Happy_Flow_Without_M2U").mkdir(parents=True, exist_ok=True)
    (SCRIPTS / "ETB_Onboarding_Happy_Flow_With_Credit_Card").mkdir(parents=True, exist_ok=True)
    PROFILES.mkdir(parents=True, exist_ok=True)
    TEST_CASES.mkdir(parents=True, exist_ok=True)
    PROJECT_DESCRIPTOR.write_text(project_descriptor(), encoding="utf-8")
    CLASSPATH_DESCRIPTOR.write_text(classpath_descriptor(), encoding="utf-8")
    KATALON_DESCRIPTOR.write_text(katalon_descriptor(), encoding="utf-8")

    for name, label in objects.items():
        (OBJECTS / f"{name}.rs").write_text(object_xml(name, label), encoding="utf-8")
    for path in OBJECTS.glob("*.rs"):
        if path.stem not in objects:
            label = path.stem.replace("_", " ")
            (path).write_text(object_xml(path.stem, label), encoding="utf-8")
    (SCRIPTS / "ETB_Onboarding_Happy_Flow_With_M2U" / "ScriptETB_Onboarding_Happy_Flow_With_M2U.groovy").write_text(
        with_m2u_script(), encoding="utf-8"
    )
    (SCRIPTS / "ETB_Onboarding_Happy_Flow_Without_M2U" / "ScriptETB_Onboarding_Happy_Flow_Without_M2U.groovy").write_text(
        without_m2u_script(), encoding="utf-8"
    )
    (SCRIPTS / "ETB_Onboarding_Happy_Flow_With_Credit_Card" / "ScriptETB_Onboarding_Happy_Flow_With_Credit_Card.groovy").write_text(
        credit_card_script(), encoding="utf-8"
    )
    (PROFILES / "default.glbl").write_text(profile_xml(), encoding="utf-8")
    (TEST_CASES / "ETB_Onboarding_Happy_Flow_With_M2U.tc").write_text(
        test_case_xml(
            "ETB_Onboarding_Happy_Flow_With_M2U",
            "FSD happy flow for an existing M2U ID: consent, login, nickname, permissions, primary account, biometric setup, and dashboard.",
        ),
        encoding="utf-8",
    )
    (TEST_CASES / "ETB_Onboarding_Happy_Flow_Without_M2U.tc").write_text(
        test_case_xml(
            "ETB_Onboarding_Happy_Flow_Without_M2U",
            "FSD happy flow for a debit-card user without an M2U ID: account details, username, password, security image, OTP, access creation, nickname, permissions, and dashboard.",
        ),
        encoding="utf-8",
    )
    (TEST_CASES / "ETB_Onboarding_Happy_Flow_With_Credit_Card.tc").write_text(
        test_case_xml(
            "ETB_Onboarding_Happy_Flow_With_Credit_Card",
            "FSD happy flow for a credit-card user without an M2U ID: credit-card details, username, password, security image, OTP, access creation, nickname, permissions, and dashboard.",
        ),
        encoding="utf-8",
    )
    print(f"Generated {len(objects)} objects, 3 scripts, and 3 test cases from {len(workbook.sheet_names)} sheets")


if __name__ == "__main__":
    main()
