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

public class TestCase_08 {
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
        //3. Verify that home page is visible successfully---Ana sayfanın başarıyla göründüğünü doğrulayın
        //4. Click on 'Products' button. 'Ürünler' düğmesine tıklayın
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        driver.get("http://automationexercise.com/products");
    }



    @Test
    public void Test02() {

        //5. Verify user is navigated to ALL PRODUCTS page successfully. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
       Assert.assertTrue(driver.findElement(By.xpath("//*[@class='title text-center']")).isEnabled());

    }

    @Test
    public void Test03() {
        //6. The products list is visible. Ürün listesi görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='col-sm-9 padding-right']")).isDisplayed());
    }

    @Test
    public void Test04() {
        //7. Click on 'View Product' of first product. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();
        driver.get("http://automationexercise.com/product_details/1");

        // 8. User is landed to product detail page. Kullanıcı ürün detay sayfasına yönlendirildi
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='product-information']")).isEnabled());

    }

    @Test
    public void Test05() {
        //9. Verify that detail  is visible: product name, category, price, availability, condition, brand
        // Ürün adı, kategorisi, fiyatı, bulunabilirliği, durumu, markası gibi ayrıntıların göründüğünü doğrulayın.

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='product-information']")).isDisplayed());
    }
























}
