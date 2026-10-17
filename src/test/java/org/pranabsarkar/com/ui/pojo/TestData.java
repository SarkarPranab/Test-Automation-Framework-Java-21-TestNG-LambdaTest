package org.pranabsarkar.com.ui.pojo;

import java.util.List;

/**
 * Represents test data containing a list of users.
 *
 * <p>This class is used to store and manage a collection of user data for testing purposes.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class TestData {

    /**
     * A list of user data.
     */
    private List<User> data;

    /**
     * Retrieves the list of user data.
     *
     * @return a list of users
     */
    public List<User> getData() {
        return data;
    }

    /**
     * Sets the list of user data.
     *
     * @param data the list of users to set
     */
    public void setData(List<User> data) {
        this.data = data;
    }
}