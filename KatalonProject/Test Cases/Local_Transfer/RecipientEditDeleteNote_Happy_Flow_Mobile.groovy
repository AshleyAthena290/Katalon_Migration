import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

// FSD: FSD_Local_Transfer_v2.0@20260612.xlsx | Feature: 1.2.5 Recipient - Edit Del Note - Edit an existing beneficiary nickname
// Traceability: artifacts/fsd-local-transfer-v2-0-20260612/test-cases/1-2-5-recipient-edit-del-note.test-cases.json
// TODO: Replace with the configured Maybank Android application path or APK.
// TODO: Object Repository has no captured objects for this screen; the paths below are placeholders.
Mobile.startApplication('path/to/Maybank.apk', false)

try {
    // Precondition: beneficiary already has a nickname set.
    Mobile.tap(findTestObject('Android/recipienteditdeletenote/editnickname'), 10)
    Mobile.setText(findTestObject('Android/recipienteditdeletenote/beneficiarynickname'), 'BestFriend', 10)
    Mobile.tap(findTestObject('Android/recipienteditdeletenote/savebutton'), 10)
    Mobile.verifyElementVisible(findTestObject('Android/recipienteditdeletenote/beneficiarynickname'), 10)
} finally {
    Mobile.closeApplication()
}
