package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        System.out.println(driver.findElement(By.xpath("//div[@class='col-sm-4']")).isDisplayed() ? " The page appears" : "Page is not visible");

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın!
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed() ? " The writing appears" : "Writing is not visible");

        //6. Adı ve e-posta adresini girin -//7. 'Kaydol' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("goksel", Keys.TAB, "cali12360@gmail.com", Keys.TAB, Keys.ENTER);


        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın-//9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
        System.out.println(driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed() ? " The writing appears" : "Writing is not visible");

        driver.findElement(By.xpath("//*[@id='id_gender2']")).click();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("2580_elif", Keys.TAB, "3", Keys.TAB,
                "November", Keys.TAB, "1991", Keys.TAB, Keys.SPACE, Keys.TAB, Keys.SPACE);
        driver.findElement(By.xpath("//*[@data-qa='first_name']")).sendKeys("goksel", Keys.TAB,
                "sarı", Keys.TAB, "samsung", Keys.TAB, "123.st.", Keys.TAB, "4586.st", Keys.TAB, "United States", Keys.TAB, "Belgium", Keys.TAB,
                "belgium", Keys.TAB, "02365", Keys.TAB, "922564125", Keys.TAB, Keys.SPACE);


        // driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();


        //14. 'HESAP OLUŞTURULDU!' görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed() ? " The writing appears" : "Writing is not visible");

        //15. 'Devam Et' düğmesini tıklayın

        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        driver.navigate().refresh();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

        //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        System.out.println(driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed() ? " The writing appears" : "Writing is not visible");

        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın
        System.out.println(driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']")).isDisplayed() ? " The writing appears" : "Writing is not visible");

        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        driver.close();

    }
}