package testcases.Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;


import java.util.Set;

public class WindowHandleHomework extends TestBase {
    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        String windowHandle1 = driver.getWindowHandle();

        //Title in ‘Windows’ oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(expectedTitle, actualTitle);

        //Click here a tiklayin
        driver.findElement(By.linkText("Click Here")).click();

        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println(allWindows);
        for (String eachHandle : allWindows) {
            if (!eachHandle.equals(windowHandle1)) {
                driver.switchTo().window(eachHandle);
                break;
            }
        }
        String windowHandle2 = driver.getWindowHandle();
        System.out.println(windowHandle2);

        String expectedResult="New Window";
        String actualResult = driver.getTitle();
        Assert.assertEquals(expectedResult,actualResult);


    }


}
