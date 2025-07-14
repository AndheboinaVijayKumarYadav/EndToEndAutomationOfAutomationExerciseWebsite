package com.vijay.testing.pages;

import com.vijay.testing.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver); // Calls BasePage's constructor and initializes PageFactory
    }

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginBtn;

    // below element are for singup
    @FindBy(xpath = "//h2[contains(text(),'User')]")
    private WebElement newUser;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement newUserNameInputField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement newUserEmailInputField;

    @FindBy(xpath = "//button[text()='Signup']")
    private WebElement signupButton;


    public String newUserText(){
        return getText(newUser);
    }

    public RegisterPage createAccountWithNewUser(String username, String email){

        enterText(newUserNameInputField,username);
        enterText(newUserEmailInputField,email);

        clickElement(signupButton);

        return new RegisterPage(driver);
    }

    public AccountPage loginIntoAccount(String username,String password){

        enterText(emailInputField,username);
        enterText(passwordInputField,password);

        clickElement(loginBtn);

        return new AccountPage(driver);
    }


}
