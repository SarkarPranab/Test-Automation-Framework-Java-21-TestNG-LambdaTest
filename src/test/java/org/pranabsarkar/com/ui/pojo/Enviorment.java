package org.pranabsarkar.com.ui.pojo;

/**
 * Represents an environment configuration.
 *
 * <p>This class contains details about an environment, such as the URL and the maximum number of attempts allowed.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class Enviorment {

    /**
     * The URL of the environment.
     */
    private String url;

    /**
     * The maximum number of attempts allowed.
     */
    private int max_number_of_attempts;

    /**
     * Retrieves the URL of the environment.
     *
     * @return the URL of the environment
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL of the environment.
     *
     * @param url the URL to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Retrieves the maximum number of attempts allowed.
     *
     * @return the maximum number of attempts
     */
    public int getMax_number_of_attempts() {
        return max_number_of_attempts;
    }

    /**
     * Sets the maximum number of attempts allowed.
     *
     * @param max_number_of_attempts the maximum number of attempts to set
     */
    public void setMax_number_of_attempts(int max_number_of_attempts) {
        this.max_number_of_attempts = max_number_of_attempts;
    }
}