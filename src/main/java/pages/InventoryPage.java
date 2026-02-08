package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.WaitUtils;

/**
 * InventoryPage represents the product listing and product detail
 * interactions within the application.
 * It provides actions for adding products to the cart,
 * navigating to product detail pages, and validating cart count.
 */
public class InventoryPage {

    private WebDriver driver;
    private WaitUtils wait;

    /* Cart-related locators */
    private By cartCount = By.cssSelector("[data-test='shopping-cart-badge']");
    private By cartIcon  = By.cssSelector("[data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    /**
     * Builds a dynamic locator for the add-to-cart button
     * based on the product name.
     */
    public By addToCartButtonByProductName(String productName) {
        return By.xpath(
                String.format(
                        "//div[@data-test='inventory-item-name' and normalize-space()='%s']" +
                        "/ancestor::div[contains(@class,'inventory_item')]" +
                        "//button[starts-with(@data-test,'add-to-cart')]",
                        productName
                )
        );
    }

    /**
     * Converts a product name into a CSS-friendly format.
     */
    private String formatProductName(String productName) {
        return productName.toLowerCase().replace(" ", "-");
    }

    /**
     * Returns the add-to-cart button locator using a CSS selector.
     */
    private By addToCartButton(String productName) {
        String formattedName = formatProductName(productName);
        return By.cssSelector("[data-test='add-to-cart-" + formattedName + "']");
    }

    /**
     * Returns a locator for an inventory item based on its name.
     */
    private By inventoryItemByName(String productName) {
        return By.xpath(
                String.format(
                        "//div[@data-test='inventory-item-name' and normalize-space()='%s']",
                        productName
                )
        );
    }

    /**
     * Adds a product to the cart from the inventory grid view.
     */
    public void addProductToCart(String productName, long timeoutInSeconds) {
        wait.waitForClickability(addToCartButton(productName), timeoutInSeconds)
            .click();
    }

    /**
     * Clicks on an inventory item to navigate to its detail page.
     */
    public void clickInventoryItem(String productName, long timeoutInSeconds) {
        wait.waitForClickability(inventoryItemByName(productName), timeoutInSeconds)
            .click();
    }

    /**
     * Adds a product to the cart from the product detail page.
     */
    public void addToCartFromDetailPage(String productName, long timeoutInSeconds) {
        new WaitUtils(driver)
                .waitForClickability(
                        addToCartButtonByProductName(productName),
                        timeoutInSeconds
                )
                .click();
    }

    /**
     * Navigates to the cart page.
     */
    public void navigateToCart(long timeoutInSeconds) {
        wait.waitForClickability(cartIcon, timeoutInSeconds)
            .click();
    }

    /**
     * Verifies that the cart badge count matches the expected value.
     */
    public void verifyCartCount(int expectedCount, long timeoutInSeconds) {
        String actualCount =
                wait.waitForVisibility(cartCount, timeoutInSeconds).getText();

        Assert.assertEquals(
                Integer.parseInt(actualCount),
                expectedCount,
                "Cart count mismatch"
        );
    }
}
