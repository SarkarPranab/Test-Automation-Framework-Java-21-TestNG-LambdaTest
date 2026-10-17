package org.pranabsarkar.com.utility;

import com.google.gson.Gson;
import org.apache.logging.log4j.Logger;
import org.pranabsarkar.com.constants.Env;
import org.pranabsarkar.com.ui.pojo.Config;
import org.pranabsarkar.com.ui.pojo.Enviorment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Utility class responsible for reading and parsing JSON configuration files
 * using the Gson library to map configuration data to respective Java POJOs.
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class JSONUtility {
    private static final Logger logger = LoggerUtility.getLogger(JSONUtility.class);

    /**
     * Reads the config.json file from the config directory, parses it into a Config object,
     * and returns the specific environment configuration.
     *
     * @param env The target environment enum value to retrieve.
     * @return An Enviorment POJO containing environment-specific configuration details.
     */
    public static Enviorment readJSON(Env env) {
        Gson gson = new Gson();
        File jsonFile = new File(System.getProperty("user.dir") + "//config//config.json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            logger.error("Configuration JSON file not found at path: " + jsonFile.getPath(), e);
        }
        Config config = gson.fromJson(fileReader, Config.class);
        Enviorment environment = config.getEnvironments().get("QA");
        return environment;
    }
}