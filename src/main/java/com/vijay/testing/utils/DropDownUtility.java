package com.vijay.testing.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility {

    private static Select findDropDown(WebElement element){

        return new Select(element);
    }


    public static void selectByValue(WebElement element,String value){
        findDropDown(element).selectByValue(value);
    }

    public static void selectByIndex(WebElement element,int index){
        findDropDown(element).selectByIndex(index);
    }

    public static void selectByText(WebElement element,String text){
        findDropDown(element).selectByVisibleText(text);
    }
}