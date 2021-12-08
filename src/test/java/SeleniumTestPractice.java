import modules.Base;
import modules.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.DemoSiteLoginPage;

public class SeleniumTestPractice {
    WebDriver driver;
    Utility utils;
    DemoSiteLoginPage loginObj;
    @BeforeTest
    public void setUp()
    {
        /*  Setup */
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        utils = new Utility(driver);
        loginObj = new DemoSiteLoginPage(driver, utils);
        utils.getBaseUrl(driver);
    }
    @Test
    public void verifyLoginPage()
    {
        /* verify the login page */
        loginObj.verifyLoginPageTitle();
    }
    @Test
    public  void verifyLoginSection()
    {
        /* verify the login Section */
        loginObj.verifyLoginSection();
        loginObj.enterLoginEmail();
        loginObj.enterLoginPassword();
        loginObj.clickSubmit();
        loginObj.verifyLoginSuccess();
    }
    @AfterTest void tearDown()
    {
     driver.quit();
    }
}
