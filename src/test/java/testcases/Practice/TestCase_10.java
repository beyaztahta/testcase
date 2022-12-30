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

public class TestCase_10 {
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
        //4. Scroll down to footer//4. Alt bilgiye doğru aşağı kaydırın
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }

    @Test
    public void Test03() {
        //5. Verify text 'SUBSCRIPTION' //5. 'ABONELİK' metnini doğrulayın
     Assert.assertTrue( driver.findElement(By.xpath("//h2[normalize-space()='Subscription']")).isDisplayed());

    }

    @Test
    public void Test04() {
        //6. Enter email address in input and click arrow button //6. Giriş alanına e-posta adresini girin ve ok düğmesine tıklayın
        //7. Verify success message 'You have been successfully subscribed!' is visible//7. Başarı mesajını doğrulayın 'Başarılı bir şekilde abone oldunuz!' görünür
     driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("salla@gmail.com", Keys.ENTER);
     Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert-success alert']")).isDisplayed());
    }














}
