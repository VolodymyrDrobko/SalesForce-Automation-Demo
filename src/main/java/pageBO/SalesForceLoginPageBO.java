package pageBO;

import com.aventstack.extentreports.Status;
import page.SalesForceLoginPage;

import java.util.Optional;

import static utils.Constants.DEFAULT_LOGIN;
import static utils.Constants.DEFAULT_PASSWORD;

public class SalesForceLoginPageBO extends BasePageBO {
    private SalesForceLoginPage salesForceLoginPage;

    public SalesForceLoginPageBO() {
        salesForceLoginPage = new SalesForceLoginPage();
    }

    public SalesForceLoginPageBO goToSalesForceLoginPage(String loginPageUrl) {
        reportLogger.log(Status.INFO, "Go to Sales Force Login page");
        salesForceLoginPage.navigateToSalesForceLoginPage(loginPageUrl);
        return this;
    }

    public SalesForceLoginPageBO loginToSalesForce(String login, String password) {
        reportLogger.log(Status.INFO, "Login to Sales Force");
        salesForceLoginPage.loginToSalesForce(Optional.ofNullable(login).orElse(DEFAULT_LOGIN), Optional.ofNullable(password)
                .orElse(DEFAULT_PASSWORD));
        return this;
    }
}
