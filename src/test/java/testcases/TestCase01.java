package testcases;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TestCase01 extends TestBase {

    static String title;

    @Test
    public void test01() {
        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed());
    }

    @Test
    public void test02() {
        // 4. Click 'View Product' for any product on home page
        driver.findElement(By.xpath("//div[6]//div[1]//div[2]//ul[1]//li[1]//a[1]")).click();
        // 5. Verify product detail is opened
        WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Winter Top']"));
        title = element.getText();
        Assert.assertTrue(element.isDisplayed());
    }

    @Test
    public void test03() {
        driver.findElement(By.xpath("//div[6]//div[1]//div[2]//ul[1]//li[1]//a[1]")).click();
        // 6. Increase quantity to 4, 7. Click 'Add to cart' button,
        driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys(Keys.DELETE,"4", Keys.TAB, Keys.ENTER);
        // 8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
        // 9. Verify that product is displayed in cart page with exact quantity
        Assert.assertEquals(title, driver.findElement(By.xpath("//a[normalize-space()='Winter Top']")).getText());
        Assert.assertEquals("4", driver.findElement(By.xpath("//button[@class='disabled']")).getText());
    }
}
