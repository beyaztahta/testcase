package testcases.Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeyboardActions2 extends TestBase {

//    Bir Class olusturalim KeyboardActions2

    @Test
    public void test01() {
//    https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

//    video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        // actions.scrollByAmount(0,1000).perform();//pixel olarak indiriyoruz.

        scrollDownActions();
        waitFor(2);

        scrollDownActions();
        waitFor(2);

//    videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@width='560']")));
        waitFor(3);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
        waitFor(3);

//    videoyu calistirdiginizi test edin
        String element = driver.findElement(By.xpath("//*[@id='movie_player']")).getAttribute("class");
        Assert.assertTrue(element.contains("playing"));

    }


}
