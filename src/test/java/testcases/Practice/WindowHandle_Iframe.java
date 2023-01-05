package testcases.Practice;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;


public class WindowHandle_Iframe extends TestBase {
    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        String windowHandle1= driver.getWindowHandle();

        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe=getWebElementWithXpath("//iframe[@id='mce_0_ifr']");
        driver.switchTo().frame(iframe);
        WebElement text= getWebElementWithXpath("//p");
        text.clear();
        text.sendKeys("Techproeducation");

        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();

        WebElement elementalSeleniumLinki=getWebElementWithXpath("//*[text()='Elemental Selenium']");
        Assert.assertTrue(elementalSeleniumLinki.isDisplayed());

        // Elemental Selenium linkine tıklayın
        elementalSeleniumLinki.click();


        // Açılan sayfada sayfa başlığını yazdırınız
        List<String>allWindows=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindows.get(1));

        String windowHandle2 = driver.getWindowHandle();
        System.out.println(windowHandle2);

        String title=driver.getTitle();
        System.out.println("Second window the title = " + title);


        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement sourceLabsLinki=getWebElementWithXpath("//a[@class='link']");
        Assert.assertTrue(sourceLabsLinki.isDisplayed());

        // Source labs linkine tıklayın
        sourceLabsLinki.click();

        // Açılan sayfada sayfa başlığını yazdırınız
       List<String>allWindows2=new ArrayList<>(driver.getWindowHandles());
       driver.switchTo().window(allWindows2.get(2));

        String windowHandle3 = driver.getWindowHandle();
        System.out.println(windowHandle3);

        String title1=driver.getTitle();
        System.out.println("Third window the title = " + title1);


        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        //driver.switchTo().window(windowHandle1)
        driver.switchTo().window(allWindows2.get(0));

        String url = driver.getCurrentUrl();
        System.out.println("first page the url = " + url);


        // ilk sekmeyi kapatalım
        driver.close();

    }

}


