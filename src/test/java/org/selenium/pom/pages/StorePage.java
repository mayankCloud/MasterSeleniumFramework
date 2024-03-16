package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {
    private final By searchField = By.cssSelector("#woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("button[type='submit'][value='Search']");
    private final By searchTitle = By.cssSelector("h1[class='woocommerce-products-header__title page-title']");
    private final By addBlueShoeToCart = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    private final By cartIcon = By.cssSelector(".site-primary-header-wrap.ast-builder-grid-row-container.site-header-focus-item.ast-container");
    private final By viewCart = By.cssSelector("div[class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container'] a[class='button wc-forward']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage enterTextInSearchField(String searchItem){
        driver.findElement(searchField).click();
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys("blue");
        return this;
    }
    public StorePage clickSearchButton(){
        driver.findElement(searchButton).click();
        return this;
    }
    public String getTitle(){
        return driver.findElement(searchTitle).getText();
    }
    public StorePage clickOnAddToCart(){
        driver.findElement(addBlueShoeToCart).click();
        return this;
    }
}
