package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import page.HepsiBuradaPage;
import utilities.*;




public class HepsiBuradaTest extends TestBaseRapor {

    HepsiBuradaPage hepsiBuradaPage;
    Logger log =(Logger) LogManager.getLogger(HepsiBuradaTest.class);

    @Test
        public void üyeGirişiYaparakAlışveriş(){
        hepsiBuradaPage=new HepsiBuradaPage();

        hepsiBuradaPage.istenilenWebSiteyeGitme();
        log.info("Kullanıcı"+ConfigReader.getProperty("url")+ "sitesini ziyaret eder");


        hepsiBuradaPage.girişİşlemiYapmaVeDoğrulama();
        log.info("Kullanıcı sorunsuz bir şekilde giriş işlemi yapar ve giriş işleminin yapıldığı doğrulanır");


        hepsiBuradaPage.ürünArama();
        log.info("Kullanıcı satın almak istediği ürün için arama yapar");


        hepsiBuradaPage.kullanıcıİlkÜrünSecme();
        log.info("Kullanıcı,arama sonucunda ekrana gelen ürün listesinden ürün seçer");

        hepsiBuradaPage.ikinciSekmeyeGeçiş();
        hepsiBuradaPage.farklıSatıcılardanÜrünSeçVeSepeteEkle();
        log.info("Kullanıcı seçtiği ürün için 2 tane farklı satıcıdan ürünü sepete ekler");


        hepsiBuradaPage.seçilenÜrünüSepetimdeDoğrulama();
        log.info("Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanır");

        Driver.quitDriver();

    }

    @Test
    public void üyeGirişiYapmadanAlişveriş(){

        hepsiBuradaPage=new HepsiBuradaPage();

        Log.startTestCase("Kullanıcının üye girişi yapmadan sepetine eklediği ürünleri doğrulama testi");
        hepsiBuradaPage.istenilenWebSiteyeGitme();
        Log.info("Kullanıcı"+ConfigReader.getProperty("url")+ "sitesini ziyaret eder");


        hepsiBuradaPage.ürünArama();
        Log.info("Kullanıcı satın almak istediği ürün için arama yapar");


        hepsiBuradaPage.kullanıcıİlkÜrünSecme();
        Log.info("Kullanıcı,arama sonucunda ekrana gelen ürün listesinden ürün seçer");


        hepsiBuradaPage.ikinciSekmeyeGeçiş();
        hepsiBuradaPage.farklıSatıcılardanÜrünSeçVeSepeteEkle();
        Log.info("Kullanıcı seçtiği ürün için 2 tane farklı satıcıdan ürünü sepete ekler");


        hepsiBuradaPage.seçilenÜrünüSepetimdeDoğrulama();
        Log.info("Seçilen ürünün doğru olarak eklendiği ‘Sepetim’ sayfasında doğrulanır");

        Driver.quitDriver();

    }
















}
