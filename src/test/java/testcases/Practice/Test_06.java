package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_06 {
    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //* Given kullanici "https://editor.datatables.net/" sayfasina gider

        driver.get("https://editor.datatables.net/");
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
    }

    @Test
    public void Test01() {
        //    Then new butonuna basar
        driver.findElement(By.xpath("//span[normalize-space()='New']")).click();
        //    And editor firstname kutusuna "<firstName>" bilgileri girer
        //    And editor lastname kutusuna "<lastName>" bilgileri girer
        //    And editor position kutusuna "<position>" bilgileri girer
        //    And editor office kutusuna "<office>" bilgileri girer
        //    And editor extension kutusuna "<extension>" bilgileri girer
        //    And editor startdate kutusuna "<startDate>" bilgileri girer
        //    And editor salary kutusuna "<salary>" bilgileri girer
        //    When Create tusuna basar


        driver.findElement(By.xpath("//input[@id='DTE_Field_first_name']")).sendKeys("azize", Keys.TAB,"hıckıdık",
                Keys.TAB,"azize hıckıdık",Keys.TAB,"company",Keys.TAB,"mtv",Keys.TAB,"2022-12-22");
        driver.findElement(By.xpath("//input[@id='DTE_Field_salary']")).sendKeys("10000000");
        driver.findElement(By.xpath("//button[@class='btn']")).click();

        //    Then Kullanıcının eklendiğini doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='azize hıckıdık']")).isDisplayed());

    }

    @Test
    public void Test02() {
        //And Eklediği kullanıcı kaydını siler
        //Then Kullanıcinin silindiğini doğrular.
        driver.findElement(By.xpath("//span[normalize-space()='Delete']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='azize hıckıdık']")).isDisplayed());
    }


}
