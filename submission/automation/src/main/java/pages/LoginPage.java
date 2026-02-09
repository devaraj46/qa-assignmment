package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * LoginPage represents the login screen of the application.
 * It provides actions to enter credentials, submit the login form,
 * validate login errors, and perform a complete login flow.
 */
public class LoginPage {

    private WebDriver driver;

    /* Login page locators */
    private By usernameField      = By.id("user-name");
    private By passwordField      = By.id("password");
    private By loginButton        = By.id("login-button");
    private By loginErrorMessage  = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Enters the username into the username field.
     */
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    /**
     * Enters the password into the password field.
     */
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    /**
     * Clicks the login button.
     */
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    /**
     * Checks whether the login error message is displayed.
     */
    public boolean isLoginErrorDisplayed() {
        return driver.findElement(loginErrorMessage).isDisplayed();
    }

    /**
     * Returns the login error message text.
     */
    public String getLoginErrorMessage() {
        return driver.findElement(loginErrorMessage).getText();
    }

    /**
     * Performs a complete login action using provided credentials.
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    /**
     * Handles a login-related alert popup if present.
     */
    public void handleLoginAlert() {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
}
