package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;

import java.time.Duration;

public class CartPage extends BasePage {
    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By proceedToCheckOutButton = By.cssSelector("div[class$='wc-proceed-to-checkout'] a");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public CheckoutPage clickOnCheckoutButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(proceedToCheckOutButton).click();
        return new CheckoutPage(driver);
    }
}
