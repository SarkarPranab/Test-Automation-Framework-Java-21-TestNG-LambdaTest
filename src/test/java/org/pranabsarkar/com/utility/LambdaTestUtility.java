package org.pranabsarkar.com.utility;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.pranabsarkar.com.constants.Env;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class responsible for initializing and managing remote Selenium WebDriver sessions
 * on the LambdaTest cloud grid for cross-browser and parallel testing, leveraging external properties files.
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public class LambdaTestUtility {
    public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
    private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<>();
    private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<>();
    private static final Logger logger = LoggerUtility.getLogger(LambdaTestUtility.class);

    /**
     * Initializes a thread-safe remote WebDriver session connected to LambdaTest
     * using cloud capabilities and credentials retrieved from the environment properties.
     *
     * @param env        The target environment enum (e.g., QA, PROD).
     * @param testName   The name of the test case being executed.
     * @param methodName The name of the test method being executed.
     * @return The active RemoteWebDriver instance bound to the current thread.
     */
    public static WebDriver initializeLambdaTestSession(Env env, String testName, String methodName) {
        try {
            // Fetching configuration and credentials from properties file based on the passed environment
            String ltUser = PropertiesUtil.readProperty(env, "LT_USERNAME");
            String ltAccessKey = PropertiesUtil.readProperty(env, "LT_ACCESS_KEY");
            String browserName = PropertiesUtil.readProperty(env, "LT_BROWSER");
            String browserVersion = PropertiesUtil.readProperty(env, "LT_BROWSER_VERSION");
            String projectName = PropertiesUtil.readProperty(env, "LT_PROJECT");
            String buildName = PropertiesUtil.readProperty(env, "LT_BUILD");

            if (ltUser == null || ltUser.isEmpty()) ltUser = "meweg49506";
            if (ltAccessKey == null || ltAccessKey.isEmpty()) ltAccessKey = "LT_ke5nrLxD4UULDU7qrfozvLoxovzY9JSkUQQJU3coaElKpYB";
            if (browserName == null || browserName.isEmpty()) browserName = "Chrome";
            if (browserVersion == null || browserVersion.isEmpty()) browserVersion = "127";
            if (projectName == null || projectName.isEmpty()) projectName = "JavaTestNGRecShowCase";
            if (buildName == null || buildName.isEmpty()) buildName = "LTLoginTest";

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", browserName);
            capabilities.setCapability("browserVersion", browserVersion);

            Map<String, Object> ltOptions = new HashMap<>();
            ltOptions.put("user", ltUser);
            ltOptions.put("accessKey", ltAccessKey);
            ltOptions.put("build", buildName);
            ltOptions.put("project", projectName);
            ltOptions.put("name", testName != null ? testName : methodName);
            ltOptions.put("selenium_version", "4.0.0");
            ltOptions.put("w3c", true);

            capabilities.setCapability("LT:Options", ltOptions);
            capabilitiesLocal.set(capabilities);

            WebDriver driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
            driverLocal.set(driver);
        } catch (MalformedURLException e) {
            logger.error("Failed to initialize LambdaTest session due to malformed Hub URL.", e);
        } finally {
            return driverLocal.get();
        }
    }

    /**
     * Quits and closes the active LambdaTest remote WebDriver session associated with the current thread.
     */
    public static void quitSession(){
        if(driverLocal.get() != null){
            driverLocal.get().quit();
        }
    }
}