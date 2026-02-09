package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * WaitUtils provides reusable explicit wait utilities
 * for synchronizing Selenium interactions with the UI.
 * It supports default and custom timeout-based waits
 * for common element conditions.
 */
public class WaitUtils {

    private WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns a WebDriverWait instance with the default timeout.
     */
    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Returns a WebDriverWait instance with a custom timeout.
     */
    private WebDriverWait getWait(long timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    /**
     * Waits until the element located by the given locator is visible
     * using the default timeout.
     */
    public WebElement waitForVisibility(By locator) {
        return getWait().until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    /**
     * Waits until the element located by the given locator is visible
     * using a custom timeout.
     */
    public WebElement waitForVisibility(By locator, long timeoutInSeconds) {
        return getWait(timeoutInSeconds).until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    /**
     * Waits until the element located by the given locator is clickable
     * using the default timeout.
     */
    public WebElement waitForClickability(By locator) {
        return getWait().until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    /**
     * Waits until the element located by the given locator is clickable
     * using a custom timeout.
     */
    public WebElement waitForClickability(By locator, long timeoutInSeconds) {
        return getWait(timeoutInSeconds).until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    /**
     * Waits until the element located by the given locator is present in the DOM
     * using the default timeout.
     */
    public WebElement waitForPresence(By locator) {
        return getWait().until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
    }

    /**
     * Waits until the element located by the given locator is present in the DOM
     * using a custom timeout.
     */
    public WebElement waitForPresence(By locator, long timeoutInSeconds) {
        return getWait(timeoutInSeconds).until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
    }

    /**
     * Waits until the specified text is present in the element
     * located by the given locator.
     */
    public boolean waitForText(By locator, String text, long timeoutInSeconds) {
        return getWait(timeoutInSeconds).until(
                ExpectedConditions.textToBePresentInElementLocated(locator, text)
        );
    }
}
