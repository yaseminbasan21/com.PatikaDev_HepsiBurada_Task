package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class HepsiBuradaPage {

  public HepsiBuradaPage(){
      PageFactory.initElements(Driver.getDriver(),this);
  }


  public void istenilenWebSiteyeGitme(){
    Driver.getDriver().get(ConfigReader.getProperty("url"));
    try {
      if (çerezKabulEt.isDisplayed()) {
        çerezKabulEt.click();
      }
    } catch (Exception e) {

    }

  }

  public void girişİşlemiYapmaVeDoğrulama(){
    girişYapVeyaÜyeOlButonu.click();
    ReusableMethods.waitFor(3);
    girişYap.click();
    ReusableMethods.waitFor(3);
    ePostaDoğrulama.sendKeys(ConfigReader.getProperty("ePosta"));
    üyeGirişYapButonu.click();
    ReusableMethods.waitFor(3);
    şifre.sendKeys(ConfigReader.getProperty("sifre"));
    şifreGirişYapButonu.click();
    ReusableMethods.waitFor(3);
    hesabımButonu.isDisplayed();
  }
  public void ürünArama(){
    aramaButonu.sendKeys(ConfigReader.getProperty("ürün"));
    araButonu.click();
    ReusableMethods.waitFor(3);
  }

  public void ikinciSekmeyeGeçiş(){
    String ilkSayfaHandleDegeri=Driver.getDriver().getWindowHandle();
    Set<String> windowHandleSeti=Driver.getDriver().getWindowHandles();
    String ikinciSayfaWindowHandleDegeri="";
    for (String each:windowHandleSeti
    ) {
      if (!each.equals(ilkSayfaHandleDegeri)){
        ikinciSayfaWindowHandleDegeri=each;
      }
    }
    Driver.getDriver().switchTo().window(ikinciSayfaWindowHandleDegeri);
  }

  public void farklıSatıcılardanÜrünSeçVeSepeteEkle(){
    ilkSatıcıSepeteEkle.click();
    ReusableMethods.waitFor(3);
    try {
      if (çarpıButonu.isDisplayed()) {
        çarpıButonu.click();
      }
    } catch (Exception e) {

    }
    ikinciSatıcıSepeteEkle.click();
    ReusableMethods.waitFor(3);
    try {
      if (çarpıButonu.isDisplayed()) {
        çarpıButonu.click();
      }
    } catch (Exception e) {

    }
    ReusableMethods.waitFor(3);
  }

  public void seçilenÜrünüSepetimdeDoğrulama(){
    sepetimButonu.click();
    ReusableMethods.waitFor(3);
    Assert.assertTrue(ilkSatıcıÜrünü.isDisplayed());
    Assert.assertTrue(ikinciSatıcıÜrünü.isDisplayed());
  }

  public void kullanıcıİlkÜrünSecme(){
    ilkÜrünResmi.click();
    ReusableMethods.waitFor(3);
  }

  @FindBy(xpath = "//div[@id='myAccount']")
    public WebElement girişYapVeyaÜyeOlButonu;

  @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement çerezKabulEt;

  @FindBy(xpath = "//a[@id='login']")
    public WebElement girişYap;

  @FindBy(xpath = "//input[@id='txtUserName']")
    public WebElement ePostaDoğrulama;

  @FindBy(xpath = "//button[@id='btnLogin']")
    public WebElement üyeGirişYapButonu;

  @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement şifre;

  @FindBy(xpath = "//button[@id='btnEmailSelect']")
    public WebElement şifreGirişYapButonu;

  @FindBy(xpath = "//a[@title='Hesabım']")
    public WebElement hesabımButonu;

  @FindBy(xpath = "//input[@class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']")
    public WebElement aramaButonu;

  @FindBy(xpath = "//div[@class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']")
    public WebElement araButonu;

  @FindBy(xpath = "(//picture/img)[1]")
    public WebElement ilkÜrünResmi;

  @FindBy(xpath = "(//button[@class='add-to-basket button small'])[1]")
    public WebElement ilkSatıcıSepeteEkle;

  @FindBy(xpath = "(//button[@class='add-to-basket button small'])[2]")
    public WebElement ikinciSatıcıSepeteEkle;

  @FindBy(xpath = "//a[@class='checkoutui-Modal-iHhyy79iR28NvF33vKJb']")
    public WebElement çarpıButonu;

  @FindBy(xpath = "//a[@class='sf-OldMyAccount-MjrNQp_LLdAaN1g0xvSz sf-OldMyAccount-VcxldoRSjUmlWBLJaTly']")
    public WebElement sepetimButonu;

  @FindBy(xpath = "(//div[@class='merchantBox_1LA1r'])[2]")
    public WebElement ilkSatıcıÜrünü;

  @FindBy(xpath = "(//div[@class='merchantBox_1LA1r'])[1]")
    public WebElement ikinciSatıcıÜrünü;



}
