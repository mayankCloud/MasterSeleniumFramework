package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutPageTest extends BaseTest {
    BillingAddress billingAddress = new BillingAddress();

    @Test
    public void guestCheckout() throws InterruptedException {
        billingAddress.setFirstName("demo")
                .setLastName("user")
                .setAddressLine("Lane 1")
                .setTownOrCity("San Francisco")
                .setZipCode("73001")
                .setEmail("user@test.com");

        HomePage homePage = new HomePage(driver).load();
        Assert.assertEquals(driver.getTitle(), "AskOmDch – Become a Selenium automation expert!");
        StorePage storePage = homePage.clickStoreMenuLink();
        CartPage cartPage = storePage
                .search("blue")
                .clickOnAddToCart()
                .viewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        CheckoutPage checkoutPage = cartPage.clickOnCheckoutButton();
        checkoutPage.setBillingAddress(billingAddress);
        OrderConfirmatioPage orderConfirmatioPage = checkoutPage.clickOnPlaceOrderButton();
        Assert.assertEquals(orderConfirmatioPage.getOrderConfirmationMessage(), "Thank you. Your order has been received.");
    }
}
