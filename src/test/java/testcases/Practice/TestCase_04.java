package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_04 {

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        //    1. Launch browser
        //    2. Navigate to url 'http://automationexercise.com'
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @Test
    public void HomePageVisibilityTest() {
        //    3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
    }

    @Test
    public void LoginToYourAccountVisibilityTest() {
        //    4. Click on 'Signup / Login' button
        //    5. Verify 'Login to your account' is visible
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed());
    }

    @Test
    public void loggedInAsUsernameTest() {
        //    6. Enter correct email address and password
        //    7. Click 'login' button
        //    8. Verify that 'Logged in as username' is visible
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("yesil@gmail.com", Keys.TAB, "yesil", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed());
    }

    @Test
    public void logOutAndReturnLoginPageTest() {
        //    9. Click 'Logout' button
        //    10. Verify that user is navigated to login page
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed());
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

}
