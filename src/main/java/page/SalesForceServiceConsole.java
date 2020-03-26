package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalesForceServiceConsole extends BasePage {
    @FindBy(xpath = "//h1[@class='slds-align_absolute-center']")
    private WebElement cardDescription;

    public String getCardDescription() {
        return cardDescription.getText();
    }
}
