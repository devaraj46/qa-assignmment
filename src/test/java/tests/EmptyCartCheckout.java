package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import constants.AppConstants;

/**
 * This test class validates checkout behavior when the cart is empty.
 * It covers the complete flow starting from user login,
 * adding a product to the cart, removing it, and verifying
 * that checkout is disabled for an empty cart.
 */
public class EmptyCartCheckout extends BaseTest {

    /* Test data */
    private final String username = AppConstants.VALID_USERNAME;
    private final String password = AppConstants.VALID_PASSWORD;
    private final String product  = AppConstants.SAUCE_LABS_BOLT_T_SHIRT;

    /* Wait configuration */
    private final int explWait5Sec = AppConstants.TIMEOUT_5_SECONDS;

    /**
     * Logs in the user and resets the application state
     * to ensure a clean test environment.
     */
    @Test(priority = 1)
    public void userLogin() throws InterruptedException {
        loginPage.login(username, password);
        sideMenu.resetAppState();
    }

    /**
     * Adds a product to the cart, verifies the cart count,
     * and navigates to the cart page.
     */
    @Test(priority = 2, dependsOnMethods = "userLogin")
    public void addingProductToCART() throws InterruptedException {
        inventoryPage.addProductToCart(product, explWait5Sec);
        inventoryPage.verifyCartCount(1, explWait5Sec);
        inventoryPage.navigateToCart(explWait5Sec);
    }

    /**
     * Removes the previously added product from the cart
     * and verifies that the cart is empty.
     */
    @Test(priority = 3, dependsOnMethods = "addingProductToCART")
    public void removingProductFromCart() throws InterruptedException {
        cartPage.removeProductFromCart(product, explWait5Sec);
        cartPage.verifyProductRemoved(product);
    }

    /**
     * Verifies that checkout is disabled when the cart is empty
     * and logs the user out of the application.
     */
    @Test(priority = 4, dependsOnMethods = "removingProductFromCart")
    public void verifyingEmptyCheckout() throws InterruptedException {
        cartPage.validateCheckoutDisabledForEmptyCart();
        sideMenu.logout();
    }
}
