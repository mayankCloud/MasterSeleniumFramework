package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.*;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutPageTest extends BaseTest {
    BillingAddress billingAddress = new BillingAddress();

    @Test
    public void guestCheckout() {
        billingAddress.setFirstName("demo")
                .setLastName("user")
                .setAddressLine("Lane 1")
                .setTownOrCity("San Francisco")
                .setZipCode("73001")
                .setEmail("user@test.com");

        HomePage homePage = new HomePage(getDriver()).load();
        Assert.assertEquals(getDriver().getTitle(), "AskOmDch – Become a Selenium automation expert!");
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

    @Test
    public void guestCheckoutUsingPOJO() throws InterruptedException, IOException {
        BillingAddress billingAddress = JacksonUtils.deSerializeJSON("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);
        HomePage homePage = new HomePage(getDriver()).load();
        Assert.assertEquals(getDriver().getTitle(), "AskOmDch – Become a Selenium automation expert!");
        StorePage storePage = homePage.clickStoreMenuLink();
        CartPage cartPage = storePage
                .search(product.getName())
                .clickOnAddToCart()
                .viewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        CheckoutPage checkoutPage = cartPage.clickOnCheckoutButton();
        checkoutPage.setBillingAddress(billingAddress);
        OrderConfirmatioPage orderConfirmatioPage = checkoutPage.clickOnPlaceOrderButton();
        Assert.assertEquals(orderConfirmatioPage.getOrderConfirmationMessage(), "Thank you. Your order has been received.");
    }

    @Test
    public void loginUserGuestCheckout() throws IOException {
        Product product = new Product(1196);
        BillingAddress billingAddress = JacksonUtils.deSerializeJSON("myBillingAddress.json", BillingAddress.class);
        User user = new User("testuser");


        CartPage cartPage = new HomePage(getDriver())
                .load()
                .navigateToAccountPage()
                .login(user.getUsername(), user.getPassword())
                .clickStoreMenuLink()
                .search(product.getName())
                .clickOnAddToCart()
                .viewCart();
        Assert.assertEquals("Blue Tshirt", product.getName());
        CheckoutPage checkoutPage = cartPage.clickOnCheckoutButton();
        checkoutPage.setBillingAddress(billingAddress);
        OrderConfirmatioPage orderConfirmatioPage = checkoutPage.clickOnPlaceOrderButton();
        Assert.assertEquals(orderConfirmatioPage.getOrderConfirmationMessage(), "Thank you. Your order has been received.");

    }
}
