
package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Addresses{
    WebDriver driver;

    @Given("the user is on the Home page")
    public void the_user_is_on_home_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com");
    }

    @When("the user clicks the login link")
    public void the_user_clicks_the_login_link() {
        driver.findElement(By.className("ico-login")).click();
    }

    @When("the user provides the valid credentials")
    public void the_user_provides_the_valid_credentials(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        String email = credentials.get(0).get("Email");
        String password = credentials.get(0).get("Password");

        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        driver.findElement(By.cssSelector("input.button-1.login-button")).click();
    }

    @Then("the user should be successfully logged in")
    public void the_user_should_be_successfully_logged_in() {
        WebElement logoutLink = driver.findElement(By.className("ico-logout"));
        Assert.assertTrue("Login Failed!", logoutLink.isDisplayed());
    }

    @When("the user clicks their email address")
    public void the_user_clicks_their_email_address() {
        driver.findElement(By.className("account")).click();
    }

    @When("the user clicks the addresses link")
    public void the_user_clicks_the_addresses_link() {
        driver.findElement(By.linkText("Addresses")).click();
    }

    @When("the user clicks the Add new")
    public void the_user_clicks_the_add_new() {
        driver.findElement(By.cssSelector("input.button-1.add-address-button")).click();
    }

    @When("the user fills in the address details:")
    public void the_user_fills_in_the_address_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        
        driver.findElement(By.id("Address_FirstName")).clear();
        driver.findElement(By.id("Address_FirstName")).sendKeys(data.get("FirstName"));
        
        driver.findElement(By.id("Address_LastName")).clear();
        driver.findElement(By.id("Address_LastName")).sendKeys(data.get("LastName"));

        driver.findElement(By.id("Address_Email")).clear();
        driver.findElement(By.id("Address_Email")).sendKeys(data.get("Email"));

        driver.findElement(By.id("Address_Company")).clear();
        driver.findElement(By.id("Address_Company")).sendKeys(data.get("Company"));

        driver.findElement(By.id("Address_CountryId")).sendKeys(data.get("Country"));
        driver.findElement(By.id("Address_StateProvinceId")).sendKeys(data.get("State"));
        driver.findElement(By.id("Address_City")).sendKeys(data.get("City"));

        driver.findElement(By.id("Address_Address1")).sendKeys(data.get("Address1"));
        driver.findElement(By.id("Address_Address2")).sendKeys(data.get("Address2"));
        driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(data.get("Zip"));
        driver.findElement(By.id("Address_PhoneNumber")).sendKeys(data.get("Phone number"));
        driver.findElement(By.id("Address_FaxNumber")).sendKeys(data.get("Fax number"));
    }

    @When("the user clicks the save button")
    public void the_user_clicks_the_save_button() {
        driver.findElement(By.cssSelector("input.button-1.save-address-button")).click();
    }

    @Then("the details should be saved successfully")
    public void the_details_should_be_saved_successfully() {
        WebElement successMessage = driver.findElement(By.xpath("//h1[text()=\"My account - Addresses\"]"));
        Assert.assertTrue("Address not saved!", successMessage.getText().contains("My account - Addresses"));
        driver.quit();
}
    }


