package testcases.Practice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_09 extends TestBase {
    @Test
    public void test01() {
        //sahibinden.com a gidin
        driver.get("https://sahibinden.com");

        //anasayfada oldugunuzu dogrulayin
        Assert.assertTrue(getWebElementWithXpath("//*[@class='logo']").isDisplayed());

        //detayli arama tiklayin
        getWebElementWithXpath("//a[@title='Detaylı Arama']").click();

        //detayli arama sayfasina geldiginizi dogrulatin
        Assert.assertTrue(getWebElementWithXpath("//label[normalize-space()='Kategori']").isDisplayed());

        //emlak-konut-satilik seceneklerini secip
        getWebElementWithXpath("//span[normalize-space()='Emlak']").click();
        getWebElementWithXpath("//span[normalize-space()='Konut']").click();
        getWebElementWithXpath("//span[normalize-space()='Satılık']").click();
        getWebElementWithXpath("//span[normalize-space()='Daire']").click();

        //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin


        //filtreler için sağıdakilere benzer methodlar oluşturun
//    detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
//    detayli_Arama_Fiyat("4.000","4.000.000","USD");
//    detayli_Arama_Brut("180","400");
//    detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi

        detailedSearchBoxAddress("ankara", "altindag", "atifbey mh.");
        fiyat("5000", "1000000", "TL");
        brut("150", "180");


//cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin
    }


    //    public void detailedSearchBoxAdres(String city, String town,String street) {
//        getWebElementWithXpath("//*[@aria-label='Kapat']").click();
//        Actions actions = new Actions(driver);
//        driver.findElement(By.xpath("//*[@placeholder='İl']")).click();
//        waitFor(3);
//        String cityXpath = "//*[@data-label='" + city.toLowerCase() + "']";
//        waitFor(2);
//        actions.moveToElement(driver.findElement(By.xpath(cityXpath))).click().build().perform();
//
//
//        waitFor(3);
//        driver.findElement(By.xpath("//*[@title='İlçe']")).click();
//        waitFor(3);
//        String townXpath = "//*[@data-label='" + town.toLowerCase() + "']";
//        waitFor(2);
//        actions.moveToElement(driver.findElement(By.xpath(townXpath))).click().build().perform();
//        getWebElementWithXpath("//*[@class='collapse-pane']").click();
//        waitFor(3);
//
//        waitFor(3);
//        driver.findElement(By.xpath("//*[@title='Mahalle']")).click();
//        waitFor(3);
//        String streetXpath = "//*[@data-label='" + street.toLowerCase() + "']";
//        waitFor(2);
//        actions.moveToElement(driver.findElement(By.xpath(streetXpath))).click().build().perform();
//        getWebElementWithXpath("//*[@class='collapse-pane']").click();
//        waitFor(3);
//
//    }
    public void detailedSearchBoxAddress(String city, String district, String town) {
        Actions actions = new Actions(driver);
        getWebElementWithXpath("//*[@aria-label='Kapat']").click();
        waitFor(5);
        actions.click(driver.findElement(By.xpath("(//a[@class='faceted-select'])[1]"))).perform();
        String cityXpath = "//*[@data-label='" + city.toLowerCase() + "']";
        waitFor(5);
        actions.moveToElement(driver.findElement(By.xpath(cityXpath))).click().build().perform();

        waitFor(5);

        actions.click(driver.findElement(By.xpath("//a[@title='İlçe']"))).perform();
        String districtXpath = "//*[@data-label='" + district + "']";
        actions.moveToElement(driver.findElement(By.xpath(districtXpath))).click().build().perform();
        waitFor(5);
        actions.click(driver.findElement(By.xpath("//a[@class='collapse-pane']"))).click().perform();

        waitFor(5);

        actions.click(driver.findElement(By.xpath("//a[@title='Mahalle']"))).perform();
        waitFor(5);
        String townXpath = "//*[@data-label='" + town + "']";
        actions.moveToElement(driver.findElement(By.xpath(townXpath))).click().build().perform();
        actions.click(driver.findElement(By.xpath("//a[@class='collapse-pane']"))).click().perform();
    }

    public void fiyat(String x, String y, String birim) {
        getWebElementWithXpath("//*[@name='price_min']").sendKeys(x, Keys.TAB, y);
        selectFromDropdown(getWebElementWithXpath("//*[@name='price_currency']"), "TL");
    }

    public void brut(String x, String y) {
        getWebElementWithXpath("//*[@name='a24_min']").sendKeys(x, Keys.TAB, y);
    }
}

