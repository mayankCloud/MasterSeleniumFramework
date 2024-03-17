package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

import java.time.Duration;

public class CheckoutPage extends BasePage {
    private final By firstNameTextField = By.id("billing_first_name");
    private final By lastNameTextField = By.id("billing_last_name");
    private final By country = By.id("select2-billing_country-container");
    private final By streetAddressTextField = By.id("billing_address_1");
    private final By cityTextField = By.id("billing_city");
    private final By state = By.id("select2-billing_state-container");
    private final By zipCodeTextField = By.id("billing_postcode");
    private final By emailTextField = By.id("billing_email");
    private final By placeOrderButton = By.id("place_order");
    private final By overlayLoading = By.cssSelector("div[class='blockUI blockOverlay']");
    
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public CheckoutPage enterFirstName(String firstName){
        driver.findElement(firstNameTextField).sendKeys(firstName);
        return this;
    }
    public CheckoutPage enterLastName(String lastName){
        driver.findElement(lastNameTextField).sendKeys(lastName);
        return this;
    }
    public CheckoutPage selectCountry(String countryName){
        driver.findElement(country).click();
        String countryList = String.format("//li[text()='%s']",countryName);
        driver.findElement(By.xpath(countryList)).click();
        return this;
    }
    public CheckoutPage enterStreetAddress(String addressLine1) {
        driver.findElement(streetAddressTextField).sendKeys(addressLine1);
        return this;
    }
    public CheckoutPage enterTownOrCity(String townOrCityName){
        driver.findElement(cityTextField).sendKeys(townOrCityName);
        return this;
    }
    public CheckoutPage selectState(String stateName){
        driver.findElement(state).click();
        String nameOfState = String.format("//li[text()='%s']",stateName);
        driver.findElement(By.xpath(nameOfState)).click();
        return this;
    }
    public CheckoutPage enterZipCode(String zipCode){
        driver.findElement(zipCodeTextField).sendKeys(zipCode);
        return this;
    }
    public OrderConfirmatioPage clickOnPlaceOrderButton(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLoading));
        driver.findElement(placeOrderButton).click();
        return new OrderConfirmatioPage(driver);
    }
    public CheckoutPage enterEmail(String email){
        driver.findElement(emailTextField).sendKeys(email);
        return this;
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress){
        return enterFirstName(billingAddress.getFirstName())
                .enterLastName(billingAddress.getLastName())
                .enterStreetAddress(billingAddress.getAddressLine())
                .enterTownOrCity(billingAddress.getTownOrCity())
                .enterZipCode(billingAddress.getZipCode())
                .enterEmail(billingAddress.getEmail());
    }
}
