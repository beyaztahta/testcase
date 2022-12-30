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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDownTesti_01 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void Test01() {
        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        WebElement index = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select idxdropDown = new Select(index);
        idxdropDown.selectByIndex(1);
        System.out.println(idxdropDown.getFirstSelectedOption().getText());

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        idxdropDown.selectByValue("2");
        System.out.println(idxdropDown.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        idxdropDown.selectByVisibleText("Option 1");
        System.out.println(idxdropDown.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın

        List<WebElement> list = idxdropDown.getOptions();
        for (WebElement w : list) {
            System.out.println(w.getText());
        }

        //5. Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse False yazdırın.

        Assert.assertEquals(4,list.size());
    }


    @After
    public void tearDown() {
        driver.close();
    }

}
