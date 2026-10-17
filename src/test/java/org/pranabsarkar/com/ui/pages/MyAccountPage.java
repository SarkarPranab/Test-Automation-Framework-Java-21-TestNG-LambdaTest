package org.pranabsarkar.com.ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.pranabsarkar.com.utility.BrowserUtility;

/**
 * Page Object Model for the My Account Page.
 *
 * <p>This class provides methods to interact with the My Account page elements,
 * such as retrieving the username, searching for products, and navigating to the address page.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class MyAccountPage extends BrowserUtility {

    /**
     * Locator for the username element.
     */
    private static final String USER_NAME_LOCATOR = "//a[@title='View my customer account']";

    /**
     * Locator for the product search bar at the top of the page.
     */
    private static final String PRODUCT_SEARCH_BAR_TOP = "//input[@id='search_query_top']";

    /**
     * Locator for the "Add New Address" link.
     */
    private static final String ADD_NEW_ADDRESS_LINK_LOCATOR = "//a[@title='Add my first address']";

    /**
     * Constructor for the MyAccountPage class.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Retrieves the visible username from the My Account page.
     *
     * @return the username text
     */
    public String getUserName() {
        return getVisibleText(USER_NAME_LOCATOR);
    }

    /**
     * Searches for a product using the top search bar.
     *
     * @param productName the name of the product to search for
     * @return an instance of the SearchResultPage class
     */
    public SearchResultPage searchProductOnTopSearchBar(String productName) {
        enterText(PRODUCT_SEARCH_BAR_TOP, productName);
        enterSpecialKey(PRODUCT_SEARCH_BAR_TOP, Keys.ENTER);
        return new SearchResultPage(getDriver());
    }

    /**
     * Navigates to the Address Page by clicking the "Add New Address" link.
     *
     * @return an instance of the AddressPage class
     */
    public AddressPage goToAddressPage() {
        clickOn(ADD_NEW_ADDRESS_LINK_LOCATOR);
        return new AddressPage(getDriver());
    }
}