package org.pranabsarkar.com.utility;

import org.pranabsarkar.com.constants.Env;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class responsible for reading environment-specific configuration
 * properties files for the test automation framework.
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class PropertiesUtil {

    /**
     * Reads a specific property value from an environment-specific .properties file
     * located in the config directory.
     *
     * @param env          The target environment enum value (e.g., QA, PROD).
     * @param propertyName The key name of the property to retrieve (automatically converted to uppercase).
     * @return The string value associated with the property key.
     */
    public static String readProperty(Env env, String propertyName) {
        File propFile = new File(System.getProperty("user.dir") + "//config//" + env + ".properties");
        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader(propFile);
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(propertyName.toUpperCase());
    }
}