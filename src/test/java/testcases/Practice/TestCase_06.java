package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class TestCase_06 {
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
    //3. Verify that home page is visible successfully//3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. Click on 'Contact Us' button //4. 'Bize Ulaşın' düğmesine tıklayın

    @Test
    public void Test01() {

        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
        driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();

    }

    //5. Verify 'GET IN TOUCH' is visible//5. "İLETİŞİME GEÇİN" ifadesinin görünür olduğunu doğrulayın
    @Test
    public void Test02() {
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']")).isDisplayed());
    }

    //6. Enter name, email, subject and message //6. Adı, e-postayı, konuyu ve mesajı girin
    //7. Upload file//7. Dosya yükleyin
    //8. Click 'Submit' button//8. 'Gönder' düğmesini tıklayın
    //9. Click OK button//9. Tamam düğmesine tıklayın
    //10. Verify success message 'Success! Your details have been submitted successfully.' is visible

    @Test
    public void test03() {
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("asas");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("salla@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("konu");
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@name='upload_file']")).sendKeys("C:\\Users\\hp\\Desktop");
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertTrue( driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed());

    }

    //11. Click 'Home' button and verify that landed to home page successfully//'Ana Sayfa' düğmesine tıklayın ve ana sayfaya başarıyla geldiğini doğrulayın


    @Test
    public void test04() {

        driver.findElement(By.xpath("//span[normalize-space()='Home']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
    }

}
