# FitPeo Automation Assignment

## Objective
This project involves automating the navigation and interaction with elements on the **FitPeo Homepage** and its **Revenue Calculator** page using Selenium.

---

## Test Cases Automated

### 1. Navigate to the FitPeo Homepage
- Verify the correct page title.
- Check the presence of key elements on the homepage.

### 2. Navigate to the Revenue Calculator Page
- Ensure the URL changes to the expected Revenue Calculator page URL.
- Verify that the Revenue Calculator page header or unique elements are displayed.

### 3. Scroll to the Slider Section
- Verify the slider is in view by checking its visibility attribute.

### 4. Adjust the Slider to a Value of 820
- Confirm that the bottom text field updates to display **820** when the slider is adjusted.

### 5. Update the Text Field to 560
- Verify that the slider’s position visually changes to reflect the value **560**.
- Ensure the text field retains the value **560**.

### 6. Validate the Slider's Position
- Ensure the slider’s visual position corresponds to the entered value **560**.
- Validate the underlying HTML or JavaScript attributes (e.g., `value` or `aria-valuenow`).

### 7. Select CPT Codes: CPT-99091, CPT-99453, CPT-99454, CPT-99474
- Ensure each checkbox is correctly selected (use the `isSelected()` method).
- Verify no unintended checkboxes are selected.

### 8. Validate the Total Recurring Reimbursement Calculation
- Confirm the displayed total is **$110,700** as expected.
- Validate that the total changes correctly if CPT selections are modified.

### 9. Verify the Header Displaying Total Recurring Reimbursement
- Confirm the header displaying **Total Recurring Reimbursement for All Patients Per Month** shows **$110,700**.

---

## Execution Flow

### 1. Set Up
- Initialize the WebDriver.
- Configure browser settings and navigate to the homepage.

### 2. Test Execution
- Execute each test case sequentially using Selenium actions.
- Capture screenshots or logs for validation points.

### 3. Tear Down
- Close the browser and clean up resources.

---

## Tools & Techniques
- **Automation Framework:** Selenium WebDriver.
- **Programming Language:** Java.
- **Build Tool:** Maven/Gradle.
- **Test Runner:** TestNG or JUnit.
- **Validations:** Assertions to verify UI behavior and calculations.
