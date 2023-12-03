package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.Browser;

public class XlPage extends BasePage {

    public XlPage(Browser browser) {
        super(browser);
        browser.getWait().sleep(5);
        //Assert.assertFalse(browser.getDriver().findElements(By.id("AdditionalBarsRegion")).isEmpty(), "XlPage is not loaded!");
    }

    public XlPage setFormula(String formula) {

        //not possible to locate element
        browser.getWait().sleep(3);
        WebDriver driver = browser.getDriver();
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);

        driver.findElement(By.id("MainApp"))
                .findElement(By.id("formulaBarTextDivId"))
                .sendKeys(formula + Keys.ENTER);
        browser.getWait().waitForLoad();
        browser.getWait().sleep(5);
        return new XlPage(browser);
    }
}
