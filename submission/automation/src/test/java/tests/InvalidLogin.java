package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.AppConstants;

/**
 * This class contains negative test cases for login functionality.
 * It validates application behavior for empty login attempts
 * and invalid credential scenarios.
 */
public class InvalidLogin extends BaseTest {

    /**
     * Validates that an appropriate error message is shown
     * when the login button is clicked without entering credentials.
     */
    @Test
    public void emptyLoginTest() {

        loginPage.clickLogin();

        System.out.println("Checking Empty Login Case.");
        Assert.assertTrue(loginPage.isLoginErrorDisplayed());
        Assert.assertEquals(
                loginPage.getLoginErrorMessage(),
                AppConstants.EMPTY_LOGIN_ERROR_MSG
        );
    }

    /**
     * Validates that login fails with a valid username
     * and an invalid password and displays the correct error message.
     */
    @Test
    public void invalidCredLogin() {

        loginPage.login(
                AppConstants.VALID_USERNAME,
                AppConstants.INVALID_PASSWORD
        );

        System.out.println("Checking Invalid userID Password Case.");
        Assert.assertTrue(loginPage.isLoginErrorDisplayed());
        Assert.assertTrue(
                loginPage.getLoginErrorMessage()
                        .equals(AppConstants.INVALID_LOGIN_ERROR_MSG)
        );
    }
}
