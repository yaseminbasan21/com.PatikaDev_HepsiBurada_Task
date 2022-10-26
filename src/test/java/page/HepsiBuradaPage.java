package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiBuradaPage {
  public HepsiBuradaPage(){
      PageFactory.initElements(Driver.getDriver(),this);
  }

  @FindBy(xpath = "//div[@id='myAccount']")
    public WebElement girişYapVeyaÜyeOlButonu;

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

  @FindBy(xpath = "(//div[@class='moria-ProductCard-bwbOzc LLL sazx9i6uu3f'])[1]")
    public WebElement defterİlkResim;

  @FindBy(xpath = "(//button[@class='add-to-basket button small'])[1]")
    public WebElement ilkSatıcıSepeteEkle;

  @FindBy(xpath = "(//button[@class='add-to-basket button small'])[2]")
    public WebElement ikinciSatıcıSepeteEkle;

  @FindBy(xpath = "//a[@class='checkoutui-Modal-2iZXl']")
    public WebElement çarpıButonu;

  @FindBy(xpath = "//a[@class='sf-OldMyAccount-MjrNQp_LLdAaN1g0xvSz sf-OldMyAccount-VcxldoRSjUmlWBLJaTly']")
    public WebElement sepetimButonu;

  @FindBy(xpath = "(//div[@class='merchantBox_1LA1r'])[2]")
    public WebElement ilkSatıcıÜrünü;

  @FindBy(xpath = "(//div[@class='merchantBox_1LA1r'])[1]")
    public WebElement ikinciSatıcıÜrünü;





}
