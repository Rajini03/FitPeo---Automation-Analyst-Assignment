# FitPeo Automation Assignment

## Objective
This project involves automating the navigation and interaction with elements on the FitPeo Homepage and its Revenue Calculator page using Selenium.. 
Below is a step-by-step breakdown of each test case:

## Test Cases Automated
##1. Navigate to the FitPeo Homepage:
   *Verify the page title is correct (e.g., "FitPeo - Welcome").
   *Check that key elements.
   
##2. Navigate to the Revenue Calculator Page:
   *Ensure the URL changes to the expected Revenue Calculator page URL.
   *Verify that the Revenue Calculator page header or unique elements are displayed.

##3. Scroll to the slider section:
   *Verify the slider is in view by checking its visibility attribute.

##4. Adjust the slider to a value of 820:
    *Confirm that the bottom text field updates to display 820 when the slider is adjusted.

##5. Update the text field to 560:
    *Verify that the slider’s position visually changes to reflect the value 560.
    *Ensure the text field retains the value 560.
    
##6. Validate the slider's position:
    *Ensure the slider’s visual position corresponds to the entered value 560.
    *Validate the underlying HTML or JavaScript attributes (e.g., value or aria-valuenow).

##7. Select CPT codes: CPT-99091, CPT-99453, CPT-99454, CPT-99474:
    *Ensure each checkbox is correctly selected (check isSelected() method).
    *Verify no unintended checkboxes are selected.

##8. Validate the Total Recurring Reimbursement calculation:
     *Confirm the displayed total is $110,700 as expected.
     *Validate that the total changes correctly if CPT selections are modified.
 
##9. Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month:
     *Confirm the header displaying Total Recurring Reimbursment for all patients per Month is $110,700.

##Execution Flow
##Set Up:
*Initialize the WebDriver.
*Configure browser settings and navigate to the homepage.

##Test Execution:
*Execute each test case sequentially using Selenium actions.
*Capture screenshots or logs for validation points.

##Tear Down:
*Close the browser and clean up resources.

##Tools & Techniques
*Automation Framework: Selenium WebDriver.
*Programming Language: Java.
*Build Tool: Maven/Gradle.
*Test Runner: TestNG or JUnit.
*Validations: Assertions to verify UI behavior and calculations.

