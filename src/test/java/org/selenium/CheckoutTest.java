package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void guestCheckout(){
        driver.get("https://askomdch.com");
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(driver.getTitle(),"AskOmDch – Become a Selenium automation expert!");
        StorePage storePage = homePage.clickStoreMenuLink();
        String searchTitle = storePage.enterTextInSearchField("blue")
                .clickSearchButton()
                .clickOnAddToCart()
                .getTitle();
        Assert.assertEquals(searchTitle, "Search results: “blue”");

    }
}
