package org.pranabsarkar.com.utility;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pranabsarkar.com.constants.Browsers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Abstract utility class providing thread-safe browser management, explicit wait configurations,
 * and common Selenium wrapper actions for automation frameworks.
 *
 * <p>Author: Pranab Sarkar</p>
 * <p>LinkedIn: <a href="https://www.linkedin.com/in/pranabsarkar/">https://www.linkedin.com/in/pranabsarkar/</a></p>
 * <p>Portfolio: <a href="https://pranabsarkar.vercel.app/">https://pranabsarkar.vercel.app/</a></p>
 *
 * @since 2026-10-17
 */
public abstract class BrowserUtility {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private WebDriverWait wait;
    private Logger logger = LoggerUtility.getLogger(this.getClass());

    /**
     * Initializes the BrowserUtility with an existing WebDriver instance.
     *
     * @param driver The existing WebDriver instance to associate with the current thread.
     */
    public BrowserUtility(WebDriver driver) {
        super();
        this.driver.set(driver);
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    /**
     * Captures a screenshot of the current browser view and saves it to the local directory.
     *
     * @param name The descriptive name to include in the screenshot filename.
     * @return The file path where the screenshot was successfully saved.
     */
    public String takeScreenShot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();

        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
        String path = "./screenshots/" + name + " - " + timeStamp + ".png";
        File screenshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, screenshotFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    /**
     * Initializes the browser driver based on a string browser name.
     *
     * @param browserName The name of the browser to launch (e.g., "chrome", "edge").
     */
    public BrowserUtility(String browserName) {
        logger.info("Launching browser " + browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
        } else {
            logger.error("Invalid browser option given : " + browserName + " please choose chrome or edge");
        }
    }

    /**
     * Initializes the browser driver using the predefined Browsers enum.
     *
     * @param browserName The Browsers enum constant (CHROME, EDGE, FIREFOX).
     */
    public BrowserUtility(Browsers browserName) {
        logger.info("Launching Browser for " + browserName);

        if (browserName == Browsers.CHROME) {
            driver.set(new ChromeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else if (browserName == Browsers.EDGE) {
            driver.set(new EdgeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else if (browserName == Browsers.FIREFOX) {
            driver.set(new FirefoxDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        }
    }

    /**
     * Initializes the browser driver using the Browsers enum with an option for headless execution.
     *
     * @param browserName The Browsers enum constant.
     * @param isHeadless  True to launch the browser in headless mode, false otherwise.
     */
    public BrowserUtility(Browsers browserName, boolean isHeadless) {
        logger.info("Launching Browser for " + browserName);

        if (browserName == Browsers.CHROME) {
            if (isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=old");
                options.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else {
                driver.set(new ChromeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        } else if (browserName == Browsers.EDGE) {
            if (isHeadless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=old");
                options.addArguments("disable-gpu");
                driver.set(new EdgeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else {
                driver.set(new EdgeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        } else if (browserName == Browsers.FIREFOX) {
            if (isHeadless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless=old");
                driver.set(new FirefoxDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else {
                driver.set(new FirefoxDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        }
    }

    /**
     * Navigates the browser to the specified URL.
     *
     * @param url The destination web address string.
     */
    public void goToWebSite(String url) {
        logger.info("Visiting the website " + url);
        driver.get().get(url);
    }

    /**
     * Maximizes the current browser window.
     */
    public void maximizeWindow() {
        logger.info("Maximizing browser window");
        driver.get().manage().window().maximize();
    }

    /**
     * Waits for an element matching the locator to be clickable and performs a click.
     *
     * @param locator The XPath locator string for the element.
     */
    public void clickOn(String locator) {
        logger.info("Finding element with the locator " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(driver.get().findElement(By.xpath(locator)))).click();
        logger.info("Element Found and now performing click " + locator);
    }

    /**
     * Waits for the provided WebElement to be clickable and performs a click.
     *
     * @param element The WebElement instance to click.
     */
    public void clickOn(WebElement element) {
        logger.info("Finding element with the locator and performing click" + element.getText());
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Waits for the element matching the locator to be visible and enters the specified text.
     *
     * @param locator     The XPath locator string for the input field.
     * @param textToEnter The text string to type into the input field.
     */
    public void enterText(String locator, String textToEnter) {
        logger.info("Finding element with the locator " + locator);
        By element = By.xpath(locator);
        logger.info("Element Found and now entering text " + textToEnter);
        wait.until(ExpectedConditions.visibilityOf(driver.get().findElement(element))).sendKeys(textToEnter);
    }

    /**
     * Waits for the element matching the locator to be visible and sends a special keyboard key.
     *
     * @param locator    The XPath locator string for the element.
     * @param keyToEnter The Keys enum value to dispatch (e.g., Keys.ENTER).
     */
    public void enterSpecialKey(String locator, Keys keyToEnter) {
        logger.info("Finding element with the locator " + locator);
        WebElement element = driver.get().findElement(By.xpath(locator));
        logger.info("Element Found and now entering special key " + keyToEnter);
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(keyToEnter);
    }

    /**
     * Retrieves the thread-safe WebDriver instance currently in use.
     *
     * @return The active WebDriver instance.
     */
    public WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Waits for the element located by XPath to be visible and returns its inner text.
     *
     * @param locator The XPath locator string for the element.
     * @return The visible text content of the element.
     */
    public String getVisibleText(String locator) {
        logger.info("Finding element with the locator " + locator);
        WebElement element = driver.get().findElement(By.xpath(locator));
        logger.info("Element Found and now returning the text value " + element.getText());
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    /**
     * Waits for the provided WebElement to be visible and returns its inner text.
     *
     * @param locator The WebElement instance.
     * @return The visible text content of the element.
     */
    public String getVisibleText(WebElement locator) {
        logger.info("Element Found and now returning the text value " + locator.getText());
        return wait.until(ExpectedConditions.visibilityOf(locator)).getText();
    }

    /**
     * Finds all elements matching the XPath locator and returns a list of their visible texts.
     *
     * @param locator The XPath locator string for the collection of elements.
     * @return A list of visible text strings from all matched elements.
     */
    public List<String> getAllVisibleText(String locator) {
        logger.info("Finding elements with the locator " + locator);
        List<WebElement> element = driver.get().findElements(By.xpath(locator));
        logger.info("Element found now printing the list.");
        List<String> visibleTextList = new ArrayList<>();
        for (WebElement webElement : element) {
            logger.info("Elements Found and now returning the text value " + getVisibleText(webElement));
            visibleTextList.add(getVisibleText(webElement));
        }
        return visibleTextList;
    }

    /**
     * Selects an option from a dropdown element by visible text, handling both hidden and visible select elements.
     *
     * @param dropDownLocator The XPath locator string for the dropdown element.
     * @param optionToSelect  The exact visible text option to select.
     */
    public void selectFromDropDown(String dropDownLocator, String optionToSelect){
        logger.info("Finding Element with the locator "+ dropDownLocator);
        WebElement element = driver.get().findElement(By.xpath(dropDownLocator));
        if (!element.isDisplayed()) {
            JavascriptExecutor js = (JavascriptExecutor) driver.get();
            js.executeScript(
                    "var select = arguments[0];" +
                            "var targetText = arguments[1];" +
                            "for (var i = 0; i < select.options.length; i++) {" +
                            "    if (select.options[i].text.trim() === targetText.trim()) {" +
                            "        select.selectedIndex = i;" +
                            "        select.options[i].selected = true;" +
                            "        select.dispatchEvent(new Event('change', { bubbles: true }));" +
                            "        select.dispatchEvent(new Event('input', { bubbles: true }));" +
                            "        break;" +
                            "    }" +
                            "}", element, optionToSelect
            );
        } else {
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(optionToSelect);
        }
    }

    /**
     * Clears text from an input field matched by the provided XPath locator.
     *
     * @param textBoxLocator The XPath locator string for the text box.
     */
    public void clearText(String textBoxLocator){
        logger.info("Clearing existing text in Element with the locator "+ textBoxLocator);
        wait.until(ExpectedConditions.elementToBeClickable(driver.get().findElement(By.xpath(textBoxLocator)))).clear();
    }

    /**
     * Retrieves all WebElements matching the given XPath locator after confirming they are interactable.
     *
     * @param locator The XPath locator string.
     * @return A List of WebElements matching the locator.
     */
    public List<WebElement> getAllElements(String locator){
        logger.info("Finding All Elements with the locator"+ locator);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        List<WebElement> elementList = driver.get().findElements(By.xpath(locator));
        logger.info("Elements found and now printing the List of Elements");
        return elementList;
    }

    /**
     * Clicks a checkbox element using JavaScript, safely bypassing visibility or interception limitations.
     *
     * @param locator The XPath locator string for the checkbox.
     */
    public void clickOnCheckBox(String locator){
        logger.info("Finding element with the locator: " + locator);
        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        JavascriptExecutor js = (JavascriptExecutor) driver.get();
        js.executeScript("arguments[0].click();", checkbox);
    }

    /**
     * Quits the current browser session and closes all associated windows.
     */
    public void quit(){
        logger.info("Quitting the browser");
        driver.get().quit();
    }
}