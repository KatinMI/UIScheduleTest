package com.test;

import org.openqa.selenium.WebDriver;

/**
 * Base page class
 */
public class BasePage {
    protected static WebDriver driver;
    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
    }
}
