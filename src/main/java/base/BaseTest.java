package base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import components.SideMenu;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

/**
 * BaseTest is the parent class for all test classes.
 * It is responsible for WebDriver initialization,
 * browser configuration, application launch,
 * and Page Object setup.
 */
public class BaseTest {

    protected WebDriver driver;

    /* Page objects shared across all test classes */
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage;
    protected SideMenu sideMenu;

    /**
     * Initializes the WebDriver, configures browser options,
     * launches the application, and initializes all page objects
     * before any test methods are executed.
     */
    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");
        options.addArguments("--user-data-dir=/tmp/selenium-profile");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        sideMenu = new SideMenu(driver);
    }

    /**
     * Closes the browser and releases WebDriver resources
     * after all test methods in the class have executed.
     */
    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
