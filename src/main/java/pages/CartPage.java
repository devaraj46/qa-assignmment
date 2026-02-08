package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.WaitUtils;

/**
 * CartPage represents the shopping cart and checkout-related pages.
 * It provides actions and validations for cart operations,
 * checkout flow, price calculations, and order confirmation.
 */
public class CartPage {

    private static WebDriver driver;
    private static WaitUtils wait;

    /* Cart and checkout locators */
    public By checkoutButton = By.id("checkout");

    public static By checkoutDetailFirstNameField = By.id("first-name");
    public static By checkoutDetailLastNameField  = By.id("last-name");
    public static By checkoutDetailZipCodeField   = By.id("postal-code");
    public static By checkoutContinueButton       = By.id("continue");
    public static By checkoutFinishButton         = By.id("finish");

    public static By successHeader = By.cssSelector("[data-test='complete-header']");
    public static By cartItems     = By.cssSelector("[data-test='inventory-item']");

    private static By cartItemLabel = By.cssSelector(".cart_item_label");
    private static By itemName      = By.cssSelector("[data-test='inventory-item-name']");
    private static By itemDesc      = By.cssSelector("[data-test='inventory-item-desc']");
    private static By itemPrice     = By.cssSelector("[data-test='inventory-item-price']");
    private By itemQuantity         = By.cssSelector(".cart_quantity");

    private By subtotalLabel = By.cssSelector("[data-test='subtotal-label']");
    private By taxLabel      = By.cssSelector("[data-test='tax-label']");
    private By totalLabel    = By.cssSelector("[data-test='total-label']");

    public CartPage(WebDriver driver) {
        CartPage.driver = driver;
        CartPage.wait = new WaitUtils(driver);
    }

    /**
     * Builds a locator for the remove button of a given product.
     */
    public By removeFromCartButton(String productName) {
        return By.cssSelector("[data-test='remove-" + productName + "']");
    }

    /**
     * Checks whether the cart is empty.
     */
    public boolean isCartEmpty() {
        return driver.findElements(cartItems).isEmpty();
    }

    /**
     * Returns the number of items present in the cart.
     */
    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    /**
     * Clicks the checkout button.
     */
    public void clickCheckout(long timeoutInSeconds) {
        wait.waitForClickability(checkoutButton, timeoutInSeconds).click();
    }

    /**
     * Validates that checkout is disabled when the cart is empty.
     */
    public void validateCheckoutDisabledForEmptyCart() {

        boolean isCartEmpty = driver.findElements(cartItems).isEmpty();
        boolean isCheckoutEnabled = driver.findElement(checkoutButton).isEnabled();

        if (isCartEmpty && isCheckoutEnabled) {
            throw new IllegalStateException(
                    "BUG: Checkout button is enabled even though cart is empty"
            );
        }
    }

    /**
     * Verifies that a cart item contains all required UI fields.
     */
    public void verifyCartItemHasAllRequiredFields() {

        WebElement cartItem = driver.findElement(cartItemLabel);

        boolean hasName  = !cartItem.findElements(itemName).isEmpty();
        boolean hasDesc  = !cartItem.findElements(itemDesc).isEmpty();
        boolean hasPrice = !cartItem.findElements(itemPrice).isEmpty();

        if (!hasName || !hasDesc || !hasPrice) {
            throw new IllegalStateException(
                    "Cart item is missing required UI fields " +
                    "[name=" + hasName +
                    ", desc=" + hasDesc +
                    ", price=" + hasPrice + "]"
            );
        }
    }

