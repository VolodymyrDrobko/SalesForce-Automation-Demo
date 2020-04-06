package pageBO;

import core.CustomSoftAssert;
import core.ReportManager;
import page.BasePage;

public class BasePageBO {
    private BasePage basePage;
    protected ReportManager reportLogger;
    protected static CustomSoftAssert softAssert;

    public BasePageBO() {
        basePage = new BasePage();
        reportLogger = new ReportManager();
        softAssert = new CustomSoftAssert();
    }

    public void checkAllAssertions() {
        softAssert.assertAll();
    }
}
