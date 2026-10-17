package org.pranabsarkar.com.utility;

import com.github.javafaker.Faker;
import org.pranabsarkar.com.ui.pojo.AddressPOJO;

import java.util.Locale;

/**
 * Utility class responsible for generating fake address data and random user details
 * using the JavaFaker library for automated testing scenarios.
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class FakeAddressUtility {

    /**
     * Generates and returns a populated AddressPOJO object containing randomized fake address
     * and contact information based on the US locale.
     *
     * @return A newly created AddressPOJO instance filled with random mock data.
     */
    public static AddressPOJO getFakeAddress() {
        Faker faker = new Faker(Locale.US);
        AddressPOJO addressPOJO = new AddressPOJO(
                faker.company().name(),
                faker.address().buildingNumber(),
                faker.address().streetAddress(),
                faker.address().city(),
                faker.numerify("#####"),
                faker.phoneNumber().cellPhone(),
                faker.phoneNumber().cellPhone(),
                "other",
                "office address",
                faker.address().state()
        );
        return addressPOJO;
    }
}