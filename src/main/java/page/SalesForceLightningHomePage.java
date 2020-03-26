package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static utils.Utils.waitForCondition;

public class SalesForceLightningHomePage extends BasePage {
    private String NAVIGATION_ITEM_BY_NAME = "//p[text()='%s']";
    private String PAGE_TITLE = "//span[@title ='%s']";

    @FindBy(xpath = "//div[contains(@class, 'profileTrigger')]")
    private WebElement profileTrigger;
    @FindBy(xpath = "//h1[@class='profile-card-name']/a")
    private WebElement userName;
    @FindBy(xpath = "//div[@class='profile-card-toplinks']/a")
    private List<WebElement> profileSettings;
    @FindBy(xpath = "//h3")
    private List<WebElement> sectionHeaders;

    //APP NAVIGATION
    @FindBy(xpath = "//button[@data-aura-class='uiButton forceHeaderButton salesforceIdentityAppLauncherHeader']")
    private WebElement navigation;

    //TAB NAVIGATION
    @FindBy(xpath = "//div[contains(@class, 'selectedListItem')]/a")
    private WebElement homeTab;

    public void openProfileInfo() {
        profileTrigger.click();
        waitForCondition(driver, 10, 2000, cause ->
                userName.isDisplayed());
    }

    public String getProfileUserName() {
        return userName.getText();
    }

    public List<String> getProfileSettings() {
        List<String> settings = new ArrayList<>();
        profileSettings.stream().forEach(setting -> settings.add(setting.getText()));
        return settings;
    }

    public List<String> getProfileSectionHeaders() {
        List<String> headers = new ArrayList<>();
        sectionHeaders.stream().forEach(sectionHeader -> headers.add(sectionHeader.getText().toUpperCase()));
        return headers;
    }

    public void navigateTo(String navigateItem) {
        waitForCondition(driver, 10, 1, cause -> {
            navigation.click();
            driver.findElement(By.xpath(String.format(NAVIGATION_ITEM_BY_NAME, navigateItem))).click();
            return driver.findElement(By.xpath(String.format(PAGE_TITLE, navigateItem))).isDisplayed();
        });
    }

    public void navigateToHomeTab() {
        homeTab.click();
    }
}
