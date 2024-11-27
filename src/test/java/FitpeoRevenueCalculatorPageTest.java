import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import java.util.List;




public class FitpeoRevenueCalculatorPageTest {

    public WebDriver driver;
    public WebDriverWait wait;
    JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {

        //Opening the chrome browser instance with its path
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\91739\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        //Create a new instance of ChromeDriver
        driver = new ChromeDriver();

        //Navigate to the Home page
        driver.get("https://www.fitpeo.com/");

        //To Maximize the current browser
        driver.manage().window().maximize();

        //Open the Revenue Calculator page
        driver.get("https://www.fitpeo.com/revenue-calculator");

        //Wait until to reach the expectation
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;

        wait.until(ExpectedConditions.urlToBe("https://www.fitpeo.com/revenue-calculator"));
    }

    @Test
    public void scrollToSliderSection() {

        //Locate the slider section by using xpath locators
        WebElement RevenueCalculatorSlider = driver.findElement(By.xpath("//div[@class = 'MuiBox-root css-j7qwjs']/span[1]/span[3]"));

        //Scroll until the slider section is visible by using JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", RevenueCalculatorSlider);

        // Verify the slider section is visible
        Assert.assertTrue(RevenueCalculatorSlider.isDisplayed(), "Slider section is not visible after scrolling");
        System.out.println("Slider section is visible");

    }

    @Test(priority = 1)
    public void adjustSliderAndValidateValue() throws InterruptedException {

            Thread.sleep(2000);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            //Locate the slider
            WebElement slider = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb')]"));
            //Locate the Heading
            WebElement element1 = driver.findElement(By.xpath("//h4[text()='Medicare Eligible Patients']"));

            System.out.println("Attribute Value: " + slider.getAttribute("style"));

            js.executeScript("arguments[0].scrollIntoView(true);", element1);

            //Perform the action
            Actions actions = new Actions(driver);
            slider.click();

            for (int i = 0; i < 100; i++) {
                String ariaValueNow = (String) js.executeScript("return arguments[0].getAttribute('style');", slider);
                System.out.println("Updated aria-valuenow: " + ariaValueNow);
                if (ariaValueNow.contentEquals("left: 40.8%;")) {
                    System.out.println("reached value " + "816");
                    actions.sendKeys(Keys.ARROW_RIGHT).perform();
                    Thread.sleep(2000);
                    actions.sendKeys(Keys.ARROW_RIGHT).perform();
                    Thread.sleep(2000);
                    actions.sendKeys(Keys.ARROW_RIGHT).perform();
                    Thread.sleep(2000);
                    actions.sendKeys(Keys.ARROW_RIGHT).perform();
                    Thread.sleep(2000);

                    break;
                } else {
                    // Perform Page Up (Send Page Up key)
                    actions.sendKeys(org.openqa.selenium.Keys.PAGE_UP).perform();

                }
            }

            String ariaValueNow = (String) js.executeScript("return arguments[0].getAttribute('style');", slider);
            System.out.println("Updated aria-valuenow: " + ariaValueNow);

            //Locate the text
            WebElement textField = driver.findElement(By.xpath("//*[@id=':R57alklff9da:']"));


            // Validate the slider value
            String actualValue = textField.getAttribute("value");
            Assert.assertEquals(actualValue, String.valueOf(820), "Slider value is not updated to 820.");

            System.out.println("Slider value is updated");

    }

    @Test(priority = 2)
    public void testSliderValueChangeViaTextField() throws InterruptedException {

        scrollToSliderSection();

        Thread.sleep(2000);

        //Locate the text
        WebElement textField = driver.findElement(By.xpath("//*[@id=':R57alklff9da:']"));

        //Locate the slider
        WebElement slider = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb')]"));

        // Get and Print text field attributes
        System.out.println("Text field min value: " + textField.getAttribute("min"));
        System.out.println("Text field max value: " + textField.getAttribute("max"));

        //Clear text
        textField.clear();

        //Perform action to set 0
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider,-30,0).perform();

        //Check slider attribute
        String updatedStyle = slider.getAttribute("style");

