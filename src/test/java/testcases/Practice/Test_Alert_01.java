package testcases.Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Test_Alert_01 extends TestBase {
    @Test
    public void test01() {
        // go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("//a[normalize-space()='Alert with OK']")).click();

        //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
        //    accept Alert(I am an alert box!) and print alert on console

        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        //    cancel Alert  (Press a Button !)
        driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        alert.dismiss();
        System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());

        // click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        // "Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        //        //    and then sendKeys 'TechProEducation' (Please enter your name)
        //
        driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        alert.sendKeys("Elif");
        alert.accept();

        String actualResult = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        System.out.println(actualResult);
        Assert.assertTrue(actualResult.contains("Elif"));


        //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
        //Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
        //finally print on console this mesaaje "Hello TechproEducation How are you today"
    }
}
