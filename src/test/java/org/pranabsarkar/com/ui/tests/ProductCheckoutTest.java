package org.pranabsarkar.com.ui.tests;

import org.pranabsarkar.com.ui.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.pranabsarkar.com.constants.Size.*;

/**
 * Test class for verifying the product checkout functionality.
 *
 * <p>This class contains test methods to ensure that a logged-in user can search for a product,
 * select it, and proceed through the checkout process.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class ProductCheckoutTest extends TestBase {
    private static final String SEARCH_TERM = "Printed Summer dresses";
    private SearchResultPage searchResultPage;
    private static final String PAYMENT_OPTION_ALERT_MESSAGE = "No payment modules have been installed.";

    /**
     * Sets up the test environment by logging in a valid user and searching for a product.
     */
    @BeforeMethod(description = "User logs into the application and searches for a product")
    public void setup() {
        searchResultPage = homePage.goToLoginPage()
                .doLoginWith("bokaman@app.com", "zya@afe")
                .searchProductOnTopSearchBar(SEARCH_TERM);
    }

    /**
     * Verifies if the logged-in user can successfully proceed through the checkout process.
     */
    @Test(description = "Verify if the logged in user able to buy a dress.",
            groups = {"e2e", "smoke", "sanity"})
    public void checkoutTest() {
        Assert.assertEquals(searchResultPage.clickOnTheProductAt(3)
                        .changeSize(L)
                        .addProductToCart()
                        .proceedToCheckout()
                        .goToConfirmAddressPage()
                        .goToShipmentPage()
                        .acceptTermsAndCondition()
                        .proceedToPaymentPage()
                        .getPaymentOptionNotAvailableAlert(),
                PAYMENT_OPTION_ALERT_MESSAGE);
    }
}