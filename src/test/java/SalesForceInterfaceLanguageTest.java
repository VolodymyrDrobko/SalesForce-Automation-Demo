import core.BaseTest;
import core.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pageBO.SalesForceLightningHomePageBO;
import pageBO.SalesForceLoginPageBO;

import java.util.Arrays;
import java.util.List;

import static core.Configuration.getTestDataByName;


public class SalesForceInterfaceLanguageTest extends BaseTest {

    @Test(description = "Service console 10005")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Epic001")
    @Story("Story001")
    public void verifyServiceConsoleLanguage() {
        SalesForceLoginPageBO salesForceLoginPageBO = new SalesForceLoginPageBO();
        SalesForceLightningHomePageBO salesForceLightningHomePageBO = new SalesForceLightningHomePageBO();
        List<String> expectedSettings = Arrays.asList(getTestDataByName("profileSettings").split(", "));
        List<String> expectedSectionHeaders = Arrays.asList(
                getTestDataByName("profileSectionHeaders").split(", "));
        salesForceLoginPageBO
                .loginToSalesForce(Configuration.getLogin(), Configuration.getPassword());
        salesForceLightningHomePageBO
                .openSalesForceProfile()
                .verifySalesForceProfileUserName(getTestDataByName("profileUserName"))
                .verifySalesForceProfileSettingsLanguage(expectedSettings)
                .verifySalesForceProfileSectionHeadersLanguage(expectedSectionHeaders)
                .checkAllAssertions();
    }
}
