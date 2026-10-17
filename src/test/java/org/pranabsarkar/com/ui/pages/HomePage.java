package org.pranabsarkar.com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.pranabsarkar.com.constants.Browsers;
import static org.pranabsarkar.com.constants.Env.QA;
import org.pranabsarkar.com.utility.BrowserUtility;
import org.pranabsarkar.com.utility.JSONUtility;
import org.pranabsarkar.com.utility.LoggerUtility;

/**
 * Page Object Model for the Home Page.
 *
 * <p>This class provides methods to interact with the home page elements and navigate to other pages.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public final class HomePage extends BrowserUtility {
    /**
     * Logger instance for logging messages.
     */
    private final Logger logger = LoggerUtility.getLogger(this.getClass());

    /**
     * Locator for the "Sign In" link on the home page.
     */
    private static final String SIGN_IN_LINK_LOCATOR = "//a[contains(text(),'Sign in')]";

    /**
     * Constructor for the HomePage class using browser and headless mode.
     *
     * @param browser   the browser type to be used
     * @param isHeadless whether the browser should run in headless mode
     */
    public HomePage(Browsers browser, boolean isHeadless) {
        super(browser, isHeadless);
        goToWebSite(JSONUtility.readJSON(QA).getUrl()); // JSON-based extraction
    }

    /**
     * Constructor for the HomePage class using WebDriver.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public HomePage(WebDriver driver) {
        super(driver);
        goToWebSite(JSONUtility.readJSON(QA).getUrl());
    }

    /**
     * Navigates to the Login Page by clicking the "Sign In" link.
     *
     * @return a new instance of the LoginPage class
     */
    public LoginPage goToLoginPage() {
        logger.info("Trying to perform click to go to sign in page");
        clickOn(SIGN_IN_LINK_LOCATOR);
        return new LoginPage(getDriver());
    }
}