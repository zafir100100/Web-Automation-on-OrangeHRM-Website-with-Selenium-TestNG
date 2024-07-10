package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

/**
 * Utility class providing helper methods for common WebDriver operations.
 */
public class Utils {

    /**
     * Waits for a specified WebElement to be clickable within the provided timeout.
     * This method utilizes WebDriverWait to pause the execution until the element is interactable,
     * enhancing test reliability by ensuring elements are ready before proceeding.
     *
     * @param driver The WebDriver instance to use.
     * @param element The WebElement to wait for.
     * @param timeoutInSeconds The maximum time in seconds to wait for the element to become clickable.
     */
    public static void waitForElementClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for a specified WebElement to become invisible on the page within the provided timeout.
     * This can be useful for handling elements that disappear after performing certain actions.
     *
     * @param driver The WebDriver instance to use.
     * @param element The WebElement whose invisibility to wait for.
     * @param timeoutInSeconds The maximum time in seconds to wait for the element to become invisible.
     */
    public static void waitForElementInvisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Scrolls the webpage down to the bottom using JavaScript execution.
     * This method is useful for reaching elements that are not immediately visible or interactable
     * due to their position out of the visible browser window area.
     *
     * @param driver The WebDriver instance that executes the script.
     */
    public static void doScrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    /**
     * Takes a screenshot of the current browser window and saves it to a specified directory.
     * The filename includes the timestamp to avoid overwriting previous screenshots and to aid in tracking issues.
     *
     * @param driver The WebDriver instance to use for taking the screenshot.
     * @throws IOException if there is an error writing the screenshot file to disk.
     */
    public static void takeScreenshot(WebDriver driver) throws IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File destFile = new File(fileWithPath);
        FileUtils.copyFile(screenshotFile, destFile);
    }
}
