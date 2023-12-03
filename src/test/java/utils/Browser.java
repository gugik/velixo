package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Browser {

    //TODO Logger
    private WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Wait getWait() {
        return new Wait(this);
    }

    public PageActions getPageActions() {
        return new PageActions(this);
    }

    public WebElement click(WebElement element) {
        getWait().waitForLoad();
        element.click();
        getWait().waitForLoad();
        return element;
    }

    public WebElement type(String value, WebElement element) {
        getWait().waitForLoad();
        element.clear();
        element.sendKeys(value);
        return element;
    }
}
