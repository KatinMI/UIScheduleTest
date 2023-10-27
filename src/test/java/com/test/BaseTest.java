package com.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Base test class
 */
public class BaseTest {
    protected static WebDriver driver;
    @BeforeAll
    public static void  setUp(){
        System.setProperty("webdriver.edge.driver", "C:/javastudy/msedgedriver.exe");
        driver= new EdgeDriver();
        driver.manage().window().maximize();
        Configuration.headless = false;
        BasePage.setDriver(driver);
    }
    @AfterAll
    public static void tearDown(){
        driver.close();
        driver.quit();
    }
}
