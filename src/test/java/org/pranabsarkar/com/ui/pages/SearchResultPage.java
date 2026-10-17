package org.pranabsarkar.com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.pranabsarkar.com.utility.BrowserUtility;

import java.util.Arrays;
import java.util.List;

/**
 * Page Object Model for the Search Result Page.
 *
 * <p>This class provides methods to interact with the search result page elements,
 * such as retrieving the title, verifying the presence of search terms in product listings,
 * and navigating to product details.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class SearchResultPage extends BrowserUtility {

    /**
     * Locator for the product listing title.
     */
    private static final String PRODUCT_LISTING_TITLE_LOCATOR = "//span[@class='lighter']";

    /**
     * Locator for the product names in the search result.
     */
    private static final String PRODUCT_LIST_NAMES = "//h5[@itemprop='name']";

    /**
     * Constructor for the SearchResultPage class.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Retrieves the title of the search result page.
     *
     * @return the title text
     */
    public String getTitle() {
        return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    /**
     * Checks if the search term is present in the product list.
     *
     * @param searchTerm the search term to verify
     * @return true if the search term is found in any product name, false otherwise
     */
    public boolean isSearchTermPresentInProductList(String searchTerm) {
        List<String> keywordsList = Arrays.asList(searchTerm.toLowerCase().split("\\s+"));
        List<String> productNamesList = getAllVisibleText(PRODUCT_LIST_NAMES);
        return productNamesList.stream()
                .anyMatch(name -> keywordsList.stream().anyMatch(name.toLowerCase()::contains));
    }

    /**
     * Clicks on the product at the specified index in the search result.
     *
     * @param index the index of the product to click on
     * @return an instance of the ProductDetailsPage class
     */
    public ProductDetailsPage clickOnTheProductAt(int index) {
        clickOn(getAllElements(PRODUCT_LIST_NAMES).get(index).findElement(By.tagName("a")));
        return new ProductDetailsPage(getDriver());
    }
}