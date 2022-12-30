package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_11 {
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
        //3. Verify that home page is visible successfully//3. Ana sayfanın başarıyla göründüğünü doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
    }

    @Test
    public void Test02() {
        //4. Click 'Cart' button 4. 'Sepet' düğmesine tıklayın


        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();

        //5. Scroll down to footer   5. Altbilgiye doğru aşağı kaydırın
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //6. Verify text 'SUBSCRIPTION'   6. 'ABONELİK' metnini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Subscription']")).isDisplayed());

    }

    @Test
    public void Test03() {
        //7. Enter email address in input and click arrow button   7. Giriş alanına e-posta adresini girin ve ok düğmesine tıklayın
        //8. Verify success message 'You have been successfully subscribed!' is visible  8. Başarı mesajını doğrulayın 'Başarılı bir şekilde abone oldunuz!' görünür
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("salla@gmail.com", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert-success alert']")).isDisplayed());
    }

}
