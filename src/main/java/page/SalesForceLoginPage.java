package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Utils.waitForCondition;

public class SalesForceLoginPage extends BasePage {
    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement logInButton;

    public void navigateToSalesForceLoginPage(String loginPageUrl) {
        driver.get(loginPageUrl);
    }

    public void loginToSalesForce(String userName, String password) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        waitForCondition(driver, 10, 2000, cause ->
                logInButton.isDisplayed());
        logInButton.click();
    }
}
