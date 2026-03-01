import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TC1_SauceDemo {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");   // Incognito mode
        options.addArguments("--start-maximized"); // Maximize window
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        // Create driver with options
        driver = new ChromeDriver(options);
    }

    @Test
    public void testFormFilling() {
        // Navigate to the specified web page
        driver.get("https://www.saucedemo.com/");

        // Perform actions: Fill in the form
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Drop down
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Name (Z to A)");

        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Jason");
        driver.findElement(By.id("postal-code")).sendKeys("123456");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        driver.findElement(By.id("back-to-products")).click();

        //Logout
        //driver.findElement(By.id("react-burger-menu-btn")).click();


        // Assert the title of the page (adjust as needed)
        //assertEquals("Checkout example · Bootstrap v5.3", driver.getTitle());

        // You can add more assertions or actions as required for your test

        // Optional: Add a sleep statement for demonstration purposes
        // Note: Using Thread.sleep in tests is generally discouraged due to its static nature
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
