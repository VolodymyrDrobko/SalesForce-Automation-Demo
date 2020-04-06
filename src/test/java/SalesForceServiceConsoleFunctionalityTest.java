import core.BaseTest;
import core.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pageBO.SalesForceLightningHomePageBO;
import pageBO.SalesForceLoginPageBO;
import pageBO.SalesForceServiceConsoleBO;

import static core.Configuration.getTestDataByName;

public class SalesForceServiceConsoleFunctionalityTest extends BaseTest {

    @Test(description = "Service console 10005")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Epic001")
    @Story("Story001")
    public void verifyServiceConsoleFunctionality() {
        SalesForceLoginPageBO salesForceLoginPageBO = new SalesForceLoginPageBO();
        SalesForceLightningHomePageBO salesForceLightningHomePageBO = new SalesForceLightningHomePageBO();
        SalesForceServiceConsoleBO salesForceServiceConsoleBO = new SalesForceServiceConsoleBO();
        salesForceLoginPageBO
                .loginToSalesForce(Configuration.getLogin(), Configuration.getPassword());
        salesForceLightningHomePageBO
                .navigateToAppByName(getTestDataByName("appName"))
                .navigateToHomeTab();
        salesForceServiceConsoleBO
                .verifyCardDescription(getTestDataByName("cardDescription"))
                .checkAllAssertions();
    }
}
