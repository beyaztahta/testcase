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

public class DropDownTesti_03 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com/ Adresinegidin
        driver.get("http://zero.webappsecurity.com/");
    }

    @Test
    public void Test01() {
        //2.Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3.Login kutusuna “username”yazin
        //4.Password kutusuna “password.”yazin
        //5.Sign in tusunabasin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username", Keys.TAB, "password",Keys.ENTER);

        driver.get("http://zero.webappsecurity.com/");

        //6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[normalize-space()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //7.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[normalize-space()='Purchase Foreign Currency']")).click();

        //8.“Currency” drop down menusunden Eurozone’usecin
        WebElement currency = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select currencyDropDown = new Select(currency);
        currencyDropDown.selectByVisibleText("Eurozone (euro)");

        //9.“amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("12");

        //10.“US Dollars” in secilmedigini test edin
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='pc_inDollars_true']")).isSelected());

        //11.“Selected currency” butonunu secin
        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']")).click();

        //12.“Calculate Costs” butonuna basin sonra “purchase” butonunabasin
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();

        //13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontroledin.
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='alert_content']")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.close();
    }



}
