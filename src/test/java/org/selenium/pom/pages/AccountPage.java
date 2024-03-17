package org.selenium.pom.pages;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }
    private final By usernameInputField = By.id("username");
    private final By passwordInputField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit'][name='login']");
    private final By storeMenuLink = By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");

    public AccountPage enterUserName(String username){
        driver.findElement(usernameInputField).clear();
        driver.findElement(usernameInputField).sendKeys(username);
        return this;
    }
    public AccountPage enterPasswordAndClickLogin(String password){
        driver.findElement(passwordInputField).clear();
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginButton).click();
        return this;
    }
    public AccountPage login(String username, String password){
        enterUserName(username)
                .enterPasswordAndClickLogin(password);
        return this;
    }
    public StorePage clickStoreMenuLink() {
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }
}
