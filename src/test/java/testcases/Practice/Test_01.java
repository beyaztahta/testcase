package testcases.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1-C01_TekrarTestiisimlibirclassolusturun

        // 2-https://www.google.com/adresinegidin
         driver.get("https://www.google.com/");

        //3-Sayfa basliginin“Google”ifadesi icerdigini test edin
         String title=driver.getTitle();
         String actualTitle="Google";
         if(title.equals(actualTitle)) {
             System.out.println("TEST PASSED");
         } else System.out.println("TEST FAILED");


        //4-Arama cubuguna“Nutella”yazip aratin
        WebElement searchBox= driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys("Nutella", Keys.ENTER);

        //5-Bulunan sonuc sayisini yazdirin
        WebElement sonucSayısıYazısı= driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(sonucSayısıYazısı.getText());


        //6-sonuc sayisinin 10milyon’dan fazla oldugunu testedin
       String []sonucSayısı=sonucSayısıYazısı.getText().split(" ");
       String result= sonucSayısı[1].replace(".","");
       System.out.println(result);

       if(Integer.parseInt(result) >10.000000){
            System.out.println("test passed");
        }else System.out.println("test failed");


        //7-Sayfayi kapatin
        driver.close();
    }
}
