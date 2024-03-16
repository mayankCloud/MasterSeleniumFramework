package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class Checkout extends BasePage {
    private final By firstName = By.id("billing_first_name");
    private final By lastName = By.id("billing_last_name");
    
    public Checkout(WebDriver driver) {
        super(driver);
    }
}
