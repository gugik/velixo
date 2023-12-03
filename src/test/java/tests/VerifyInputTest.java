package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.XlPage;

public class VerifyInputTest extends BaseUiTest {
    @Test
    @Description("testCaseId = 'test_id'")
    public void verifyInputTest() {
        MainPage mainPage = openMainPage(prop.getProperty("email"), prop.getProperty("password"));
        XlPage xlBook = mainPage.openXlBook();
        xlBook.setFormula("=TODAY()");
        //TODO verify
    }
}
