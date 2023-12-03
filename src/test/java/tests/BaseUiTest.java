package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import utils.Browser;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseUiTest {

    protected SoftAssert softAssert;
    protected Browser browser;
    protected Properties prop;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        prop = readPropertiesFile("src/test/resources/config.properties");
        browser = new Browser(new ChromeDriver());
        browser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        browser.getDriver().manage().window().maximize();
        browser.getDriver().get(prop.getProperty("url"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        browser.getDriver().close();
    }

    protected MainPage openMainPage(String email, String password) {
        return browser.getPageActions().goToLoginPage().login(email, password);
    }

    private static Properties readPropertiesFile(String fileName) {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return prop;
    }


}
