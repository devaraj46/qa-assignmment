package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import constants.AppConstants;

/**
 * This smoke test class validates the end-to-end purchase flow
 * on the Sauce Demo application.
 * It covers user login, adding multiple products to the cart,
 * removing a product, completing checkout, and verifying
 * successful order placement.
 */
public class SmokeSauceDemo extends BaseTest {

    /* Login credentials */
    String username = AppConstants.VALID_USERNAME;
    String password = AppConstants.VALID_PASSWORD;

    /* Product data */
    String product1 = AppConstants.SAUCE_LABS_BACKPACK;
    String product2 = AppConstants.SAUCE_LABS_BIKE_LIGHT;

    /* Wait configuration */
    int explWait5Sec  = AppConstants.TIMEOUT_5_SECONDS;
    int explWait10Sec = AppConstants.TIMEOUT_5_SECONDS;

    /* Checkout user details */
    String checkOutFormUserName = AppConstants.FIRST_NAME;
    String checkOutFormLastName = AppConstants.LAST_NAME;
    String checkOutFormPostel   = AppConstants.PIN_CODE;

    /**
     * Logs in the user and resets the application state
     * to ensure a clean start for the smoke test flow.
     */
    @Test(priority = 1)
    public void userLogin() throws InterruptedException {
        loginPage.login(username, password);
        sideMenu.resetAppState();
    }

    /**
     * Adds multiple products to the cart from the inventory grid,
     * verifies cart count, and navigates to the cart page.
     */
    @Test(priority = 2, dependsOnMethods = "userLogin")
    public void addingProductFromGridView() throws InterruptedException {

        inventoryPage.addProductToCart(product1, explWait5Sec);
        inventoryPage.addProductToCart(product2, explWait5Sec);

        inventoryPage.verifyCartCount(2, explWait5Sec);
        inventoryPage.navigateToCart(explWait5Sec);
    }

    /**
     * Removes one product from the cart
     * and verifies it is no longer present.
     */
    @Test(priority = 3, dependsOnMethods = "addingProductFromGridView")
    public void removingProductFromCart() throws InterruptedException {
        cartPage.removeProductFromCart(product2, explWait5Sec);
        cartPage.verifyProductRemoved(product2);
    }

    /**
     * Completes the checkout process by filling user details,
     * validating cart information, placing the order,
     * and verifying checkout success.
     */
    @Test(priority = 4, dependsOnMethods = "removingProductFromCart")
    public void cartCheckout() throws InterruptedException {

        cartPage.clickCheckout(explWait10Sec);

        cartPage.fillCheckoutUserDetails(
                checkOutFormUserName,
                checkOutFormLastName,
                checkOutFormPostel,
                explWait5Sec
        );

        cartPage.clickContinue(explWait5Sec);
        cartPage.verifyCartItemHasAllRequiredFields();
        cartPage.clickFinish(explWait5Sec);

        cartPage.verifyCheckoutSuccess(5);
        sideMenu.logout();
    }
}
