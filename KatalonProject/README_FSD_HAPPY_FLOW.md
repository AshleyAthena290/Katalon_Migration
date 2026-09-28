# ETB onboarding FSD happy flow

Generated from `Input/FSD_ETB_Onboarding_v2.0@20260415.xlsx`.

## Generated artifacts

- `Test Cases/ETB Onboarding/`: three Katalon test-case descriptors.
- `Scripts/ETB_Onboarding_Happy_Flow_With_M2U/`: successful existing-M2U-ID path.
- `Scripts/ETB_Onboarding_Happy_Flow_Without_M2U/`: successful debit-card path for a user without an M2U ID.
- `Scripts/ETB_Onboarding_Happy_Flow_With_Credit_Card/`: successful credit-card path for a user without an M2U ID.
- `Object Repository/Onboarding/`: shared mobile objects, including credit-card-specific controls.
- `Profiles/default.glbl`: app path and non-production test-data variables.

## Required setup

1. Populate `Profiles/default.glbl` with an APK/IPA path and approved non-production test values.
2. Confirm the generated XPath selectors against the app build. The FSD provides labels and behavior, but no native resource IDs or accessibility IDs.
3. Configure the device and the referenced A&A fixtures for security-image, biometric, and SMS OTP steps.
4. In Katalon Studio, use **File > Open Project** and select `KatalonProject/KatalonProject.prj` (not only the parent folder). Then execute either test case.

Regenerate after FSD changes with:

```text
python tools/create_fsd_happy_flow.py
```
