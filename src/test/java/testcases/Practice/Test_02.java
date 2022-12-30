package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.“https://www.saucedemo.com”Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2.Username kutusuna “standard_user”yazdirin
        WebElement searchBox=driver.findElement(By.xpath("//*[@id='user-name']"));
        searchBox.sendKeys("standard_user");
        Thread.sleep(3000);

        //3.Password kutusuna “secret_sauce”yazdirin
        WebElement passwordBox=driver.findElement(By.xpath("//*[@id='password']"));
        passwordBox.sendKeys("secret_sauce");
    /*
   2 ve ucuncu sorunun tek bir cevap halinde yazılması:
   driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user", Keys.TAB, "secret_sauce", Keys.TAB, Keys.ENTER);
   */
        Thread.sleep(3000);
        //4.Login tusuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        String basariliGiris=driver.findElement(By.xpath("(//div[@class='header_secondary_container'])//span")).getText();

        if (basariliGiris.equalsIgnoreCase("Products")){
            System.out.println("Basarili giris testi PASS");
        }else {
            System.out.println("Basarili giris testi FAİL");
        }

        //5.Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        Thread.sleep(3000);
        WebElement urunAdıKaydı=driver.findElement(By.xpath("(//*[@class='inventory_item_name'])[1]"));
        String productName=urunAdıKaydı.getText();
        urunAdıKaydı.click();

        //6.Add to Cart butonuna basin

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();

        //7.Alisveris sepetine tiklayin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();

        //8.Sectiginiz urunun basarili olarak sepete eklendigini control edin
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText().equals(productName) ?
                "test passed" : "test failed");


        //9.Sayfayikapatin
        driver.close();

        /*

        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        if (driver.getTitle().equalsIgnoreCase("Swag Labs")){
            System.out.println("Title Test i PASS");
        }else {
            System.out.println("Title Test i FAIL");
        }
        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        String basariliGiris=driver.findElement(By.xpath("(//div[@class='header_secondary_container'])//span")).getText();

        if (basariliGiris.equalsIgnoreCase("Products")){
            System.out.println("Basarili giris testi PASS");
        }else {
            System.out.println("Basarili giris testi FAİL");
        }
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        ilkUrunText=driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]")).getText();
        driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]")).click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();
        if (driver.getCurrentUrl().contains("cart")){
            System.out.println("Sepet Page Goruntuleme Testi PASS");
        }else {
            System.out.println("Sepet Page Goruntuleme Testi FAIL");
        }
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String sepetKontrol= driver.findElement(By.id("item_4_title_link")).getText();
        if (sepetKontrol.equalsIgnoreCase(ilkUrunText)){
            System.out.println("İlk ürün sepette TEST PASS");
        }else {
            System.out.println("İlk ürün sepette TEST FAİLED");
        }
        //9. Sayfayi kapatin
        driver.quit();
         */
    }
}
