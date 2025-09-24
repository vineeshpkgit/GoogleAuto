package StepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleStepDef {

    WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless"); // For CI environments
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--user-data-dir=/tmp/profile-" + System.currentTimeMillis());

        driver = new ChromeDriver(options);
    }

    @Given("I open the Google homepage")
    public void openGoogleHomepage() {
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void searchForKeyword(String keyword) {
        driver.findElement(By.name("q")).sendKeys(keyword + Keys.ENTER);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}