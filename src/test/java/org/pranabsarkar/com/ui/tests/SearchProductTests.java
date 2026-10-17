package org.pranabsarkar.com.ui.tests;

import org.pranabsarkar.com.ui.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Test class for verifying the product search functionality.
 *
 * <p>This class contains test methods to ensure that a logged-in user can search for products
 * and verify that the correct search results are displayed.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
@Listeners({org.pranabsarkar.com.ui.listeners.TestListeners.class})
public class SearchProductTests extends TestBase {
    private MyAccountPage myAccountPage;
    private static final String SEARCH_TERM = "Printed Summer Dress";

    /**
     * Sets up the test environment by logging in a valid user.
     */
    @BeforeMethod(description = "Valid user logs into the application.")
    public void setup() {
        this.myAccountPage = homePage.goToLoginPage().doLoginWith("bokaman@app.com", "zya@afe");
    }

    /**
     * Verifies if the logged-in user can search for a product and the correct products are displayed.
     */
    @Test(description = "Verify if the logged in user is able to search for a product search result and correct products are displayed.",
            groups = {"e2e", "smoke", "sanity"})
    public void verifyProductSearchTest() {
        Assert.assertTrue(myAccountPage.searchProductOnTopSearchBar(SEARCH_TERM)
                .isSearchTermPresentInProductList(SEARCH_TERM));
    }
}