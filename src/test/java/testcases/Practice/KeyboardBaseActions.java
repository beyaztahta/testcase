package testcases.Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeyboardBaseActions extends TestBase {
    @Test
    public void test01() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement element=driver.findElement(By.xpath("//*[@class='dropdown hover']"));
        actions.moveToElement(element).perform();

        //Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[text()='Link 1'])[1]")).click();

        //Popup mesajini yazdirin
        Alert alert=driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());

        //Popup'i tamam diyerek kapatin
        alert.accept();

        //“Click and hold" kutusuna basili tutun
        actions.clickAndHold(driver.findElement(By.xpath("//*[@id='click-box']"))).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("text = " + driver.findElement(By.xpath("//div[@id='click-box']")).getText());

        //8- “Double click me" butonunu cift tiklayin
        doubleClick(driver.findElement(By.xpath("//*[@id='double-click']")));

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        String doubleClick=driver.findElement(By.xpath("//*[@id='double-click']")).getAttribute("class");
        Assert.assertTrue(doubleClick.equals("div-double-click double"));
    }

}
