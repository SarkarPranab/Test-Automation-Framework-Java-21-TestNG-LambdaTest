package org.pranabsarkar.com.ui.tests;

import org.pranabsarkar.com.ui.pages.AddressPage;
import org.pranabsarkar.com.ui.pages.MyAccountPage;
import org.pranabsarkar.com.ui.pojo.AddressPOJO;
import org.pranabsarkar.com.utility.FakeAddressUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * Test class for verifying the functionality of adding a new address.
 *
 * <p>This class contains test methods to ensure that a logged-in user can navigate
 * to the address page and successfully add a new address.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class AddNewAddressTest extends TestBase {
    private MyAccountPage myAccountPage;
    private AddressPage addressPage;
    private AddressPOJO address;

    /**
     * Sets up the test environment by logging in a valid user and generating a fake address.
     */
    @BeforeMethod(description = "Valid first time user logs into the application.")
    public void setup() {
        this.myAccountPage = homePage.goToLoginPage().doLoginWith("bokaman@app.com", "zya@afe");
        this.address = FakeAddressUtility.getFakeAddress();
    }

    /**
     * Verifies if the logged-in user can navigate to the address page and add a new address.
     */
    @Test(description = "Verify if the logged in user is able navigate and add new address in Address info page.",
            groups = {"e2e", "smoke", "sanity"}
    ) // Address can be created once
    @Ignore
    public void addNewAddress() {
        addressPage = myAccountPage.goToAddressPage();
        String savedAlias = addressPage.saveAddress(address);
        Assert.assertEquals(savedAlias, address.getAddressAlias().toUpperCase(), "Address alias mismatch!");
    }
}