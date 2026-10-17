package org.pranabsarkar.com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.Logger;
import org.pranabsarkar.com.ui.tests.TestBase;
import org.pranabsarkar.com.utility.BrowserUtility;
import org.pranabsarkar.com.utility.ExtentReporterUtility;
import org.pranabsarkar.com.utility.LoggerUtility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;


/**
 * TestNG listener for handling test execution events.
 *
 * <p>Logs test execution details and integrates with ExtentReports for reporting.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class TestListeners implements ITestListener {
    Logger logger = LoggerUtility.getLogger(this.getClass());
    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    /**
     * Called when a test starts.
     *
     * @param result the result of the test method that is starting
     */
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
    }

    /**
     * Called when a test passes.
     *
     * @param result the result of the test method that passed
     */
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " PASSED");
        ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
    }

    /**
     * Called when a test fails.
     *
     * @param result the result of the test method that failed
     */
    public void onTestFailure(ITestResult result) {
        try {
            logger.error(result.getMethod().getMethodName() + " FAILED");
            logger.error(result.getThrowable().getMessage());
            ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
            ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
            Object testClass = result.getInstance();
            BrowserUtility browserUtility = ((TestBase) testClass).getInstance();
            logger.info("Capturing Screenshot for the failed tests.");
            String screenShotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
            ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenShotPath);
            logger.info("Attaching Screenshot to the HTML file.");
        } catch (Exception e) {
            logger.error("Error while handling test failure: ", e);
        }
    }

    /**
     * Called when a test is skipped.
     *
     * @param result the result of the test method that was skipped
     */
    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " SKIPPED");
        ExtentReporterUtility.getTest().log(Status.WARNING, result.getMethod().getMethodName() + " SKIPPED");
    }

    /**
     * Called before any tests in the suite are run.
     *
     * @param context the test context
     */
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        ExtentReporterUtility.setupSparkReporter("report.html");
    }

    /**
     * Called after all tests in the suite have run.
     *
     * @param context the test context
     */
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        ExtentReporterUtility.flushReport();
    }
}