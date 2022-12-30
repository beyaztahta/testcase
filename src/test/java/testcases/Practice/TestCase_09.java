package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TestCase_09 {
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
        //4. Click on 'Products' button//4. 'Ürünler' düğmesine tıklayın
       //5. Verify user is navigated to ALL PRODUCTS page successfully//5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        driver.get("http://automationexercise.com/products");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='title text-center']")).isEnabled());
    }

    @Test
    public void Test03() {
        //6. Enter product name in search input and click search button//6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
         driver.findElement(By.xpath("//*[@id='search_product']")).sendKeys("tops");
         driver.findElement(By.xpath("//*[@id='submit_search']")).click();

        //7. Verify 'SEARCHED PRODUCTS' is visible //7. "ARANAN ÜRÜNLER"in görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='productinfo text-center']")).isDisplayed());

    }

    @Test
    public void Test04() {
        //8. Verify all the products related to search are visible //8. Arama ile ilgili tüm ürünlerin görünür olduğunu doğrulayın

       List<WebElement>list=driver.findElements(By.xpath("//*[@class='product-image-wrapper']"));
       Assert.assertEquals(13, list.size());

    }
}
