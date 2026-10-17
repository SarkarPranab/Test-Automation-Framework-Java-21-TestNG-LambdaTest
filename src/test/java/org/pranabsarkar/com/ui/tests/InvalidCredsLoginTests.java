package org.pranabsarkar.com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test class for verifying login functionality with invalid credentials.
 *
 * <p>This class contains test methods to ensure that users attempting to log in with invalid credentials
 * receive the appropriate error message.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
@Listeners(org.pranabsarkar.com.ui.listeners.TestListeners.class)
public class InvalidCredsLoginTests extends TestBase {

    /**
     * Verifies if an invalid user receives the proper error message when attempting to log in.
     */
    @Test(description = "Verifies if the invalid user gets the proper error message.",
            groups = {"e2e", "sanity", "smoke"})
    public void LoginTest() {
        String actualErrorMessage = homePage.goToLoginPage()
                .loginWithInvalidCredentials("invalid.login@test.com", "invalidPass@test")
                .getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Authentication failed.", "Error message mismatch!");
    }
}