package com.vijay.testing.driver;

import com.vijay.testing.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    // Logger instance for logging
    public static final Logger logger = LogManager.getLogger(DriverManager.class);

    // ThreadLocal ensures thread-safe WebDriver for parallel execution
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Returns the current thread's driver
    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void initDriver(String browser){

//        String browser = PropertyReader.readKey("browser");

        if(browser == null){
            throw new RuntimeException("Browser type not specified in properties file.");
        }

        WebDriver webDriver = null;

        switch (browser.toLowerCase()){

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
//                edgeOptions.addArguments("--headless");
                webDriver = new EdgeDriver(edgeOptions);
                logger.info("Edge browser initialized");
                break;

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
//                chromeOptions.addArguments("--headless");
                webDriver = new ChromeDriver(chromeOptions);
                logger.info("Chrome browser initialized ");
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                webDriver = new FirefoxDriver(firefoxOptions);
                logger.info("Firefor browser initialized");
                break;

            default:
                logger.error("No valid browser value found, Check data.properties file");


        }

        // Store the WebDriver instance in ThreadLocal

        driver.set(webDriver);

    }

    public static void down(){
        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }

}
