package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDownTesti_02 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.amazon.com/");
    }

    @Test
    public void Test01() {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu testedin
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select search = new Select(searchBox);
        List<WebElement> list = search.getOptions();
        Assert.assertEquals(45 ,list.size());
    }

    @Test
    public void Test02() {

         //1.Kategori menusunden Books secenegini secin
        //2.Arama kutusuna Java yazin ve aratin

        WebElement index = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select idx = new Select(index);
        idx.selectByVisibleText("Books");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        //3.Bulunan sonuc sayisini yazdirin
        String bulunanSonucSayisi= driver.findElement(By.xpath("//div[@class='sg-col-14-of-20 sg-col s-breadcrumb sg-col-10-of-16 sg-col-6-of-12']")).getText();
        System.out.println(bulunanSonucSayisi);

        //4.Sonucun Java kelimesini icerdigini testedin
        Assert.assertTrue(bulunanSonucSayisi.contains("Java"));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
