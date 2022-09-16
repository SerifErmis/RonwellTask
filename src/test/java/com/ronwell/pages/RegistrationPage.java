package com.ronwell.pages;

import com.ronwell.utilities.BrowserUtils;
import com.ronwell.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    @FindBy(id = "emaillogin")
    public WebElement emailLogin;

    @FindBy(id = "passwordlogin")
    public WebElement passwordLogin;

    @FindBy(xpath = "//*[.='LOG IN']")
    public WebElement loginButton;

    public void login(){
        BrowserUtils.waitForClickAbility(userButton,10);
        userButton.click();
        BrowserUtils.waitForVisibility(emailLogin,10);
        emailLogin.sendKeys("testtask635@gmail.com");
        passwordLogin.sendKeys("Q102938?");
        loginButton.click();
        BrowserUtils.waitFor(3);
    }


    @FindBy(css = "div.user")
    public WebElement userButton;

    @FindBy(xpath = "//span[.='Sign Out']")
    public WebElement signOutButton;

    public void logOut(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(userButton).perform();
        signOutButton.click();
    }

    @FindBy(id = "emailregister")
    public WebElement emailInput;

    @FindBy(id = "passwordregister")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Women']")
    public WebElement womanButton;

    @FindBy(xpath = "//button[text()='Men']")
    public WebElement manButton;

    @FindBy(xpath = "//span[contains(@class, 'checkbox-icon-wrapper')]")
    public WebElement communicationCheckbox;

    @FindBy(xpath = "//p[.='SIGN UP']")
    public WebElement submitButton;

    @FindBy(xpath = "//p[text() = 'Read More']")
    public WebElement ReadMoreLink;

    @FindBy(linkText = "Terms of Use")
    public WebElement contractLink;

    @FindBy(linkText = "Privacy Policy")
    public WebElement contractLink2;

    @FindBy(xpath = "(//div[.='Facebook'])[2]")
    public WebElement facebookLink;

    @FindBy(xpath = "(//div[.='Google'])[2]")
    public WebElement googleLink;

    @FindBy(css = "span.message")
    public WebElement errorBox;

    @FindBy(xpath = "//span[.='Please enter a valid email address.']")
    public WebElement errorBox2;









}

    
