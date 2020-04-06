package core;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Step;

public class ReportManager {

    @Step("{message}")
    public static void log(Status logStatus, String message) {
        LoggerManager.log(message);
        ExtentHtmlReport.log(logStatus, message);
    }
}
