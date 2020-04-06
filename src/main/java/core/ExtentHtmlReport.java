package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import utils.Utils;

import java.io.File;
import java.io.IOException;

public class ExtentHtmlReport {
    private static String reportName, reportPathName;
    private static int testCaseCounter = 0;
    public static ThreadLocal<ExtentTest> reportLoggerPool = new ThreadLocal<>();

    static ExtentReports report;
    static ExtentHtmlReporter htmlReporter;

    public static void setUpExtentHtmlReport(String testName, String testDataLanguage, String browserName) {
            reportName = "Report-" + testName + "-" + testDataLanguage + "-" + browserName + ".html";
            reportPathName = System.getProperty("user.dir") + File.separator + "Reports" + File.separator + reportName;
            htmlReporter = new ExtentHtmlReporter(reportPathName);

            report = new ExtentReports();
            report.attachReporter(htmlReporter);
    }

    public static void log(Status logStatus, String message) {
        ExtentTest report = reportLoggerPool.get();
        if (logStatus == Status.FAIL || logStatus == Status.FATAL)
            createScreenshot(report, message.replace(">", ""));
        else if (logStatus == Status.SKIP)
            report.log(logStatus, message);
        else if (logStatus == Status.PASS)
            report.log(logStatus, message);
        else
            report.log(logStatus, message);
    }

    private static void createScreenshot(ExtentTest report, String message) {
        String date = Utils.getCurrentDate();
        String screenShotName = message.replaceAll(" ", "_") + date + ".png";
        String screenShotPath = System.getProperty("user.dir") + File.separator + "Reports" + File.separator + "Screenshots" + File.separator;
        String screenShotFileWithPath = screenShotPath + screenShotName;
        ScreenShotManager.takeScreenshot(DriverManager.getDriver(), screenShotFileWithPath);
        try {
            report.fail(message, MediaEntityBuilder.createScreenCaptureFromPath("Screenshots" + File.separator + screenShotName).build());
        } catch (IOException e) {
            report.fail(message);
        }
    }

    public static void createExtentHtmlReport(String testCaseName) {
        testCaseCounter++;
        ExtentTest reportLogger = report.createTest(testCaseCounter + ". " + testCaseName);
        reportLoggerPool.set(reportLogger);
    }

    public static void flushReport() {report.flush();}

    public static ExtentTest getReporter() {
        return reportLoggerPool.get();
    }

}
