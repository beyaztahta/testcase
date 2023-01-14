package testcases.Practice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;
public class LinkedInConnectAutomation {

    //Calistirmadan once her zaman kullandiginiz Chrome profilinde LinkedIn hesabiniza giris yapin ve Chrome'u kapatin.

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        String path = System.getProperty("user.home").concat("\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("user-data-dir=" + path);
        options.addArguments("profile-directory=Default");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }


    @Test
    public void test01() {
        //LinkedIn hesabinizda her calistiginda 8 kisiye Connect atar.
        driver.get("https://www.linkedin.com/mynetwork/");
        List<WebElement> btnList = driver.findElements(By.xpath("(//*[@class='ember-view discover-cohort-view--list-item'])[6]//button[starts-with(@aria-label,'Invite')]//span"));
        System.out.println(btnList.size());
        btnList.forEach(WebElement::click);
    }
}
   // LinkedIn hesabinizda her calistiginda 8 kisiye Connect atan kod. Practice dersinde sıkıntıdan yaptim. Boylece kısa surede 500+ Conncetions'a ulasabilirsiniz. Fazla calistirmayin sizi bloklamasin.
//Calistirmadan once her zaman kullandiginiz Chrome profilinde LinkedIn hesabiniza giris yapin ve ardindan Chrome'u kapatin.


