package testcases.Practice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Faker01 extends TestBase {
    //Faker Kutuphanesi HOMEWORK
    //Faker class’i testlerimizi yaparken ihtiyac duydugumuz isim, soyisim, adres vb bilgiler icin fake
    //degerler uretmemize imkan tanir.
    //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.

    @Test
    public void faker01() {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        getWebElementWithXpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']").click();

        //“firstName” giris kutusuna bir isim yazin
        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email=faker.internet().emailAddress();
        String password=faker.internet().password();

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName, Keys.TAB, lastName, Keys.TAB, email);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='reg_email_confirmation__']")));
        emailBox.sendKeys(email, Keys.TAB, password);


        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='day']")),"10");
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='month']")),"May");
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")),"1988");

        //Cinsiyeti secin
        WebElement seciliBox=getWebElementWithXpath("//*[text()='Kadın']");
        seciliBox.click();

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(seciliBox.isSelected());
        Assert.assertFalse(getWebElementWithXpath("//input[@id='u_t_5_96']").isSelected());
        Assert.assertTrue(getWebElementWithXpath("//input[@id='u_t_6_l0']").isSelected());

    }

}
