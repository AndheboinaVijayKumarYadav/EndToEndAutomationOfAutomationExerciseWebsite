package com.vijay.testing.pages;

import com.vijay.testing.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElement accountTextField;

    @FindBy(xpath = "//a[text()='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//a[contains(text(),'Logged')]")
    private WebElement loggedInField;

    @FindBy(xpath = "//a[contains(text(),'Delete')]")
    private WebElement deleteField;

    public String getAccCreatedMessage(){
        return getText(accountTextField);
    }

    public String getUserLoginMessage(){
        return getText(loggedInField);
    }

    public void clickOnContinue(){
        clickElement(continueButton);
    }

    public DeletePage deleteUserAccount(WebDriver driver){
        clickElement(deleteField);

        return new DeletePage(driver);
    }
}
