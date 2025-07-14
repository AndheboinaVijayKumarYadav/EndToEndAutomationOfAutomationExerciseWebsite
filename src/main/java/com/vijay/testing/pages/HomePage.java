package com.vijay.testing.pages;

import com.vijay.testing.base.BasePage;
import com.vijay.testing.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    // Constructor to initialize driver and elements
    public HomePage(WebDriver driver) {
        super(driver); // Calls BasePage's constructor and initializes PageFactory
    }

    // ============================
    // WebElements using PageFactory
    // ============================

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    private WebElement signupLoginButton;

    // to get page title
    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean isSignupLoginDisplayed(){
        return signupLoginButton.isDisplayed();
    }

    public LoginPage navigateToLoginPage(){
        clickElement(signupLoginButton);
        return new LoginPage(DriverManager.getDriver());
    }
}
