package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadURL(String endPoint) {
        driver.get("https://www.askomdch.com" + endPoint);
    }
}
