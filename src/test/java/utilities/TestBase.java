package utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestBase {

   protected static WebDriver driver;

    @Before
    public void setUp() {
        //    1. Launch browser
        //    2. Navigate to url 'http://automationexercise.com'
        ChromeOptions options = new ChromeOptions();
        //https://chrome//version/
        String path = "C:\\Users\\hp\\AppData\\Local\\Google\\Chrome\\User Data";
        options.addArguments("user-data-dir=" + path);
        options.addArguments("profile-directory=Profile 3");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws InterruptedException {
        //Her seferinde cikis yapmadan once gecmisi silmemiz gerekiyor.
        driver.manage().deleteAllCookies();
        driver.get("chrome://settings/clearBrowserData");
        driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
        driver.quit();
    }


    public WebElement selectFromDropdown(WebElement dropdown, String myOption) {
        Select option = new Select(dropdown);
        option.selectByVisibleText(myOption);
        return option.getFirstSelectedOption();
    }

    public WebElement getWebElementWithXpath(String xpath) {

      return  driver.findElement(By.xpath(xpath));

    }

}
