package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test_05 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        // ~ click on Phones & PDAs
        driver.findElement(By.xpath("//a[normalize-space()='Phones & PDAs']")).click();

        // ~ get the brandName of phones
        List<String> brandNameOfPhones = getElements(driver, "div.caption>h4>a");
        System.out.println(brandNameOfPhones);

        // ~ click on add to button for all elements
        clickButton(driver);

        //~ click on black total added cart button
        clickAddToCartBtn(driver);

        //  ~ get the names of list from the cart
        List<String> nameOfList = getElements(driver, "tr>td.text-left>a");
        System.out.println(nameOfList);

        // ~ compare the names from displaying list and cart list
        System.out.println(nameOfList.equals(brandNameOfPhones) ? "PASSED" : "FAILED");

        driver.close();
    }


    public static List<String> getElements(WebDriver driver, String xpath) {
        List<WebElement> list = driver.findElements(By.cssSelector(xpath));
        List<String> listStr = new ArrayList<>();
        for (WebElement w : list) {
            listStr.add(w.getText());
        }
        Collections.sort(listStr);
        return listStr;
    }

    public static void clickButton(WebDriver driver) {
        List<WebElement> l = driver.findElements(By.xpath("//*[text()='Add to Cart']"));
        l.stream().forEach(WebElement::click);

    }

    public static void clickAddToCartBtn(WebDriver driver) {
        driver.findElement(By.xpath("(//*[@type='button'])[5]")).click();

    }


}
