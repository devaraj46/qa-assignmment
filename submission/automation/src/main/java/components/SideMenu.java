package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

/**
 * SideMenu represents the application’s side navigation component.
 * It provides actions to open and close the menu, reset the application state,
 * and log out the currently logged-in user.
 */
public class SideMenu {

    private WebDriver driver;
    private WaitUtils wait;

    /* Locators */
    private By menuButton      = By.id("react-burger-menu-btn");
    private By closeMenuButton = By.id("react-burger-cross-btn");
    private By resetAppButton  = By.id("reset_sidebar_link");
    private By logoutButton    = By.id("logout_sidebar_link");

    public SideMenu(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    /**
     * Opens the side navigation menu.
     */
    public void openMenu() {
        wait.waitForClickability(menuButton, 5).click();
    }

    /**
     * Closes the side navigation menu.
     */
    public void closeMenu() {
        wait.waitForClickability(closeMenuButton, 5).click();
    }

    /**
     * Resets the application state by clearing the cart
     * and restoring the inventory to its default state.
     */
    public void resetAppState() {
        openMenu();
        wait.waitForClickability(resetAppButton, 5).click();
        closeMenu();
        System.out.println("App state has been reset.");
    }

    /**
     * Logs the current user out of the application.
     */
    public void logout() {
        openMenu();
        wait.waitForClickability(logoutButton, 5).click();
        System.out.println("User logged out successfully.");
    }
}
