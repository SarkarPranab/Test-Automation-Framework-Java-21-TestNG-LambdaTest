package org.pranabsarkar.com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.pranabsarkar.com.constants.Size;
import org.pranabsarkar.com.utility.BrowserUtility;

/**
 * Page Object Model for the Product Details Page.
 *
 * <p>This class provides methods to interact with the product details page elements,
 * such as changing the product size, adding the product to the cart, and proceeding to checkout.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class ProductDetailsPage extends BrowserUtility {

    /**
     * Locator for the size drop-down menu.
     */
    private static final String SIZE_DROP_DOWN_LOCATOR = "//select[@id='group_1']";

    /**
     * Locator for the "Add to Cart" button.
     */
    private static final String ADD_TO_CART_BUTTON_LOCATOR = "//button/span[contains(text(),'Add to cart')]";

    /**
     * Locator for the "Proceed to Checkout" button.
     */
    private static final String PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = "//a[@title='Proceed to checkout']";

    /**
     * Constructor for the ProductDetailsPage class.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Changes the product size using the size drop-down menu.
     *
     * @param size the size to select
     * @return an instance of the ProductDetailsPage class
     */
    public ProductDetailsPage changeSize(Size size) {
        selectFromDropDown(SIZE_DROP_DOWN_LOCATOR, size.toString());
        return new ProductDetailsPage(getDriver());
    }

    /**
     * Adds the product to the shopping cart.
     *
     * @return an instance of the ProductDetailsPage class
     */
    public ProductDetailsPage addProductToCart() {
        clickOn(ADD_TO_CART_BUTTON_LOCATOR);
        return new ProductDetailsPage(getDriver());
    }

    /**
     * Proceeds to the checkout page.
     *
     * @return an instance of the ShoppingCartPage class
     */
    public ShoppingCartPage proceedToCheckout() {
        clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        return new ShoppingCartPage(getDriver());
    }
}
