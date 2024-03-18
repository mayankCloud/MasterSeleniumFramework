package org.selenium.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.selenium.constants.BrowserType;

public class DriverManager {
    WebDriver driver;

    public WebDriver initializeDriver(String browser) {
        browser = System.getProperty("browser", browser);
        switch (BrowserType.valueOf(browser)) {
            case CHROME -> {
                driver = new ChromeDriver();
            }
            case FIREFOX -> {
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalStateException("Invalid browser name:" + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
