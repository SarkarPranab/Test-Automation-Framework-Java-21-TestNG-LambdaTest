package org.pranabsarkar.com.ui.tests;

import org.pranabsarkar.com.ui.dataproviders.LoginDataProvider;
import org.pranabsarkar.com.ui.listeners.MyRetryAnalyzer;
import org.pranabsarkar.com.ui.pojo.User;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test class for verifying login functionality with various data providers.
 *
 * <p>This class contains test methods to ensure that valid users can log in to the application
 * using different data sources such as inline data, CSV files, and XLSX files.</p>
 *
 * <p>Each test method uses a specific data provider to supply user credentials and verifies
 * that the login process works as expected.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
@Listeners(org.pranabsarkar.com.ui.listeners.TestListeners.class)
public class LoginTest extends TestBase {

    /**
     * Verifies if a valid user can log in using inline data.
     *
     * @param user The User POJO supplied by the data provider.
     */
    @Test(description = "Verifies if the valid user able to login into the application.",
            groups = {"e2e", "sanity"},
            dataProviderClass = LoginDataProvider.class,
            dataProvider = "LoginTestDataProvider")
    public void LoginTest(User user) {
        Assert.assertEquals(homePage.goToLoginPage()
                        .doLoginWith(user.getEmailAddress(), user.getPassword())
                        .getUserName(),
                "Bokaman Legend");
    }

    /**
     * Verifies if a valid user can log in using data from a CSV file.
     *
     * @param user The User POJO supplied by the data provider.
     */
    @Test(description = "Verifies if the valid user able to login into the application CSV.",
            groups = {"e2e", "sanity"},
            dataProviderClass = LoginDataProvider.class,
            dataProvider = "LoginTestCSVDataProvider")
    @Ignore
    public void LoginCSVTest(User user) {
        Assert.assertEquals(homePage.goToLoginPage()
                        .doLoginWith(user.getEmailAddress(), user.getPassword())
                        .getUserName(),
                "Bokaman Legend");
    }

    /**
     * Verifies if a valid user can log in using data from an XLSX file.
     *
     * @param user The User POJO supplied by the data provider.
     */
    @Test(description = "Verifies if the valid user able to login into the application XLSX.",
            groups = {"e2e", "sanity"},
            dataProviderClass = LoginDataProvider.class,
            dataProvider = "LoginTestXLSXDataProvider",
            retryAnalyzer = MyRetryAnalyzer.class)
    @Ignore
    public void LoginXLSXTest(User user) {
        Assert.assertEquals(homePage.goToLoginPage()
                        .doLoginWith(user.getEmailAddress(), user.getPassword())
                        .getUserName(),
                "Bokaman Legend");
    }
}