    /**
     * Checks whether a specific product is present in the cart.
     */
    public boolean isProductInCart(String productName) {

        String formattedName = productName.toLowerCase().replace(" ", "-");
        By productLocator =
                By.cssSelector("[data-test='remove-" + formattedName + "']");

        List<WebElement> elements = driver.findElements(productLocator);
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    /**
     * Removes a specific product from the cart.
     */
    public void removeProductFromCart(String productName, long timeoutInSeconds) {

        String formattedName = productName.toLowerCase().replace(" ", "-");
        By removeButton =
                By.cssSelector("[data-test='remove-" + formattedName + "']");

        wait.waitForClickability(removeButton, timeoutInSeconds).click();
    }

    /**
     * Verifies that a product has been removed from the cart.
     */
    public void verifyProductRemoved(String productName) {

        Assert.assertFalse(
                isProductInCart(productName),
                "Product '" + productName + "' is still present in the cart!"
        );
    }

    /**
     * Verifies whether a product is present or absent in the cart
     * based on expectation.
     */
    public void verifyProductInCart(String productName, boolean shouldExist) {

        boolean isPresent = isProductInCart(productName);
        Assert.assertEquals(
                isPresent,
                shouldExist,
                "Product presence in cart mismatch for '" + productName + "'!"
        );
    }

    /**
     * Fills checkout user details on the checkout information page.
     */
    public void fillCheckoutUserDetails(
            String firstName,
            String lastName,
            String zipCode,
            long timeoutInSeconds) {

        wait.waitForVisibility(checkoutDetailFirstNameField, timeoutInSeconds).clear();
        driver.findElement(checkoutDetailFirstNameField).sendKeys(firstName);

        wait.waitForVisibility(checkoutDetailLastNameField, timeoutInSeconds).clear();
        driver.findElement(checkoutDetailLastNameField).sendKeys(lastName);

        wait.waitForVisibility(checkoutDetailZipCodeField, timeoutInSeconds).clear();
        driver.findElement(checkoutDetailZipCodeField).sendKeys(zipCode);
    }

    /**
     * Clicks the continue button during checkout.
     */
    public void clickContinue(long timeoutInSeconds) {
        wait.waitForClickability(checkoutContinueButton, timeoutInSeconds).click();
    }

    /**
     * Clicks the finish button to complete checkout.
     */
    public void clickFinish(long timeoutInSeconds) {
        wait.waitForClickability(checkoutFinishButton, timeoutInSeconds).click();
    }

    /**
     * Returns the subtotal value displayed on the checkout summary.
     */
    public double getSubtotal() {
        String text = wait.waitForVisibility(subtotalLabel, 5).getText();
        return parseAmount(text);
    }

    /**
     * Returns the tax value displayed on the checkout summary.
     */
    public double getTax() {
        String text = wait.waitForVisibility(taxLabel, 5).getText();
        return parseAmount(text);
    }

    /**
     * Returns the total value displayed on the checkout summary.
     */
    public double getTotal() {
        String text = wait.waitForVisibility(totalLabel, 5).getText();
        return parseAmount(text);
    }

    /**
     * Verifies that checkout was completed successfully.
     */
    public void verifyCheckoutSuccess(long timeoutInSeconds) {

        Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-complete"),
                "Checkout complete URL not loaded"
        );

        String expectedMessage = "Thank you for your order!";
        String actualMessage =
                wait.waitForVisibility(successHeader, timeoutInSeconds).getText();

        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Checkout success message mismatch"
        );
    }

    /**
     * Calculates the subtotal of all items in the cart.
     */
    public double calculateCartSubtotal() {

        wait.waitForVisibility(cartItems, 10);

        List<WebElement> items = driver.findElements(cartItems);
        double subtotal = 0.0;

        for (WebElement item : items) {
            String priceText = item.findElement(itemPrice).getText();
            String qtyText = item.findElement(itemQuantity).getText();
            double price = Double.parseDouble(priceText.replace("$", ""));
            int qty = Integer.parseInt(qtyText);
            subtotal += price * qty;
        }

        return subtotal;
    }

    /**
     * Verifies that the calculated subtotal matches the displayed summary subtotal.
     */
    public void verifySubtotalMatchesSummary() {

        double calculatedSubtotal = calculateCartSubtotal();
        double displayedSubtotal =
                Double.parseDouble(
                        wait.waitForVisibility(subtotalLabel, 5)
                                .getText()
                                .replaceAll("[^0-9.]", "")
                );

        Assert.assertEquals(
                displayedSubtotal,
                calculatedSubtotal,
                0.01,
                "Subtotal mismatch between cart items and summary"
        );
    }

    /**
     * Verifies that subtotal plus tax equals the displayed total.
     */
    public void verifyCartTotal() {

        double subtotal = getSubtotal();
        double tax = getTax();
        double total = getTotal();

        double expectedTotal = subtotal + tax;

        Assert.assertEquals(
                total,
                expectedTotal,
                0.01,
                "Cart total mismatch"
        );
    }

    /**
     * Parses a numeric amount from a currency-formatted string.
     */
    private double parseAmount(String text) {
        return Double.parseDouble(text.replaceAll("[^0-9.]", ""));
    }
}
