package utils;

import org.openqa.selenium.By;
import pages.LoginPage;

public class PageActions {
    private Browser browser;

    public PageActions(Browser browser) {
        this.browser = browser;
    }

    public LoginPage goToLoginPage() {
        browser.click(browser.getDriver().findElement(By.xpath("//*[@data-bi-cn='SignIn']")));
        browser.getWait().waitForLoad();
        String originalWindow = browser.getDriver().getWindowHandle();
        for (String windowHandle : browser.getDriver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                browser.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        browser.getWait().waitForLoad();
        return new LoginPage(browser);
    }
}
