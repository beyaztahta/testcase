package testcases.Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class TestCase_16 extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());

        //4. Click 'Signup / Login' button

        getWebElementWithXpath("//a[normalize-space()='Signup / Login']").click();

        //5. Fill email, password and click 'Login' button
        getWebElementWithXpath("//input[@data-qa='login-email']").sendKeys("aaa@b123öxzzss", Keys.TAB, "1234", Keys.ENTER);

        //6. Verify 'Logged in as username' at top

        Assert.assertTrue(getWebElementWithXpath("//li[10]//a[1]").isDisplayed());

        //7. Add products to cart
        getWebElementWithXpath("(//*[@class='btn btn-default add-to-cart'])[1]").click();
        getWebElementWithXpath("//button[@class='btn btn-success close-modal btn-block']").click();
        getWebElementWithXpath("(//*[@class='btn btn-default add-to-cart'])[3]").click();


        //8. Click 'Cart' button
        getWebElementWithXpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]").click();

        //9. Verify that cart page is displayed
        Assert.assertTrue(getWebElementWithXpath("//*[@id='cart_info_table']").isDisplayed());

        //10. Click Proceed To Checkout
        getWebElementWithXpath("//a[@class='btn btn-default check_out']").click();

        //11. Verify Address Details and Review Your Order
        Assert.assertTrue(getWebElementWithXpath("//*[text()='Address Details']").isDisplayed());

        String actualResult = getWebElementWithXpath("//*[@class='address_country_name']").getText();
        String expectedResult = "Canada";
        Assert.assertTrue(actualResult.contains(expectedResult));

        //12. Enter description in comment text area and click 'Place Order'
        getWebElementWithXpath("//textarea[@name='message']").sendKeys("my orders");
        getWebElementWithXpath("//a[@class='btn btn-default check_out']").click();

        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date        //14. Click 'Pay and Confirm Order' button
        getWebElementWithXpath("//input[@name='name_on_card']").sendKeys("nine", Keys.TAB, "6548792569874003", Keys.TAB, "655",
                Keys.TAB, "12", Keys.TAB, "2018", Keys.ENTER);

        //15. Verify success message 'Your order has been placed successfully!'

//        String actual = getWebElementWithXpath("//*[text()='Your order has been placed successfully!']").getText();
//        String expected = "Your order has been placed successfully!";
//        Assert.assertTrue(actual.contains(expected));
//

        //16. Click 'Delete Account' button
        getWebElementWithXpath("//a[normalize-space()='Delete Account']").click();

        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String actualrslt=getWebElementWithXpath("//b").getText();
        String expectedrslt="ACCOUNT DELETED!";
        Assert.assertEquals(expectedrslt, actualrslt);
    }

}