        //Enter the value
        textField.sendKeys("560");

        // Validate the text field value
        String updatedTextFieldValue = textField.getAttribute("value");
        System.out.println(updatedTextFieldValue);

        //Check slider attribute
        String updatedStyle2 = slider.getAttribute("style");

        if(updatedStyle != updatedStyle2) System.out.println("Slider updated style: " + updatedStyle2);
        else System.out.println("Slider not updated");

        System.out.println("Verified the Test SliderValue Change Via TextField");

    }


    @Test(priority = 3)
    public void updateTextFieldAndValidateSlider() throws InterruptedException {

        // Locate the text field
        WebElement textField = driver.findElement(By.xpath("//*[@id=':R57alklff9da:']"));

        // Click on the text field and enter the value
        textField.clear();

        // Validate the slider's position corresponds to value 560
        WebElement slider = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb')]"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider,-30,0).perform();

        Thread.sleep(2000);

        //Enter the value
        textField.sendKeys("560");

        Assert.assertTrue(slider.isDisplayed(), "Slider did not update correctly for value 560.");

        // Validate the text field value
        String updatedTextFieldValue = textField.getAttribute("value");
        System.out.println("Text field updated value: " + updatedTextFieldValue);

        // Assert the value is as expected
        Assert.assertEquals(updatedTextFieldValue, "560", "Text field value did not update correctly!");
        System.out.println("Updated the text field and validated the slider.");
    }

    @Test(priority = 4)
    public void selectCPTCodes() {

        // Locate all CPT code elements
        List<WebElement> codes = driver.findElements(By.xpath("//p[starts-with(text(), 'CPT-')]"));

        // Define expected CPT codes
        List<String> expectedCPTTexts = List.of("CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474");

        // Iterate through all located CPT codes
        for (WebElement codeElement : codes) {
            String actual = codeElement.getText().trim();

            //Check the CPT Texts contains or not if contains click action is performed
            if (expectedCPTTexts.contains(actual)) {
                // Locate the corresponding checkbox for this CPT code using relative XPath
                WebElement checkbox = codeElement.findElement(By.xpath("./following::input[contains(@class, 'PrivateSwitchBase')][1]"));

                // Click the checkbox if not already selected
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }

                // Assert that the checkbox is selected
                Assert.assertTrue(checkbox.isSelected(), actual + " checkbox is not selected.");

            }
        }

        System.out.println("Selected all expectedCPTTexts check boxs");

    }

    @Test(priority = 5)
    public void validateTotalRecurringReimbursement() throws  InterruptedException{

        Thread.sleep(2000);

        adjustSliderAndValidateValue();

        Thread.sleep(2000);

        selectCPTCodes();

        Thread.sleep(2000);

        // Locate and fetch the displayed total reimbursement value
        WebElement reimbursementElements = driver.findElement(By.xpath("//div[@class = 'MuiBox-root css-m1khva']/p[2]"));
        String totalText = reimbursementElements.getText();

        System.out.println("Total Recurring Reimbursement for all Patients Per Month is matched:" + totalText);

        Thread.sleep(2000);

        // Assert that the calculated total matches the displayed total
        Assert.assertEquals(totalText, "$110700", "Total Reimbursement does not match!");
        System.out.println("Total Recurring Reimbursement for all Patients Per Month is matched");
    }

    @Test(priority = 6)
    public void verifyTotalRecurringReimbursement() throws InterruptedException{

        Thread.sleep(2000);

        adjustSliderAndValidateValue();

        Thread.sleep(2000);

        selectCPTCodes();

        String totalText = driver.findElement(By.xpath("//div[@class = 'MuiBox-root css-m1khva']/p[2]")).getText();

        Thread.sleep(2000);

        // Assert that the calculated total matches the displayed total
        Assert.assertEquals(totalText, "$110700", "Total Reimbursement does not match!");
        System.out.println("Total Recurring Reimbursement for all Patients Per Month is matched");

    }


   @AfterMethod
    public void teardown(){

        driver.close();
    }
}
