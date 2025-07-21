package com.vijay.testing.utils;

import com.vijay.testing.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {


    // This method captures a screenshot and returns the file path
    public static String captureScreenshot(String screenshotName){
        // Get current thread-safe WebDriver
        WebDriver driver = DriverManager.getDriver();

        if(driver == null){
            throw new RuntimeException("WebDriver instance is null! Cannot take screenshot.");
        }
        // Capture screenshot as a File
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Build Destination Path with timestamp for uniqueness
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destPath = System.getProperty("user.dir")+ "/screenshots/" + screenshotName +".png";

        File destFile = new File(destPath);

        try {
            FileUtils.copyFile(srcFile,destFile);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to save screenshot: " + e.getMessage());
        }

        return destPath;
    }
}
