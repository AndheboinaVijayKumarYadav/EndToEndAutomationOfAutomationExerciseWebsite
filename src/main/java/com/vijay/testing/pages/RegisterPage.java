package com.vijay.testing.pages;

import com.vijay.testing.base.BasePage;
import com.vijay.testing.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.vijay.testing.utils.DropDownUtility.*;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "days")
    private WebElement dayDropDown;

    @FindBy(id = "months")
    private WebElement monthsDropDown;

    @FindBy(id = "years")
    private WebElement yearsDropDown;

    @FindBy(id = "id_gender1")
    private WebElement mrCheckbox;

    @FindBy(id = "newsletter")
    private WebElement newsLetterCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "address1")
    private WebElement address1Field;

    @FindBy(id = "address2")
    private WebElement address2Field;

    @FindBy(id = "country")
    private WebElement countryDropDown;

    @FindBy(id = "state")
    private WebElement stateField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "zipcode")
    private WebElement zipcodeField;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    private WebElement createAccountButton;



    public AccountPage registeringAccountWithUserDetails(WebDriver driver){

        clickElement(mrCheckbox);

        enterText(passwordInputField, PropertyReader.readKey("user-password"));

        selectByValue(dayDropDown,"6");
        selectByIndex(monthsDropDown,4);
        selectByText(yearsDropDown,"2006");

        clickElement(newsLetterCheckbox);
        enterText(firstNameField,PropertyReader.readKey("first-name"));
        enterText(lastNameField,PropertyReader.readKey("last-name"));
        enterText(companyField,PropertyReader.readKey("user-company"));
        enterText(address1Field,PropertyReader.readKey("user-address"));
        enterText(address2Field,PropertyReader.readKey("user-address"));

        selectByValue(countryDropDown,"Australia");

        enterText(stateField,PropertyReader.readKey("user-state"));
        enterText(cityField,PropertyReader.readKey("user-city"));
        enterText(zipcodeField,PropertyReader.readKey("user-zipcode"));
        enterText(mobileNumberField,PropertyReader.readKey("user-number"));

        clickElement(createAccountButton);

        return new AccountPage(driver);

    }
}
