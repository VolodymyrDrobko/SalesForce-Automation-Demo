package core;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Optional;

import static core.Configuration.setTestDataLanguage;
import static utils.Constants.DEFAULT_BROWSER;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext iTestContext) {
        String suiteName = iTestContext.getSuite().getName();
        String testDataLanguage = iTestContext.getCurrentXmlTest().getParameter("language");
        setTestDataLanguage(testDataLanguage);
        String browserName = Optional.ofNullable(Configuration.getBrowser())
                .orElse(DEFAULT_BROWSER);
        ExtentHtmlReport.setUpExtentHtmlReport(suiteName, testDataLanguage, browserName);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String testCaseName = iTestResult.getMethod().getMethodName();
        ExtentHtmlReport.createExtentHtmlReport(testCaseName);
        ReportManager.log(Status.INFO, "Test case is started - " + testCaseName);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        String testCaseName = iTestResult.getMethod().getMethodName();
        ReportManager.log(Status.PASS, testCaseName + " - PASSED SUCCESSFUL");
        ExtentHtmlReport.flushReport();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String testCaseName = iTestResult.getMethod().getMethodName();
        ReportManager.log(Status.FAIL, testCaseName + " >>>>> FAILED");
        ExtentHtmlReport.flushReport();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        String testCaseName = iTestResult.getMethod().getMethodName();
        ExtentHtmlReport.log(Status.SKIP, testCaseName + " >>>>> SKIPPED");
        ExtentHtmlReport.flushReport();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentHtmlReport.flushReport();
    }
}
