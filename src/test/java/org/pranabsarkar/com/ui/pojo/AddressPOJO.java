package org.pranabsarkar.com.ui.pojo;


/**
 * Plain Old Java Object (POJO) for Address details.
 *
 * <p>This class represents the structure of an address, including fields such as company name,
 * address lines, city, state, postal code, phone numbers, and additional information.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class AddressPOJO {
    private String company;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postCode;
    private String homePhoneNumber;
    private String mobileNumber;
    private String otherInformation;
    private String addressAlias;
    private String state;

    /**
     * Constructor for the AddressPOJO class.
     *
     * @param company          the company name
     * @param addressLine1     the first line of the address
     * @param addressLine2     the second line of the address
     * @param city             the city name
     * @param postCode         the postal code
     * @param homePhoneNumber  the home phone number
     * @param mobileNumber     the mobile phone number
     * @param otherInformation additional information about the address
     * @param addressAlias     the alias for the address
     * @param state            the state name
     */
    public AddressPOJO(String company, String addressLine1, String addressLine2, String city, String postCode, String homePhoneNumber, String mobileNumber, String otherInformation, String addressAlias, String state) {
        this.company = company;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postCode = postCode;
        this.homePhoneNumber = homePhoneNumber;
        this.mobileNumber = mobileNumber;
        this.otherInformation = otherInformation;
        this.addressAlias = addressAlias;
        this.state = state;
    }

    /**
     * Gets the company name.
     *
     * @return the company name
     */
    public String getCompany() {
        return company;
    }

    /**
     * Gets the first line of the address.
     *
     * @return the first line of the address
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Gets the second line of the address.
     *
     * @return the second line of the address
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Gets the city name.
     *
     * @return the city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the postal code.
     *
     * @return the postal code
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Gets the home phone number.
     *
     * @return the home phone number
     */
    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    /**
     * Gets the mobile phone number.
     *
     * @return the mobile phone number
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Gets additional information about the address.
     *
     * @return additional information about the address
     */
    public String getOtherInformation() {
        return otherInformation;
    }

    /**
     * Gets the alias for the address.
     *
     * @return the alias for the address
     */
    public String getAddressAlias() {
        return addressAlias;
    }

    /**
     * Gets the state name.
     *
     * @return the state name
     */
    public String getState() {
        return state;
    }

    /**
     * Returns a string representation of the AddressPOJO object.
     *
     * @return a string representation of the AddressPOJO object
     */
    @Override
    public String toString() {
        return "AddressPOJO{" +
                "company='" + company + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", otherInformation='" + otherInformation + '\'' +
                ", addressAlias='" + addressAlias + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}