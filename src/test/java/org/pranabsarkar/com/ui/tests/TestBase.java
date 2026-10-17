package org.pranabsarkar.com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.pranabsarkar.com.constants.Browsers;
import org.pranabsarkar.com.constants.Env;
import org.pranabsarkar.com.ui.pages.HomePage;
import org.pranabsarkar.com.utility.BrowserUtility;
import org.pranabsarkar.com.utility.LambdaTestUtility;
import org.pranabsarkar.com.utility.LoggerUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * Base class for all UI test classes.
 *
 * <p>This class provides common setup and teardown methods for initializing the browser,
 * loading the homepage, and managing test sessions.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class TestBase {
    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLambdaTest = false;

    /**
     * Sets up the test environment by initializing the browser and loading the homepage.
     *
     * @param browser      The browser to use for the test (default: chrome).
     * @param isLambdaTest Whether the test should run on LambdaTest (default: false).
     * @param isHeadless   Whether the browser should run in headless mode (default: false).
     * @param result       The test result object for retrieving the test method name.
     */
    @Parameters({
            "browser", "isLambdaTest", "isHeadless"
    })
    @BeforeMethod(description = "Load the homepage of the website")
    public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,
                      @Optional("false") boolean isHeadless, ITestResult result) {

        this.isLambdaTest = isLambdaTest;
        WebDriver lambdaDriver;
        if (isLambdaTest) {

            lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(Env.QA, "chrome", result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);

        } else {
            // Running the test on local machine!!!
            logger.info("Load the Homepage of the website");
            homePage = new HomePage(Browsers.valueOf("chrome".toUpperCase()), isHeadless);

        }
    }

    /**
     * Returns the browser utility instance for interacting with the browser.
     *
     * @return The browser utility instance.
     */
    public BrowserUtility getInstance() {
        return homePage;
    }

    /**
     * Tears down the test environment by quitting the browser session.
     */
    @AfterMethod(description = "Tear Down the browser")
    public void tearDown() {
        if (isLambdaTest) {
            LambdaTestUtility.quitSession();
        } else {
            homePage.quit();
        }
    }
}