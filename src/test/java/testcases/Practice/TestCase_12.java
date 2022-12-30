package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_12 {
    // çıkan reklam için ;  driver.navigate().refresh();
    //çıkan uyarıyı kapatmak için ;  driver.switchTo().alert().accept();
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }

    @Test
    public void Test01() {
        //3. Verify that home page is visible successfully --> Ana sayfanın başarıyla göründüğünü doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
    }

    @Test
    public void Test02() {
        //4. Click 'Products' button ('Ürünler' düğmesini tıklayın)
        driver.findElement(By.xpath("//a[@href='/products']")).click();
         driver.navigate().refresh();
        //5. Hover over first product and click 'Add to cart'(İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın)
        driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]")).click();

        //6. Click 'Continue Shopping' button           //6. 'Alışverişe Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        //7. Hover over second product and click 'Add to cart' //7. Fareyle ikinci ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[2]//div[1]//a[1]")).click();


        //8. Click 'View Cart' button  //8. 'Sepeti Görüntüle' düğmesini tıklayın
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();

        //9. Verify both products are added to Cart   //9. Her iki ürünün de Sepete eklendiğini doğrulayın
        Assert.assertEquals("Blue Top",driver.findElement(By.xpath("//a[normalize-space()='Blue Top']")).getText());
        Assert.assertEquals("Men Tshirt",driver.findElement(By.xpath("//a[normalize-space()='Men Tshirt']")).getText());

        //10. Verify their prices, quantity and total price  //10. Fiyatlarını, miktarlarını ve toplam fiyatlarını doğrulayın
        Assert.assertEquals("Rs. 500", driver.findElement(By.xpath("//td[@class='cart_price']//p[contains(text(),'Rs. 500')]")).getText());
        Assert.assertEquals("Rs. 400", driver.findElement(By.xpath("//td[@class='cart_price']//p[contains(text(),'Rs. 400')]")).getText());
        Assert.assertEquals("1", driver.findElement(By.xpath("//tr[@id='product-1']//button[@class='disabled'][normalize-space()='1']")).getText());
        Assert.assertEquals("1", driver.findElement(By.xpath("//tr[@id='product-2']//button[@class='disabled'][normalize-space()='1']")).getText());
        Assert.assertEquals("Rs. 500", driver.findElement(By.xpath("//p[@class='cart_total_price'][normalize-space()='Rs. 500']")).getText());
        Assert.assertEquals("Rs. 400", driver.findElement(By.xpath("//p[@class='cart_total_price'][normalize-space()='Rs. 400']")).getText());

    }

    @After
    public void tearDown() {
      driver.close();
    }
}
