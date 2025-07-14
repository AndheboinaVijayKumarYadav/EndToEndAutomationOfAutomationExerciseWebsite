package com.vijay.testing.base;

import com.vijay.testing.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser) {
        // Initialize browser base on browser value in properties file
        DriverManager.initDriver(browser);

    }

    @AfterMethod
    public void tearDown() {
        // Quit the browser after each test
        DriverManager.down();
    }
}
