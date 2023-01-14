package testcases.Practice;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class GenelTekraraTesti extends TestBase {
    //Genel TekrarTesti

    @Test
    public void test01() {
        //1-amazongidin
        driver.get("https://www.amazon.com");

        //2Arama kutusunun solundaki dropdown menuyu handle edip listesini ekranayazdırın
        Select select = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
        List<WebElement> ddwnList = select.getOptions();
        for (WebElement ddwn : ddwnList) {
            System.out.println(ddwn.getText());
        }

        //3-dropdown menude 40 eleman olduğunudoğrulayın
        Assert.assertEquals(28, ddwnList.size());

        //1-dropdown menuden elektronik bölümüseçin
        select.selectByVisibleText("Electronics");

        //2-arama kutusuna iphone yazip aratin ve bulunan sonuç sayısınıyazdırın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone" + Keys.ENTER);

        String sonucSayisi[] = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().split(" ");
        System.out.println("sonucSayisi = " + sonucSayisi[3]);

        String sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println("sonucYazisi = " + sonucYazisi);

        //3-sonuc sayisi bildiren yazinin iphone icerdigini testedin
        Assert.assertTrue(sonucYazisi.contains("iphone"));

        //4-ikinci ürüne relative locater kullanarak tıklayin
        WebElement secondProduct = driver.findElement(By.xpath("//*[@data-index='2']"));
        waitFor(3);
        secondProduct.click();

        //5-ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String title = driver.getTitle();
        System.out.println("title = " + title);
        String fiyat = driver.findElement(By.xpath("(//*[@class='a-offscreen'])[1]")).getText();
        System.out.println("fiyat = " + fiyat);

        driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();


        //1-yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://amazon.com");

        //2-dropdown’dan bebek bölümünü secin
        Select select2 = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));

        select2.selectByVisibleText("Baby");

        //3-bebek puset aratıp bulundan sonuç sayısınıyazdırın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("baby puset" + Keys.ENTER);

        String sonucSayisi1[] = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText().split(" ");
        System.out.println("sonucSayisi = " + sonucSayisi1[2]);

        String sonucYazisi1 = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        System.out.println("sonucYazisi = " + sonucYazisi1);

        //4-sonuç yazsının puset içerdiğini testedin
        Assert.assertTrue(sonucYazisi1.contains("puset"));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("//*[@data-index='3']//img[@data-image-index='3']")).click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String title2 = driver.getTitle();
        System.out.println("title = " + title2);
        String fiyat2 = driver.findElement(By.xpath("(//*[@class='a-offscreen'])[1]")).getText();
        System.out.println("fiyat = " + fiyat2);

        driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();

        // Test4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarakdoğrulayın
        driver.findElement(By.xpath("//a[@href='/gp/cart/view.html?ref_=sw_gtc']")).click();
        String first = getWebElementWithXpath("(//*[@class='a-truncate-cut'])[5]").getText();
        System.out.println("first = " + first);
        String second = getWebElementWithXpath("(//*[@class='a-truncate-cut'])[6]").getText();
        System.out.println("second = " + second);

        Assert.assertTrue(title.contains(second));
        Assert.assertTrue(title2.contains(first));


    }


}
