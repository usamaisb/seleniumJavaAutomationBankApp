package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
    WebDriver utilityDriver;
    WebElement element;
    By by;
    public static String getText;
    private  String baseUrl = "http://demo.guru99.com/v4/";
    public Utility(WebDriver driver) {
        this.utilityDriver = driver;
    }

    public void getBaseUrl(WebDriver driver) {
        System.out.print("Using Url>>>>>>>::" + baseUrl);
        utilityDriver.get(baseUrl);
        utilityDriver.manage().window().maximize();
    }

    /*  Wait for an element to be present in DOM before specified time has elapsed  */
    public void waitForElementInDom(By elementIdentifier, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(utilityDriver, timeOutInSeconds);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementIdentifier));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public String getText(By by) {
        element = utilityDriver.findElement(by);
        getText = element.getText();
        return getText;
    }
    public void enterText(By by, String Text)
    {
        element = utilityDriver.findElement(by);
        element.sendKeys(Text);
    }
    public void findAndClick(By by)
    {
        element = utilityDriver.findElement(by);
        element.click();
    }
}
