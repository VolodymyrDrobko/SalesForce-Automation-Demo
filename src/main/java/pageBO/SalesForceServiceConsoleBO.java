package pageBO;

import com.aventstack.extentreports.Status;
import page.SalesForceServiceConsole;

public class SalesForceServiceConsoleBO extends BasePageBO {
    private SalesForceServiceConsole salesForceServiceConsole;

    public SalesForceServiceConsoleBO() {
        salesForceServiceConsole = new SalesForceServiceConsole();
    }

    public SalesForceServiceConsoleBO verifyCardDescription(String cardDescription) {
        reportLogger.log(Status.INFO, "Verify Service Console card Description, expected - " + cardDescription);
        String actualCardDescription = salesForceServiceConsole.getCardDescription();
        softAssert.assertEquals(actualCardDescription, cardDescription,
                "Service Console card Description, found - " + actualCardDescription);
        return this;
    }
}
