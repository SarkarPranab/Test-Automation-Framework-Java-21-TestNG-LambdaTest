package org.pranabsarkar.com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.pranabsarkar.com.utility.BrowserUtility;

/**
 * Page Object Model for the Confirm Address Page.
 *
 * <p>This class provides methods to interact with the confirm address page elements
 * and navigate to the shipment page.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class ConfirmAddressPage extends BrowserUtility {

    /**
     * Locator for the "Proceed to Checkout" button on the confirm address page.
     */
    private static final String PROCEED_TO_CHECKOUT_PROCESS_ADDRESS_LOCATOR = "//button[@name='processAddress']";

    /**
     * Constructor for the ConfirmAddressPage class.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public ConfirmAddressPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigates to the Shipment Page by clicking the "Proceed to Checkout" button.
     *
     * @return a new instance of the ShipmentPage class
     */
    public ShipmentPage goToShipmentPage() {
        clickOn(PROCEED_TO_CHECKOUT_PROCESS_ADDRESS_LOCATOR);
        return new ShipmentPage(getDriver());
    }
}