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

public class TestCase_05 {
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


    //3. Ana sayfanın başarıyla göründüğünü doğrulayın-Verify that home page is visible successfully

    @Test
    public void Test01() {

        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
    }


    //4. 'Kaydol / Giriş Yap' düğmesine tıklayın- Click on 'Signup / Login' button
    //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür-Verify 'New User Signup!' is visible

    @Test
    public void Test02() {

        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed());
    }

    //6. Adı ve önceden kayıtlı e-posta adresini girin-Enter name and already registered email address
    //7. 'Kaydol' düğmesini tıklayın-Click 'Signup' button
    //8. 'E-posta Adresi zaten mevcut!' hatasını doğrulayın. görünür-Verify error 'Email Address already exist!' is visible
    @Test
    public void Test03() {

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("asas", Keys.TAB, "yesil@gmail.com", Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']")).isDisplayed());
    }


}
