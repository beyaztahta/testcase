package testcases.Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Test_08 extends TestBase {
    @Test
    public void test01() {

        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        String windowHandle1= driver.getWindowHandle();
        System.out.println(windowHandle1);

        //Alerts, Frame & Windows Butonuna click yap
        getWebElementWithXpath("(//*[@class='card mt-4 top-card'])[3]").click();

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        Assert.assertTrue(getWebElementWithXpath("//*[text()='Please select an item from left to start practice.']").isDisplayed());

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        getWebElementWithXpath("//span[normalize-space()='Browser Windows']").click();

        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTabButonu = getWebElementWithXpath("//button[@id='tabButton']");
        Assert.assertTrue(newTabButonu.isDisplayed());

        //New Tab butonuna click yap
        newTabButonu.click();

        Set<String> allWindowHandles = driver.getWindowHandles();//{windowHandle1, windowHandle2}
        System.out.println(allWindowHandles);
        for (String handle : allWindowHandles) {
            if (!handle.equals(windowHandle1)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String windowHandle2=driver.getWindowHandle();
        System.out.println(windowHandle2);

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula

         Assert.assertTrue(getWebElementWithXpath("//*[@id='sampleHeading']").isDisplayed());

        //İlk Tab'a geri dön
        driver.switchTo().window(windowHandle1);

        //New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(newTabButonu.isDisplayed());
    }

}
