import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FitpeoHomePageTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        //Opening the chrome browser instance with its path
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\91739\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        //Create a new instance of ChromeDriver
        driver = new ChromeDriver();

        //Wait until to reach the expectation
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Navigate to the Home page
        driver.get("https://www.fitpeo.com/");

        //To Maximize the current browser
        driver.manage().window().maximize();

    }


    @Test()
    public void HomePage(){

        //Verify the current URL
        String currentURL = "https://www.fitpeo.com/";
        wait.until(ExpectedConditions.urlToBe(currentURL));

        Assert.assertEquals(driver.getCurrentUrl(), currentURL , "URL's doesn't match" );
        System.out.println("URL's matched");

        //Verify the Title
        String expectedTitle = "Remote Patient Monitoring";
        Assert.assertTrue(driver.getTitle().contains(expectedTitle), "Page title does not match!");

        System.out.println("Title matched");

    }


    @Test(priority = 1)
    public void NavigateToRevenueCalculatorPageTest(){

        // Locate the link or button to the Revenue Calculator page
        WebElement revenueCalculatorLink = driver.findElement(By.linkText("Revenue Calculator"));

        // Verify the link is displayed and clickable
        Assert.assertTrue(revenueCalculatorLink.isDisplayed(), "Revenue Calculator link is not visible");
        System.out.println("Revenue Calculator link is displayed");

        // Click the link
        revenueCalculatorLink.click();

        String expectedURL = "https://www.fitpeo.com/revenue-calculator";

        //wait 10 secs for revenue calculator page is loaded
        wait.until(ExpectedConditions.urlToBe(expectedURL));

        // Verify the navigation to the Revenue Calculator page
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedURL), "Failed to navigate to the Revenue Calculator page");
        System.out.println("Navigate to the Revenue Calculator is successful");

        String expectedTitle = "Remote Patient Monitoring (RPM) - fitpeo.com";

        //Verify the Page Title
        Assert.assertTrue(driver.getTitle().contains(expectedTitle), "Page title does not match");
        System.out.println("Page is Successfully loaded");

    }



    @AfterMethod
    public void teardown() {

        //Close the browser
        driver.close();
    }


}