package StepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleStepDef {
    WebDriver driver;

    @Given("I open the Google homepage")
    public void openGoogleHomepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void searchForKeyword(String keyword) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.RETURN);
    }

    @Then("I should see search results")
    public void verifySearchResults() {
        boolean resultsPresent = driver.findElements(By.cssSelector("div.g")).size() > 0;
        assert resultsPresent : "No search results found!";
        driver.quit();
    }
}