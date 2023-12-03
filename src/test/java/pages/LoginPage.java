package pages;

import org.openqa.selenium.By;
import utils.Browser;

public class LoginPage extends BasePage {

    public LoginPage(Browser browser) {
        super(browser);
        browser.getWait().waitForLoad();
    }

    public MainPage login(String email, String password) {
        browser.type(email, browser.getDriver().findElement(
                By.xpath("//*[@class='placeholderContainer']//input")));
        browser.getWait().waitForLoad();
        browser.click(browser.getDriver().findElement(By.id("idSIButton9")));
        browser.getWait().waitForLoad();
        browser.getWait().sleep(2);
        browser.type(password, browser.getDriver().findElement(
                By.xpath("//*[@class='placeholderContainer']//input")));
        browser.getWait().sleep(2);
        browser.click(browser.getDriver().findElement(By.id("idSIButton9")));
        browser.getWait().sleep(5);
        browser.click(browser.getDriver().findElement(By.xpath("//*[@type='submit']")));
        browser.getWait().waitForLoad();
        return new MainPage(browser);
    }

}
