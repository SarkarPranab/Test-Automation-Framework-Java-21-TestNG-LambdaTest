package org.pranabsarkar.com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.pranabsarkar.com.utility.BrowserUtility;

/**
 * Page Object Model for the Order Checkout Payment Page.
 *
 * <p>This class provides methods to interact with the payment page elements during the checkout process.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class OrderCheckOutPaymentPage extends BrowserUtility {

    /**
     * Locator for the alert message displayed when a payment option is not available.
     */
    private static final String PAYMENT_OPTION_NOT_AVAILABLE = "//p[contains(@class,'alert-warning')]";

    /**
     * Constructor for the OrderCheckOutPaymentPage class.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public OrderCheckOutPaymentPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Retrieves the alert message displayed when a payment option is not available.
     *
     * @return the alert message text
     */
    public String getPaymentOptionNotAvailableAlert() {
        return getVisibleText(PAYMENT_OPTION_NOT_AVAILABLE);
    }
}