package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
    private final By storeMenuLink = By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");
    private final By accountNavbarLink = By.xpath("//li[@id='menu-item-1237']/a[text()='Account']");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public StorePage clickStoreMenuLink() {
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }
    public HomePage load(){
        loadURL("/");
        return this;
    }
    public AccountPage navigateToAccountPage(){
        driver.findElement(accountNavbarLink).click();
        return new AccountPage(driver);
    }
}


