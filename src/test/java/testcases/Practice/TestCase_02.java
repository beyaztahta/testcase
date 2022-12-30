package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_02 {
    public static void main(String[] args) {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //2. Navigate to url "'http://automationexercise.com"'
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        System.out.println(driver.findElement(By.xpath("//div[@class='col-sm-4']")).isDisplayed() ? " The page appears" : "Page is not visible");

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        WebElement signupLogin = driver.findElement(By.xpath("//*[@href='/login']"));
        signupLogin.click();

        //5. 'Hesabınıza giriş yapın'ın görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed() ? " The page appears" : "Page is not visible");

        //6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("beyaz258@gmail.com", Keys.TAB, "2580");

        //7. 'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //8. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed() ? " The writing appears" : "Writing is not visible");

        //9. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

        //10. 'HESAP SİLİNDİ!' görünür

        System.out.println(driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']")).isDisplayed() ? " The writing appears" : "Writing is not visible");
        driver.close();
    }
}
