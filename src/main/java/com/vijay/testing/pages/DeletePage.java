package com.vijay.testing.pages;

import com.vijay.testing.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePage extends BasePage {

    public DeletePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    private WebElement deleteMessageField;

    public String getAccDeleteMessage(){
        return getText(deleteMessageField);
    }
}
