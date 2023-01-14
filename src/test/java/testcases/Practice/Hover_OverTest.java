package testcases.Practice;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Hover_OverTest extends TestBase {
    @Test
    public void test01() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement box=getWebElementWithXpath("//*[@class='dropdown hover']");
        actions.moveToElement(box).perform();

        //3. "Link 1" e tiklayin
        getWebElementWithXpath("//div[@class='dropdown hover']//a[@class='list-alert'][normalize-space()='Link 1']").click();

        //4. Popup mesajini yazdirin
        String alertText=driver.switchTo().alert().getText();
        System.out.println("alertText = " + alertText);

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement element=getWebElementWithXpath("//*[@id='click-box']");
        actions.clickAndHold(element).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("getText() = " + getWebElementWithXpath("//*[@id='click-box']").getText());

        //8. "Double click me" butonunu cift tiklayin
        actions.doubleClick(getWebElementWithXpath("//h2[normalize-space()='Double Click Me!']")).perform();
    }

    @Test
    public void test02() {
        /*
   #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
  #Ülkeye göre başkentleri doldurun

 */
    driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
    waitFor(2);
    dragAndDropActions(getWebElementWithXpath("//*[@id='box4']"),getWebElementWithXpath("//*[@id='box104']"));
    waitFor(2);
    dragAndDropActions(getWebElementWithXpath("//*[@id='box7']"),getWebElementWithXpath("//*[@id='box107']"));
    waitFor(2);
    dragAndDropActions(getWebElementWithXpath("//*[@id='box1']"),getWebElementWithXpath("//*[@id='box101']"));
    waitFor(2);
    dragAndDropActions(getWebElementWithXpath("//*[@id='box2']"),getWebElementWithXpath("//*[@id='box102']"));
    waitFor(2);
    dragAndDropActions(getWebElementWithXpath("//*[@id='box3']"),getWebElementWithXpath("//*[@id='box103']"));
    waitFor(2);
    dragAndDropActions(getWebElementWithXpath("//*[@id='box5']"),getWebElementWithXpath("//*[@id='box105']"));
    waitFor(2);
    dragAndDropActions(getWebElementWithXpath("//*[@id='box6']"),getWebElementWithXpath("//*[@id='box106']"));

    }




}
