package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class MainPage extends BasePage {

    public MainPage(Browser browser) {
        super(browser);
        browser.getWait().waitForLoad();
        Assert.assertTrue(browser.getDriver().findElement(By.id("ReactShellHeader"))
                .isDisplayed(), "MainPage is not loaded!");
    }

    public XlPage openXlBook() {
        browser.getWait().waitForLoad();
        browser.click(browser.getDriver().findElement(
                By.xpath("//*[@data-icon-name='Excel_ButtonBackground']")));
        browser.getWait().waitForLoad();
        String originalWindow = browser.getDriver().getWindowHandle();
        for (String windowHandle : browser.getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                browser.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        browser.getWait().sleep(5);
        return new XlPage(browser);
    }
}
