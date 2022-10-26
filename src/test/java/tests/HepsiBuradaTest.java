package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HepsiBuradaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;


public class HepsiBuradaTest {

    @Test
    public void hepsiBuradaTest(){
        HepsiBuradaPage hepsiBuradaPage=new HepsiBuradaPage();
        //Kullanıcı Hepsiburada.com sitesini ziyaret eder.
          Driver.getDriver().get(ConfigReader.getProperty("hepsiBuradaUrl"));

        //Kullanıcı giriş işlemi yapılır.
        ReusableMethods.waitFor(3);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(hepsiBuradaPage.girişYapVeyaÜyeOlButonu).click(hepsiBuradaPage.girişYap).perform();


      //  hepsiBuradaPage.girişYapVeyaÜyeOlButonu.click();
      //  ReusableMethods.waitFor(3);
     //   hepsiBuradaPage.girişYap.click();
        ReusableMethods.waitFor(3);
        hepsiBuradaPage.ePostaDoğrulama.sendKeys(ConfigReader.getProperty("ePosta"));
        hepsiBuradaPage.üyeGirişYapButonu.click();
        ReusableMethods.waitFor(3);
        hepsiBuradaPage.şifre.sendKeys(ConfigReader.getProperty("sifre"));
        hepsiBuradaPage.şifreGirişYapButonu.click();
        ReusableMethods.waitFor(3);

        //Yönlendirmeden sonra anasayfada kullanıcı giriş işleminin yapıldığı doğrulanır.
        hepsiBuradaPage.hesabımButonu.isDisplayed();

        //Kullanıcı, burada satın almak istediği ürün için arama yapacaktır.
        hepsiBuradaPage.aramaButonu.sendKeys("defter");
        hepsiBuradaPage.araButonu.click();
        ReusableMethods.waitFor(3);

        //Kullanıcı, Arama sonucunda ekrana gelen ürün listesinden (veya tek bir sonuç da dönmüş olabilir) ürün seçer.
        hepsiBuradaPage.defterİlkResim.click();
        ReusableMethods.waitFor(3);

        //Seçilen ürün için 2 tane farklı satıcıdan ürün seçilip sepete eklenir.
        hepsiBuradaPage.ilkSatıcıSepeteEkle.click();
        hepsiBuradaPage.çarpıButonu.click();
        ReusableMethods.waitFor(3);
        hepsiBuradaPage.ikinciSatıcıSepeteEkle.click();
        hepsiBuradaPage.çarpıButonu.click();
        ReusableMethods.waitFor(3);

        //Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanmalıdır.
        hepsiBuradaPage.sepetimButonu.click();
        Assert.assertTrue(hepsiBuradaPage.ilkSatıcıÜrünü.isDisplayed());
        Assert.assertTrue(hepsiBuradaPage.ikinciSatıcıÜrünü.isDisplayed());


        //







     }
}
