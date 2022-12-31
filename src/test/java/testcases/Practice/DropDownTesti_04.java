package testcases.Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testcases.TestBase;


public class DropDownTesti_04 extends TestBase {

    @Test
    public void test01() {
        //1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // 2-Dropdown Example menüsünün görünür olduğunu doğrulayın.

        WebElement select = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));

        Assert.assertTrue(select.isDisplayed());

        //3-Option3 ü seçin.
        WebElement option3 = selectFromDropdown(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")), "Option 3");
        System.out.println(option3.getText());

//        Select option3 = new Select(select);
//        option3.selectByValue("option3");



        //4-Option3 ün seçili olduğunu doğrulayın.
        Assert.assertTrue(option3.isSelected());
    }


}
