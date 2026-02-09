package constants;

/**
 * AppConstants holds all application-wide constant values.
 * This includes URLs, test data, timeout values, product names,
 * and static messages used across the automation framework.
 * The class is declared final and has a private constructor
 * to prevent instantiation.
 */
public final class AppConstants {

    private AppConstants() {
    }

    /* Application URLs */
    public static final String BASE_URL = "https://www.saucedemo.com/";

    /* User and test data */
    public static final String VALID_USERNAME = "standard_user";
    public static final String VALID_PASSWORD = "secret_sauce";
    public static final String INVALID_PASSWORD = "wrong_pass";
    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Doe";
    public static final String PIN_CODE = "560001";

    /* Timeout values */
    public static final int DEFAULT_WAIT = 10;
    public static final int TIMEOUT_5_SECONDS = 5;
    public static final int TIMEOUT_10_SECONDS = 10;

    /* Product catalog */
    public static final String SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";
    public static final String SAUCE_LABS_BIKE_LIGHT = "Sauce Labs Bike Light";
    public static final String SAUCE_LABS_BOLT_T_SHIRT = "Sauce Labs Bolt T-Shirt";
    public static final String SAUCE_LABS_FLEECE_JACKET = "Sauce Labs Fleece Jacket";
    public static final String SAUCE_LABS_ONESIE = "Sauce Labs Onesie";
    public static final String TEST_ALL_THE_THINGS_T_SHIRT_RED =
            "Test.allTheThings() T-Shirt (Red)";

    /* Page identifiers and messages */
    public static final String INVENTORY_URL_PART = "inventory";
    public static final String EMPTY_LOGIN_ERROR_MSG =
            "Epic sadface: Username is required";
    public static final String INVALID_LOGIN_ERROR_MSG =
            "Epic sadface: Username and password do not match any user in this service";
}
