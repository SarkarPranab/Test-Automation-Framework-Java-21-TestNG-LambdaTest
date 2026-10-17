package org.pranabsarkar.com.ui.pages;

import org.openqa.selenium.WebDriver;
import org.pranabsarkar.com.ui.pojo.AddressPOJO;
import org.pranabsarkar.com.utility.BrowserUtility;

/**
 * Page Object Model for the Address Page.
 *
 * <p>This class provides methods to interact with the address page elements and perform actions such as
 * saving an address.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class AddressPage extends BrowserUtility {

    /**
     * Locator for the company text box.
     */
    private static final String COMPANY_TEXTBOX_LOCATOR = "//input[@id='company']";

    /**
     * Locator for the address line 1 text box.
     */
    private static final String ADDRESS1_TEXTBOX_LOCATOR = "//input[@id='address1']";

    /**
     * Locator for the address line 2 text box.
     */
    private static final String ADDRESS2_TEXTBOX_LOCATOR = "//input[@id='address2']";

    /**
     * Locator for the city text box.
     */
    private static final String CITY_TEXTBOX_LOCATOR = "//input[@id='city']";

    /**
     * Locator for the state dropdown.
     */
    private static final String STATE_DROPDOWN_LOCATOR = "//select[@id='id_state']";

    /**
     * Locator for the postal code text box.
     */
    private static final String POST_CODE_TEXTBOX_BOX_SELECTOR = "//input[@name='postcode']";

    /**
     * Locator for the country dropdown.
     *
     * <p>This locator is used to identify the dropdown element for selecting a country
     * when filling out the address form.</p>
     *
     * <p>Example usage:</p>
     * <pre>
     * selectFromDropDown(COUNTRY_DROPDOWN_LOCATOR, "United States");
     * </pre>
     */
    private static final String COUNTRY_DROPDOWN_LOCATOR = "//select[@id='id_country']";

    /**
     * Locator for the home phone text box.
     */
    private static final String HOMEPHONE_TEXTBOX_LOCATOR = "//input[@id='phone']";

    /**
     * Locator for the mobile phone text box.
     */
    private static final String MOBILE_TEXTBOX_LOCATOR = "//input[@id='phone_mobile']";

    /**
     * Locator for the address alias text box.
     */
    private static final String ADDRESS_ALIAS_TEXTBOX_LOCATOR = "//input[@id='alias']";

    /**
     * Locator for the save address button.
     */
    private static final String SAVE_ADDRESS_BUTTON_LOCATOR = "//button[@id='submitAddress']";

    /**
     * Locator for the address heading.
     */
    private static final String ADDRESS_HEADING_LOCATOR = "//h3[@class='page-subheading']";

    /**
     * Constructor for the AddressPage class.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public AddressPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Saves the address details provided in the AddressPOJO object.
     *
     * <p>This method fills out the address form using the provided address details
     * and saves the address.</p>
     *
     * @param address the AddressPOJO object containing the address details
     * @return the header text of the newly saved address
     */
    public String saveAddress(AddressPOJO address) {
        enterText(COMPANY_TEXTBOX_LOCATOR, address.getCompany());
        enterText(ADDRESS1_TEXTBOX_LOCATOR, address.getAddressLine1());
        enterText(ADDRESS2_TEXTBOX_LOCATOR, address.getAddressLine2());
        enterText(CITY_TEXTBOX_LOCATOR, address.getCity());
        enterText(POST_CODE_TEXTBOX_BOX_SELECTOR, address.getPostCode());
        enterText(HOMEPHONE_TEXTBOX_LOCATOR, address.getHomePhoneNumber());
        enterText(MOBILE_TEXTBOX_LOCATOR, address.getHomePhoneNumber());
        clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
        enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR, address.getAddressAlias());
//        selectFromDropDown(COUNTRY_DROPDOWN_LOCATOR, address.getCountry());
        selectFromDropDown(STATE_DROPDOWN_LOCATOR, address.getState());
        clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);
        String newAddressHeader = getVisibleText(ADDRESS_HEADING_LOCATOR);
        return newAddressHeader;
    }
}