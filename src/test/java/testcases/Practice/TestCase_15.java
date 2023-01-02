package testcases.Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase_15 extends TestBase {
    @Test
    public void tes01() {
        //2. Navigate to url 'http://automationexercise.com
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logo = getWebElementWithXpath("//img[@alt='Website for automation practice']");
        Assert.assertTrue(logo.isDisplayed());

        //4. Click 'Signup / Login' button
        getWebElementWithXpath("//a[normalize-space()='Signup / Login']").click();

        //5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("tosbik", Keys.TAB, "red999@gmail.com", Keys.ENTER);

        getWebElementWithXpath("//input[@id='id_gender1']").click();
        getWebElementWithXpath("//input[@id='password']").sendKeys("1234");
        selectFromDropdown(getWebElementWithXpath("//select[@id='days']"), "3");
        selectFromDropdown(getWebElementWithXpath("//select[@id='months']"), "November");
        selectFromDropdown(getWebElementWithXpath("//select[@id='years']"), "1991");
        getWebElementWithXpath("//input[@id='first_name']").sendKeys("Esadasa", Keys.TAB, "xzccas", Keys.TAB, "xzccas", Keys.TAB, "xzasqw", Keys.TAB, Keys.TAB);
        selectFromDropdown(getWebElementWithXpath("//select[@id='country']"), "Canada");
        getWebElementWithXpath("//input[@id='state']").sendKeys("BC", Keys.TAB, "Ankara", Keys.TAB, "V3S 4Z6", Keys.TAB, "464764456");
        getWebElementWithXpath("//button[normalize-space()='Create Account']").click();

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        String actual = getWebElementWithXpath("//b").getText();
        String expected = "ACCOUNT CREATED!";
        Assert.assertEquals(expected, actual);

        getWebElementWithXpath("//a[@class='btn btn-primary']").click();

        //7. Verify ' Logged in as username' at top
        Assert.assertTrue(getWebElementWithXpath("//li[10]//a[1]").isDisplayed());

        //8. Add products to cart
        getWebElementWithXpath("(//*[@class='btn btn-default add-to-cart'])[1]").click();
        getWebElementWithXpath("//button[@class='btn btn-success close-modal btn-block']").click();
        getWebElementWithXpath("(//*[@class='btn btn-default add-to-cart'])[3]").click();

        //9. Click 'Cart' button
        getWebElementWithXpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]").click();

        //10. Verify that cart page is displayed
        Assert.assertTrue(getWebElementWithXpath("//*[@id='cart_info_table']").isDisplayed());

        //11. Click Proceed To Checkout
        getWebElementWithXpath("//a[@class='btn btn-default check_out']").click();

        //12. Verify Address Details and Review Your Order
        Assert.assertTrue(getWebElementWithXpath("//*[text()='Address Details']").isDisplayed());

        String actualResult = getWebElementWithXpath("//*[@class='address_country_name']").getText();
        String expectedResult = "Canada";
        Assert.assertTrue(actualResult.contains(expectedResult));

        //13. Enter description in comment text area and click 'Place Order'
        getWebElementWithXpath("//textarea[@name='message']").sendKeys("my orders");
        getWebElementWithXpath("//a[@class='btn btn-default check_out']").click();

        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date //15. Click 'Pay and Confirm Order' button
        getWebElementWithXpath("//input[@name='name_on_card']").sendKeys("nine", Keys.TAB, "6548792569874003", Keys.TAB, "655",
                Keys.TAB, "12", Keys.TAB, "2018", Keys.ENTER);


        //16. Verify success message 'Your order has been placed successfully!'
//        String actualText=getWebElementWithXpath("//div[contains(text(),'Your order has been placed successfully!')]").getText();
//        String expectedText="Your order has been placed successfully!";
//        Assert.assertTrue(actualText.contains(expectedText));
        //  Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Your order has been placed successfully!')]")).isDisplayed());


        //17. Click 'Delete Account' button
        getWebElementWithXpath("//a[normalize-space()='Delete Account']").click();

        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(getWebElementWithXpath("//b[normalize-space()='Account Deleted!']").isDisplayed());
        getWebElementWithXpath("//a[@class='btn btn-primary']").click();
    }

}
