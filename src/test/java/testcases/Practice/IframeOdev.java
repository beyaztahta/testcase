package testcases.Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testcases.TestBase;


import java.util.List;

public class IframeOdev extends TestBase {
    //Bir class olusturun: IframeOdev

    @Test
    public void test01() throws InterruptedException {

        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe ");

        //sayfadaki toplam iframe sayısını bulunuz.

        List<WebElement> list=driver.findElements(By.tagName("iframe"));
        System.out.println("iframe sayisi = " + list.size());

        //Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
        String actualPageTitle=driver.findElement(By.xpath("//h3")).getText();
        String expectedPageTitle="Editor";
        Assert.assertTrue(actualPageTitle.contains(expectedPageTitle));

        //Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//p")).clear();

        //Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
        driver.findElement(By.xpath("//p")).sendKeys(" I am in iframe");
        Thread.sleep(3000);

        //Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        String actualResult=driver.findElement(By.xpath("//*[@style='text-align: center;']")).getText();
        String expectedResult="Elemental Selenium";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
