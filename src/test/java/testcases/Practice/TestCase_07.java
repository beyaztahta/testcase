package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_07 {
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        //    1. Launch browser
        //    2. Navigate to url 'http://automationexercise.com'
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

    @Test
    public void Test01() {
        //3. Verify that home page is visible successfully. Ana sayfanın başarıyla göründüğünü doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());

    }

    @Test
    public void Test02() {
        //4. Click on 'Test Cases' button. 'Test Durumları' düğmesine tıklayın
        //5. Verify user is navigated to test cases page successfully. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın

        driver.navigate().refresh();
        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();
        driver.navigate().refresh();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Test Cases']")).isEnabled());
    }


}
