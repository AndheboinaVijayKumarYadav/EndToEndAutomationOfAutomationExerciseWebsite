package com.vijay.testing.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    // Logger instance for logging property read operations
    public static final Logger logger =LogManager.getLogger(PropertyReader.class);

    // Path to the properties file inside test resources
    public static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/data.properties";

    // reading the properties from the data.properties file
    public static String readKey(String key){
        Properties p = new Properties();

        try {
            // Load the properties file
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
            p.load(fileInputStream);

            // Fetch the value for the given key
            String value = p.getProperty(key);

            // Log based on result
            if(value == null){
                logger.warn("Key '{}' not found in properties file.", key);
            }
            else {
                logger.info("Successfully read key '{}': {}", key, value);
            }

            return value; // Return the value
        }
        catch(IOException e){

            // Log and rethrow error if file read fails
            logger.error("Error reading properties file: " + FILE_PATH, e);
            throw new RuntimeException("Failed to read property: " + key, e);
        }
    }

}
