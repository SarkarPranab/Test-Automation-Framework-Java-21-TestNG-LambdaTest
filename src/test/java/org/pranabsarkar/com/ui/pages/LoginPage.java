package org.pranabsarkar.com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.pranabsarkar.com.utility.BrowserUtility;

/**
 * Page Object Model for the Login Page.
 *
 * <p>This class provides methods to interact with the login page elements and perform login actions.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class LoginPage extends BrowserUtility {

    /**
     * Locator for the email text box.
     */
    private static final String EMAIL_TEXT_BOX_LOCATOR = "//input[@id='email']";

    /**
     * Locator for the password text box.
     */
    private static final String PASSWORD_TEXT_BOX_LOCATOR = "//input[@id='passwd']";

    /**
     * Locator for the submit button.
     */
    private static final String SUBMIT_BUTTON_LOCATOR = "//button[@id='SubmitLogin']";

    /**
     * Locator for the alert message displayed after a failed login attempt.
     */
    private static final String ALERT_FOR_FAILED_LOGIN = "//div[contains(@class,'alert alert-danger')]/ol/li";

    /**
     * Constructor for the LoginPage class.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Logs in with the provided email address and password.
     *
     * @param emailAddress the email address to use for login
     * @param password the password to use for login
     * @return an instance of the MyAccountPage class
     */
    public MyAccountPage doLoginWith(String emailAddress, String password) {
        enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
        enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
        clickOn(SUBMIT_BUTTON_LOCATOR);
        return new MyAccountPage(getDriver());
    }

    /**
     * Attempts to log in with invalid credentials.
     *
     * @param emailAddress the email address to use for login
     * @param password the password to use for login
     * @return an instance of the LoginPage class
     */
    public LoginPage loginWithInvalidCredentials(String emailAddress, String password) {
        enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
        enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
        clickOn(SUBMIT_BUTTON_LOCATOR);
        return new LoginPage(getDriver());
    }

    /**
     * Retrieves the error message displayed after a failed login attempt.
     *
     * @return the error message text
     */
    public String getErrorMessage() {
        return getVisibleText(ALERT_FOR_FAILED_LOGIN);
    }
}