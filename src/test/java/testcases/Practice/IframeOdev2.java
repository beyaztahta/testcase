package testcases.Practice;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import testcases.TestBase;

import java.util.List;

public class IframeOdev2 extends TestBase {
    @Test
    public void test01() {
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/


        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        driver.switchTo().frame(0);
        WebElement bear = driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        bear.click();

        // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement> allEmoojis = driver.findElements(By.xpath("//div[@id='nature']//div//img"));
        for (WebElement animalEmoojis : allEmoojis) {
            animalEmoojis.click();
        }

        // ana iframe'e geri dön
        driver.switchTo().defaultContent();

        //formu doldurun,(Formu istediğiniz metinlerle doldurun) // uygula butonuna tıklayın
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("mavi", Keys.TAB, "dunya", Keys.TAB, "hello", Keys.TAB, "word",
                Keys.TAB, "yesil", Keys.TAB, "deniz", Keys.TAB, "sarı", Keys.TAB, "kırmızı", Keys.TAB, "salla", Keys.TAB, "derya", Keys.TAB, "salla");

        driver.findElement(By.xpath("//button[@id='send']")).click();

    }


}
