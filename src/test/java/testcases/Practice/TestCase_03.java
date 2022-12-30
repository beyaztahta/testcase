package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_03 {
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

    @AfterClass
    public static void afterClass() {
        driver.close();
    }
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
    //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
    //6. Yanlış e-posta adresi ve şifre girin
    //7. 'Giriş' düğmesine tıklayın
    //8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür


    @Test
    public void anaSayfaTesti() {
        WebElement actualAnaSayfa = driver.findElement(By.xpath("//*[@id='slider']"));
        Assert.assertTrue(actualAnaSayfa.isDisplayed());
    }

    @Test
    public void hesabaGirisTesti() {
        WebElement giris = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        giris.click();
        WebElement actualHesapGirisi = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
        Assert.assertTrue(actualHesapGirisi.isDisplayed());
    }

    @Test
    public void yanlısEmailVeSifreTesti() {

        WebElement actualYanlısGiris= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        actualYanlısGiris.sendKeys("page_127*@gmail.com", Keys.TAB,"page_569");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        WebElement actualHataMesajı= driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']"));
       Assert.assertTrue(actualHataMesajı.isDisplayed());

    }
}
