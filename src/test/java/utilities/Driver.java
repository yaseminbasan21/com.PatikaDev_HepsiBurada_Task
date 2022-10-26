package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    POM'de Driver icin TestBase class'ına extends etmek yerine
    Driver class'ından static method'lar kullanarak
    driver olusturup, ilgili ayarların yapılması
    ve en sonda driver'ın kapatılması tercih edilmistir

    POM'de Driver class'ındaki getDriver()'nın obje olusturularak
    kullanılmasını engellemek icin
    Singleton pattern kullanımı benimsenmistir

    Singleton Pattern:tekli kullanım, bir class'ın farklı
    class'lardan obje olusturularak kullanımını engellemek icin
    kullanılır.

    Bunu saglamak icin yapmamız gereken sey oldukca basit
    Obje olusturmak icin kullanılan constructor'ı private yaptıgınızda
    baska class'larda Driver class'ından obje olusturulması mumkun OLAMAZ

     */
    private  Driver(){

    }

    static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver==null){ //her seferinde yeni bir sayfa acılsın istemedigimiz icin sadece en basta hic acılmamıs driver'ı olusturuyoruz
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(); //getDriver() method'u her seferinde driver'a yeni bir driver olusturur,yeni bir browser

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }
        return driver; //eger daha once chromeDriver degeri olusturulmussa yukarısı calısmıcak, var olan driver geri donucek
    }

    public static void closeDriver(){
        if (driver!=null){  //driver'a deger atanmıs
            driver.close(); //atanmıssa kapat
            driver=null;
        }

    }
}

