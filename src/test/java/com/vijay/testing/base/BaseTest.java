package com.vijay.testing.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.utils.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BaseTest {

    protected WebDriver driver;
    protected static  ExtentReports extent;
    protected static  ExtentTest test;

    @BeforeSuite
    public void setupReport(){
        extent = ExtentReportManager.getReportInstance();
    }

    @AfterSuite
    public void teardownReport(){
        extent.flush();
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser) throws MalformedURLException {
        // Initialize browser base on browser value in properties file
        DriverManager.initDriver(browser);

    }

    @AfterMethod
    public void tearDown() {
        // Quit the browser after each test
        DriverManager.down();
    }
}
