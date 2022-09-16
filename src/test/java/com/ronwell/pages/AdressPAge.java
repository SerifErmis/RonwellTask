package com.ronwell.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdressPAge extends BasePage {

    @FindBy(id="name")
    public WebElement name;

    @FindBy(id="surname")
    public WebElement surname;

    @FindBy(id="select-country-code")
    public List<WebElement> countryCode;

    @FindBy(id="phone")
    public WebElement phone;

    @FindBy(id="postal-code")
    public WebElement postalCode;

    @FindBy(id="city-name")
    public WebElement city;

    @FindBy(id="address-text")
    public WebElement addressText;

    @FindBy(xpath = "//*[.='SAVE AND CONTINUE']")
    public WebElement saveButton;




}
