package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import constants.AppConstants;

/**
 * This test class validates the product detail page flow.
 * It covers user login, adding a product to the cart from
 * the product details page, completing the checkout process,
 * and verifying final cart values and order confirmation.
 */
public class ProductDetail extends BaseTest {

    /* Test data */
    private final String username = AppConstants.VALID_USERNAME;
    private final String password = AppConstants.VALID_PASSWORD;
    private final String product  = AppConstants.SAUCE_LABS_BOLT_T_SHIRT;

    /* Wait configuration */
    private final int explWait5Sec  = AppConstants.TIMEOUT_5_SECONDS;
    private final int explWait10Sec = AppConstants.TIMEOUT_10_SECONDS;

    /* Checkout user details */
    private final String firstName  = AppConstants.FIRST_NAME;
    private final String lastName   = AppConstants.LAST_NAME;
    private final String postalCode = AppConstants.PIN_CODE;

    /**
     * Logs in the user and resets the application state
     * to ensure a clean starting point for the test flow.
     */
    @Test(priority = 1)
    public void userLogin() {
        System.out.println("Logging in user: " + username);
        loginPage.login(username, password);
        sideMenu.resetAppState();
    }

    /**
     * Navigates to the product details page and adds
     * the selected product to the cart.
     */
    @Test(priority = 2, dependsOnMethods = "userLogin")
    public void addingProductToCartFromDetailsPage() {
        System.out.println(
                "Selecting product: " + product + " to add to cart from product details page"
        );

        inventoryPage.clickInventoryItem(product, explWait10Sec);
        inventoryPage.addToCartFromDetailPage(product, explWait5Sec);
        inventoryPage.verifyCartCount(1, explWait5Sec);
    }

    /**
     * Executes the checkout flow by navigating to the cart,
     * verifying cart contents, and submitting checkout details.
     */
    @Test(priority = 3, dependsOnMethods = "addingProductToCartFromDetailsPage")
    public void checkOutFlow() throws InterruptedException {
        System.out.println("Navigating to cart and verifying count.");
        inventoryPage.verifyCartCount(1, explWait5Sec);
        inventoryPage.navigateToCart(explWait5Sec);

        System.out.println("Clicking on checkout.");
        cartPage.verifyProductInCart(product, true);
        cartPage.clickCheckout(explWait5Sec);

        System.out.println("Filling checkout form.");
        cartPage.fillCheckoutUserDetails(
                firstName,
                lastName,
                postalCode,
                explWait5Sec
        );
        cartPage.clickContinue(explWait5Sec);
    }

    /**
     * Verifies cart summary values, completes the order,
     * validates successful checkout, and logs the user out.
     */
    @Test(priority = 4, dependsOnMethods = "checkOutFlow")
    public void verifyingCartValue() throws InterruptedException {

        cartPage.verifyCartItemHasAllRequiredFields();
        cartPage.verifySubtotalMatchesSummary();
        cartPage.verifyCartTotal();

        System.out.println("Subtotal: " + cartPage.getSubtotal());
        System.out.println("Tax: " + cartPage.getTax());
        System.out.println("Total: " + cartPage.getTotal());

        cartPage.clickFinish(explWait5Sec);

        System.out.println("Verifying if order placement was successful.");
        cartPage.verifyCheckoutSuccess(explWait5Sec);
        sideMenu.logout();
    }
}
