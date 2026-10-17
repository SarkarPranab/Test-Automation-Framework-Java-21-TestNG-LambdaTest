package org.pranabsarkar.com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.pranabsarkar.com.utility.BrowserUtility;

/**
 * Page Object Model for the Shipment Page.
 *
 * <p>This class provides methods to interact with the shipment page elements,
 * such as accepting terms and conditions and proceeding to the payment page.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class ShipmentPage extends BrowserUtility {

    /**
     * Locator for the terms and conditions checkbox.
     */
    private static final String TERMS_CONDITIONS_CHECKBOX_LOCATOR = "//input[@type='checkbox']";

    /**
     * Locator for the "Proceed to Checkout" button on the payment page.
     */
    private static final String PROCEED_TO_CHECKOUT_PAYMENT_PAGE_LOCATOR = "//button[@name='processCarrier']";

    /**
     * Constructor for the ShipmentPage class.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public ShipmentPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Accepts the terms and conditions by clicking the checkbox.
     *
     * @return an instance of the ShipmentPage class
     */
    public ShipmentPage acceptTermsAndCondition() {
        clickOnCheckBox(TERMS_CONDITIONS_CHECKBOX_LOCATOR);
        return new ShipmentPage(getDriver());
    }

    /**
     * Proceeds to the payment page by clicking the "Proceed to Checkout" button.
     *
     * @return an instance of the OrderCheckOutPaymentPage class
     */
    public OrderCheckOutPaymentPage proceedToPaymentPage() {
        clickOn(PROCEED_TO_CHECKOUT_PAYMENT_PAGE_LOCATOR);
        return new OrderCheckOutPaymentPage(getDriver());
    }
}