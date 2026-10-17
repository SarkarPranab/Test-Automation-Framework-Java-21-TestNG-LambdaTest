package org.pranabsarkar.com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Utility class responsible for managing ExtentReports configuration, Spark reporter initialization,
 * and thread-safe ExtentTest instances for parallel test execution reporting.
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class ExtentReporterUtility {
    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    /**
     * Initializes and attaches the ExtentSparkReporter to the global ExtentReports instance
     * using the specified report file path/name.
     *
     * @param reportName The file name or path where the HTML report will be generated.
     */
    public static void setupSparkReporter(String reportName) {
        ExtentSparkReporter extentSparkRepoter = new ExtentSparkReporter(System.getProperty("user.dir") +"//"+reportName);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkRepoter);
    }

    /**
     * Creates a new ExtentTest tracking instance and binds it to the current thread.
     *
     * @param testName The name of the test to display in the report.
     */
    public static void createExtentTest(String testName){
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
    }

    /**
     * Retrieves the thread-safe ExtentTest instance associated with the current execution thread.
     *
     * @return The active ExtentTest instance.
     */
    public static ExtentTest getTest(){
        return extentTest.get();
    }

    /**
     * Flushes the ExtentReports instance to write and save all test logs and data to the HTML report file.
     */
    public static void flushReport(){
        extentReports.flush();
    }
}