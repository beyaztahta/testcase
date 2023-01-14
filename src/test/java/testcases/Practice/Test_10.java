package testcases.Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Test_10 extends TestBase {

    @Test
    public void test01() {
        //https://www.way2automation.com/angularjs-protractor/webtables/
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");

        //tüm E-mail leri yazdırın
        List<WebElement>allEmails=driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tr//td[7]"));
        for (WebElement email : allEmails) {
            System.out.println("email.getText() = " + email.getText());
        }

        //Tüm E-maillerin "@" işareti içerdiğini doğrulayin
        allEmails.stream().forEach(email-> Assert.assertTrue(email.getText().contains("@")));

//        for (WebElement email : allEmails) {
//            Assert.assertTrue(email.getText().contains("@"));
//        }

    }
}
