package com.vijay.testing.tests;

import com.vijay.testing.base.BaseTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.pages.AccountPage;
import com.vijay.testing.pages.HomePage;
import com.vijay.testing.pages.LoginPage;
import com.vijay.testing.utils.ExcelUtils;
import com.vijay.testing.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTest extends BaseTest {

    public static final Logger logger = LogManager.getLogger(LoginTest.class);


    @DataProvider(name="LoginData")
    public Object[][] getLoginData() throws IOException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";

        //loading the excel with utils class
        ExcelUtils.loadExcel(filePath,"Sheet1");
        // getting the row count
        int rowCount = ExcelUtils.getRowCount();

        // creating a two Dimensional object
        Object[][] data = new Object[rowCount-1][2];

        // looping throw excel
        for (int i = 1; i < rowCount; i++) {
            data[i-1][0] = ExcelUtils.getCellData(i,0);
            data[i-1][1] = ExcelUtils.getCellData(i,1);
        }

        return data;
    }




    @Test(dataProvider = "LoginData")
    public void testUserLogin(String username,String password){
        String url = PropertyReader.readKey("url");

        if(url != null && !url.isEmpty()){
            DriverManager.getDriver().get(url);
        }
        else {
            throw new RuntimeException("Base URL is missing or empty in data.properties");
        }

        // Initialize HomePage object
        HomePage homePage = new HomePage(DriverManager.getDriver());

        //Initialize LoginPage object
        LoginPage loginPage = homePage.navigateToLoginPage();
        logger.info("Navigated to Login page");

        String actualLoginUrl = loginPage.getUrl(DriverManager.getDriver());
        String expectedLoginUrl = PropertyReader.readKey("login-url");
        assertThat(actualLoginUrl).overridingErrorMessage("Actual Login Url is not matching with Expected").isEqualTo(expectedLoginUrl);


        AccountPage accountPage = loginPage.loginIntoAccount(username,password);

    }
}