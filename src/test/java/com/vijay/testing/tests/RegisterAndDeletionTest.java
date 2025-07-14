package com.vijay.testing.tests;

import com.vijay.testing.base.BaseTest;
import com.vijay.testing.driver.DriverManager;
import com.vijay.testing.pages.*;
import com.vijay.testing.utils.PropertyReader;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegisterAndDeletionTest extends BaseTest {

    public static final Logger logger = LogManager.getLogger(RegisterAndDeletionTest.class);

    @Description("Test Case 1: Verification of User Account Registration and Deletion Flow")
    @Test(priority = 1, groups = {"regression","sanity"})
    public void testUserRegistration() {

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

        String actualUserInputText = loginPage.newUserText();
        String expectedUserInputText = PropertyReader.readKey("userInputText");
//        Assert.assertEquals(ActualUserInputText,ExpectedUserInputText,"Actual and Expected User Input Text do not match");
        assertThat(actualUserInputText).overridingErrorMessage("Actual Input Text is not matching with Expected").isEqualTo(expectedUserInputText);


        String userName = PropertyReader.readKey("username");
        String userEmail = PropertyReader.readKey("user-email");

        RegisterPage registerPage = loginPage.createAccountWithNewUser(userName,userEmail);
        logger.info("Navigated to Account Page");

        // verifying the url after navigating to account page
        String actualSignUpUrl = registerPage.getUrl(DriverManager.getDriver());
        String expectedSignUpUrl = PropertyReader.readKey("signUp-url");
        assertThat(actualSignUpUrl).overridingErrorMessage("Actual SignUp Url is not matching with Expected Url").isEqualTo(expectedSignUpUrl);

        AccountPage accountPage = registerPage.registeringAccountWithUserDetails(DriverManager.getDriver());
        logger.info("Navigate to Account Page");

        // verifying the Account creation success message
        String actualSuccessText = accountPage.getAccCreatedMessage();
        String expectedSuccessText = PropertyReader.readKey("accCreatedMessage");
        assertThat(actualSuccessText).overridingErrorMessage("Actual Account success message is not matching with expected").isEqualTo(expectedSuccessText);

        accountPage.clickOnContinue();

        //verifying the logged user is same as given user
        String actualLoginText = accountPage.getUserLoginMessage();
        String expectedLoginText = PropertyReader.readKey("user-loggedIn-text");
        assertThat(actualLoginText).overridingErrorMessage("Actual logged Text is not matching with expected").isEqualTo(expectedLoginText);

        DeletePage deletePage = accountPage.deleteUserAccount(DriverManager.getDriver());
        logger.info("Navigated to Delete Page");

        // verify the success message after deletion
        String actualDeleteText = deletePage.getAccDeleteMessage();
        String expectedDeleteText = PropertyReader.readKey("user-delete-text");
        assertThat(actualDeleteText).overridingErrorMessage("Actual Delete text is not matching with expected").isEqualTo(expectedDeleteText);

    }

}
