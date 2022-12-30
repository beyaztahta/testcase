package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YoutubeAssertions {
     WebDriver driver;
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://youtube.com/");
    }

   @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    //1)Bir class oluşturun:YoutubeAssertions
    //2)https://www.youtube.com adresinegidin
    //3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleriyapin
    //○titleTest
    //○imageTest
    //=> Sayfa başlığının “YouTube” oldugunu testedin
    //=> YouTube resminin görüntülendiğini (isDisplayed()) testedin
    //○Search Box 'in erisilebilir oldugunu test edin(isEnabled())
    //○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    @Test
    public void test01(){
       String actualTitle=driver.getTitle();
       String expectedTitle="YouTube";
       Assert.assertTrue(actualTitle.contains(expectedTitle));
    }


    @Test
    public void test02() {
       WebElement actualPage= driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(actualPage.isDisplayed());

    }

    @Test
    public void test03() {
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void test04() {
        String actualTitle=driver.getTitle();
        String expectedTitle="youtube";
        Assert.assertFalse(actualTitle.contains(expectedTitle));

    }
}
