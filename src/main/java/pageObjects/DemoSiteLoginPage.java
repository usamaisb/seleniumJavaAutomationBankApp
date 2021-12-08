package pageObjects;


import modules.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DemoSiteLoginPage {
    WebDriver driver;
    Utility utils;
    WebElement element;
    public DemoSiteLoginPage(WebDriver _driver, Utility _utils)
    {
        this.driver = _driver;
        this.utils=_utils;
    }
    public  String loginPageTitle = "Guru99 Bank Home Page";
    public  String loginSuccessPageTitle = "Guru99 Bank Manager HomePage";
    public  String loginSectionHeadingElement = "h2[class='barone']";
    public  String loginSectionHeadingText = "Guru99 Bank";
    public  String loginEmailElement = "input[name='uid']";
    public  String loginPasswordElement = "input[name='password']";
    public  String getText;
    public  String loginEmail ="mngr372618";
    public  String loginPassword ="YpEgYme";
    public  String loginSubmitElement = "input[name='btnLogin']";
    public  String loginSuccessElement = "marquee[class='heading3']";
    public  String loginSuccessWelcomeMessage = "Welcome To Manager's Page of Guru99 Bank";
    String actualTitle;
    public void verifyLoginPageTitle()
    {
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equalsIgnoreCase(loginPageTitle));
    }
    public void verifyLoginSection()
    {
        utils.waitForElementInDom(By.cssSelector(loginSectionHeadingElement), 15);
        getText = utils.getText(By.cssSelector(loginSectionHeadingElement));
        Assert.assertEquals(loginSectionHeadingText, getText);
        utils.waitForElementInDom(By.cssSelector(loginEmailElement), 15);
        utils.waitForElementInDom(By.cssSelector(loginPasswordElement), 15);
    }
    public void enterLoginEmail()
    {
        utils.enterText(By.cssSelector(loginEmailElement), loginEmail);
    }
    public void enterLoginPassword()
    {
        utils.enterText(By.cssSelector(loginPasswordElement), loginPassword);
    }
    public void clickSubmit()
    {
        utils.findAndClick(By.cssSelector(loginSubmitElement));
    }
    public void verifyLoginSuccess()
    {
        String welcomeText;
        utils.waitForElementInDom(By.cssSelector(loginSuccessElement), 15);
        element = driver.findElement(By.cssSelector(loginSuccessElement));
        welcomeText =element.getText();
        Assert.assertEquals(loginSuccessWelcomeMessage, welcomeText);
        actualTitle = driver.getTitle();
        Assert.assertEquals(loginSuccessPageTitle, actualTitle);
    }
}
