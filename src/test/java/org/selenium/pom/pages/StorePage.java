package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;

import java.time.Duration;

public class StorePage extends BasePage {
    private final By searchField = By.cssSelector("#woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("button[type='submit'][value='Search']");
    private final By searchTitle = By.cssSelector("h1[class='woocommerce-products-header__title page-title']");
    private final String searchText = "Blue Shoes";
    private final String addBlueShoeToCart = String.format("//a[@aria-label='Add “%s” to your cart']", searchText);
    private final By cartIcon = By.cssSelector(".site-primary-header-wrap.ast-builder-grid-row-container.site-header-focus-item.ast-container");
    private final By viewYourShoppingCart = By.cssSelector("div#ast-desktop-header div#ast-site-header-cart span.count");
    private final By viewCart = By.cssSelector("div[class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container'] a[class='button wc-forward']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);

    private StorePage enterTextInSearchField(String searchItem) {
        driver.findElement(searchField).click();
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(searchItem);
        return this;
    }

    private StorePage clickSearchButton() {
        driver.findElement(searchButton).click();
        return this;
    }

    public StorePage search(String searchItem) {
        return enterTextInSearchField(searchItem)
                .clickSearchButton();
    }

    public String getTitle() {
        return driver.findElement(searchTitle).getText();
    }

    public StorePage clickOnAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(addBlueShoeToCart))))
                .click();
        return this;
    }

    public CartPage viewCart() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(viewYourShoppingCart));
//        actions.moveToElement(driver.findElement(viewYourShoppingCart)).build().perform();
//        wait.until(ExpectedConditions.elementToBeClickable(viewYourShoppingCart))
//                .click();
        driver.findElement(By.cssSelector("#ast-desktop-header .ast-cart-menu-wrap")).click();
        return new CartPage(driver);
    }
}
