package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_14 {
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
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
    }

    @Test
    public void Test02() {
        //4. Add products to cart-->  Sepete ürün ekle
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[3]")).click();

        //5. Click 'Cart' button --> 'Sepet' düğmesine tıklayın
        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();

        //6. Verify that cart page is displayed  -->Sepet sayfasının görüntülendiğini doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='cart_menu']")).isDisplayed());

        //7. Click Proceed To Checkout-->Ödeme İşlemine Devam Et'i tıklayın
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        //8. Click 'Register / Login' button-->
        driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();

        //9. Fill all details in Signup and create account-->Kayıttaki tüm ayrıntıları doldurun ve hesap oluşturun
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("tosbik",
                                                  Keys.TAB, "niloya123@gmail.com", Keys.ENTER);

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button-->'HESAP OLUŞTURULDU!'yu dogrulayın ve 'Devam Et' düğmesini tıklayın-


        //11. Verify ' Logged in as username' at top-->En üstte 'Kullanıcı adı olarak oturum açıldı'yı doğrulayın
        //12.Click 'Cart' button-->
        //13. Click 'Proceed To Checkout' button
        //14. Verify Address Details and Review Your Order-->Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        //15. Enter description in comment text area and click 'Place Order'-->Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //17. Click 'Pay and Confirm Order' button
        //18. Verify success message 'Your order has been placed successfully!'
        //19. Click 'Delete Account' button
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    }


}
