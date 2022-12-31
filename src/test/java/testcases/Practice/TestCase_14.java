package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testcases.TestBase;

import java.time.Duration;

public class TestCase_14 extends TestBase {


    @Test
    public void Test01() {

        driver.get("http://automationexercise.com");

        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());

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
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("tosbik", Keys.TAB, "red1235@gmail.com", Keys.ENTER);

        getWebElementWithXpath("//input[@id='id_gender1']").click();
        getWebElementWithXpath("//input[@id='password']").sendKeys("1234");
        selectFromDropdown(getWebElementWithXpath("//select[@id='days']"), "15");
        selectFromDropdown(getWebElementWithXpath("//select[@id='months']"), "January");
        selectFromDropdown(getWebElementWithXpath("//select[@id='years']"), "1995");
        getWebElementWithXpath("//input[@id='first_name']").sendKeys("Esadasa", Keys.TAB, "xzccas", Keys.TAB, "xzccas", Keys.TAB, "xzasqw", Keys.TAB, Keys.TAB);
        selectFromDropdown(getWebElementWithXpath("//select[@id='country']"), "Canada");
        getWebElementWithXpath("//input[@id='state']").sendKeys("BC", Keys.TAB, "Ankara", Keys.TAB, "V3S 4Z6", Keys.TAB, "464764456");
        getWebElementWithXpath("//button[normalize-space()='Create Account']").click();

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button-->'HESAP OLUŞTURULDU!'yu dogrulayın ve 'Devam Et' düğmesini tıklayın-
        Assert.assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).isDisplayed());
        getWebElementWithXpath("//a[@class='btn btn-primary']").click();

        //11. Verify ' Logged in as username' at top-->En üstte 'Kullanıcı adı olarak oturum açıldı'yı doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed());

        //12.Click 'Cart' button-->
        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();

        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        //14. Verify Address Details and Review Your Order-->Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        String actualResult = driver.findElement(By.xpath("//*[@class='address_country_name']")).getText();
        String expectedResult = "Canada";
        Assert.assertEquals(expectedResult, actualResult);

        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']")).isDisplayed());

        //15. Enter description in comment text area and click 'Place Order'-->Açıklama metin alanına açıklamayı girin ve 'Sipariş Ver'i tıklayın
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("first order");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date  //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("niloya", Keys.TAB, "6548792569874003", Keys.TAB, "655",
                Keys.TAB, "12", Keys.TAB, "2018", Keys.ENTER);

        //18. Verify success message 'Your order has been placed successfully!'
     //  Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Your order has been placed successfully!')]")).isDisplayed());

        //19. Click 'Delete Account' button
        getWebElementWithXpath("//a[normalize-space()='Delete Account']").click();

        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(getWebElementWithXpath("//b[normalize-space()='Account Deleted!']").isDisplayed());
        getWebElementWithXpath("//a[@class='btn btn-primary']").click();

    }


}
