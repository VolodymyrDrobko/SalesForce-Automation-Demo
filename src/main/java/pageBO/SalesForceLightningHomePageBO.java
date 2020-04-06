package pageBO;

import com.aventstack.extentreports.Status;
import page.SalesForceLightningHomePage;

import java.util.List;

public class SalesForceLightningHomePageBO extends BasePageBO {
    private SalesForceLightningHomePage salesForceLightningHomePage;

    public SalesForceLightningHomePageBO() {
        salesForceLightningHomePage = new SalesForceLightningHomePage();
    }

    public SalesForceLightningHomePageBO navigateToAppByName(String appName) {
        reportLogger.log(Status.INFO, "Navigate to " + appName + " app");
        salesForceLightningHomePage.navigateTo(appName);
        return this;
    }

    public SalesForceLightningHomePageBO navigateToHomeTab() {
        reportLogger.log(Status.INFO, "Navigate to Home tab");
        salesForceLightningHomePage.navigateToHomeTab();
        return this;
    }

    public SalesForceLightningHomePageBO openSalesForceProfile() {
        reportLogger.log(Status.INFO, "Open Sales Force Profile");
        salesForceLightningHomePage.openProfileInfo();
        return this;
    }

    public SalesForceLightningHomePageBO verifySalesForceProfileUserName(String profileUserName) {
        reportLogger.log(Status.INFO, "Verify Sales Force Profile user name, expected - " + profileUserName);
        String actualProfileUserName = "";//salesForceLightningHomePage.getProfileUserName();
        softAssert.assertEquals(actualProfileUserName, profileUserName,
                "Sales Force Profile user name, found - " + actualProfileUserName);
        return this;
    }

    public SalesForceLightningHomePageBO verifySalesForceProfileSettingsLanguage(List<String> profileSettings) {
        reportLogger.log(Status.INFO, "Verify Sales Force Profile settings language, expected - " + profileSettings);
        List<String> actualProfileSettings = salesForceLightningHomePage.getProfileSettings();
        softAssert.assertEquals(actualProfileSettings, profileSettings,
                "Sales Force Profile settings, found - " + actualProfileSettings);
        return this;
    }

    public SalesForceLightningHomePageBO verifySalesForceProfileSectionHeadersLanguage(List<String> profileSectionHeaders) {
        reportLogger.log(Status.INFO, "Verify Sales Force Profile settings language," +
                " expected - " + profileSectionHeaders);
        List<String> actualProfileSectionHeaders = salesForceLightningHomePage.getProfileSectionHeaders();
        softAssert.assertEquals(actualProfileSectionHeaders, profileSectionHeaders,
                "Sales Force Profile section headers, found - " + actualProfileSectionHeaders);
        return this;
    }
}
