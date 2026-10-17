package org.pranabsarkar.com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.pranabsarkar.com.utility.BrowserUtility;

/**
 * Page Object Model for the Shopping Cart Page.
 *
 * <p>This class provides methods to interact with the shopping cart page elements,
 * such as proceeding to the confirm address page.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class ShoppingCartPage extends BrowserUtility {

    /**
     * Locator for the "Proceed to Checkout" button.
     */
    private static final String PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = "//p[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']";

    /**
     * Constructor for the ShoppingCartPage class.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigates to the Confirm Address Page by clicking the "Proceed to Checkout" button.
     *
     * @return an instance of the ConfirmAddressPage class
     */
    public ConfirmAddressPage goToConfirmAddressPage() {
        clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        return new ConfirmAddressPage(getDriver());
    }
}