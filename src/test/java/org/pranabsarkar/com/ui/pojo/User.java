package org.pranabsarkar.com.ui.pojo;

/**
 * Represents a user with an email address and password.
 *
 * <p>This class is used to store and manage user credentials.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class User {

    /**
     * The email address of the user.
     */
    private String emailAddress;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * Constructs a new User with the specified email address and password.
     *
     * @param emailAddress the email address of the user
     * @param password     the password of the user
     */
    public User(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return the email address of the user
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the email address of the user.
     *
     * @param emailAddress the email address to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}