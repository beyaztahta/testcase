package testcases.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class MesajYagdırrr extends TestBase {

    public void mesajYagdir() {
        //rehberinizdeki kayitli isim
        String isim = "Canım";
        String gondermekIstediginizMesaj = "hoooouuup";
        String gondermekIstediginizMesaj2 = "hayydaaaaa :)";
        int kacTaneMesajAtmakIstiyorsunuz = 100;


        driver.get("https://web.whatsapp.com/");
        driver.findElement(By.xpath("//span[@data-testid='chat']")).click();
        driver.
                findElement(By.xpath("//div[@class='_1UWac _3hKpJ focused']//div[@title='Arama metni giriş alanı']")).
                sendKeys(isim+ Keys.TAB + Keys.ENTER);


        for (int i = 0; i < kacTaneMesajAtmakIstiyorsunuz; i++) {
            driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys(gondermekIstediginizMesaj + Keys.ENTER);

        }
        driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys("tamam tamam bu mesaj sondu hadi iyi geceler :)" + Keys.ENTER);
        waitFor(8);
        driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys("Saka yaptım :)))) devammmm hoppplaa " + Keys.ENTER);
        for (int i = 0; i < kacTaneMesajAtmakIstiyorsunuz; i++) {
            driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys(gondermekIstediginizMesaj2 + Keys.ENTER);
        }
        driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys("tamam bro bu sondu  hadi iyi geceler ."+Keys.ENTER );
        driver.findElement(By.xpath("//p[@class='selectable-text copyable-text']")).sendKeys("Saka yahu devammmm hoppplaa " + Keys.ENTER);


    }
}
