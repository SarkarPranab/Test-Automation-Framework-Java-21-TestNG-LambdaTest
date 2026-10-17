package org.pranabsarkar.com.ui.pojo;

import java.util.Map;

/**
 * Configuration class for managing environment settings.
 *
 * <p>This class represents a configuration structure that holds a map of environments,
 * where each environment is represented by a key-value pair.</p>
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class Config {

    /**
     * A map containing environment configurations.
     * The key represents the environment name, and the value is an instance of the `Enviorment` class.
     */
    private Map<String, Enviorment> environments;

    /**
     * Retrieves the map of environments.
     *
     * @return a map of environment configurations
     */
    public Map<String, Enviorment> getEnvironments() {
        return environments;
    }
}