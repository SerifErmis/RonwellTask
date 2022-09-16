package com.ronwell.step_definitions;

import com.github.javafaker.Faker;
import com.ronwell.pages.*;
import com.ronwell.utilities.BrowserUtils;
import com.ronwell.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task1 {
    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage =new MainPage();
    ProductPage productPage= new ProductPage();
    MyCartPage myCartPage = new MyCartPage();
    FavoritesPage favoritesPage = new FavoritesPage();
    AdressPAge adressPAge = new AdressPAge();
    Faker faker = new Faker();

    @Given("user already main page")
    public void userAlreadyMainPage() {
        Driver.getDriver().get("https://www.trendyol.com/en");
        mainPage.countrySelect();
        BrowserUtils.waitForClickAbility(mainPage.acceptButton,10);
        mainPage.acceptButton.click();
    }

    @When("user clicks user button for registration")
    public void userClicksUserButtonForRegistration() {
        registrationPage.userButton.click();
    }

    @Then("user should see all specified fields")
    public void userShouldSeeAllSpecifiedFields() {
        Assert.assertTrue(registrationPage.emailInput.isDisplayed());
        Assert.assertTrue(registrationPage.passwordInput.isDisplayed());
        Assert.assertTrue(registrationPage.manButton.isDisplayed());
        Assert.assertTrue(registrationPage.womanButton.isDisplayed());
        Assert.assertTrue(registrationPage.communicationCheckbox.isDisplayed());
        Assert.assertTrue(registrationPage.contractLink.isDisplayed());
        Assert.assertTrue(registrationPage.contractLink2.isDisplayed());
        Assert.assertTrue(registrationPage.ReadMoreLink.isDisplayed());
        Assert.assertTrue(registrationPage.facebookLink.isDisplayed());
        Assert.assertTrue(registrationPage.googleLink.isDisplayed());

    }

    @And("user clicks submit button without any input credentials")
    public void userClicksSubmitButtonWithoutAnyInputCredentials() {
        BrowserUtils.waitForClickAbility(registrationPage.submitButton,10);
        registrationPage.submitButton.click();
    }

    @Then("user should see validation error message")
    public void userShouldSeeValidationErrorMessage() {
        Assert.assertEquals("Enter your e-mail and password.", registrationPage.errorBox.getText());
            }

    @And("user enters space character in mail field")
    public void userEntersSpaceCharacterInMailField() {
        BrowserUtils.waitForClickAbility(registrationPage.emailInput,10);
        registrationPage.emailInput.sendKeys("        ");

    }

    @And("user clicks submit button")
    public void userClicksSubmitButton() {
        registrationPage.submitButton.click();
    }

    @Then("user should see invalid e-mail message")
    public void userShouldSeeInvalidEMailMessage() {

        Assert.assertEquals("Please enter a valid email address.", registrationPage.errorBox2.getText());
    }


    @And("user clicks logout button")
    public void userClicksLogoutButton() {
        registrationPage.logOut();
    }



    @Then("user should see login button on user page")
    public void userShouldSeeLoginButtonOnUserPage() {
        Assert.assertTrue(registrationPage.loginButton.isDisplayed());
    }

    @Given("user already login")
    public void userAlreadyLogin() {
    userAlreadyMainPage();
    registrationPage.login();

    }

    List<String> expectedProductsName = new ArrayList<>();
    @When("user clicks add to cart button on product page")
    public void userClicksAddToCartButtonOnProductPage(List<String> products) {
        for (String product : products) {
            mainPage.search(product);
            BrowserUtils.waitForClickAbility(mainPage.firstProduct,10);
            mainPage.firstProduct.click();
            productPage.addToCartButton.click();
        expectedProductsName.add(product.toLowerCase());}

    }


    @And("user clicks my cart icon")
    public void userClicksMyCartIcon() {

     mainPage.myCartButton.click();
    }

    @Then("user should see added product on My cart page")
    public void userShouldSeeAddedProductOnMyCartPage() {
       List<String> actualProductsName = BrowserUtils.getElementsText(myCartPage.productNames);
        List<String> actualProductsNameRevised = new ArrayList<>();
        for (String s : actualProductsName) {
            String s1 =s.replace("- ", "").toLowerCase();
            actualProductsNameRevised.add(s1);
                    }
       Assert.assertEquals(expectedProductsName,actualProductsNameRevised);

    }
    List<String> expectedFavsName = new ArrayList<>();
       @When("user clicks add to favorites button on product page")
    public void userClicksAddToFavoritesButtonOnProductPage(List<String> favs) {
        for (String fav : favs) {
            mainPage.search(fav);
            BrowserUtils.waitForClickAbility(mainPage.firstProduct,10);
            mainPage.firstProduct.click();
            if(!productPage.addToFavorites.getAttribute("class").equalsIgnoreCase("selected")){
            productPage.addToFavorites.click();}
            expectedFavsName.add(fav.toLowerCase());}
    }

    @And("user clicks my favorites icon")
    public void userClicksMyFavoritesIcon() {
     BrowserUtils.waitForClickAbility(mainPage.myFavButton,10);
     mainPage.myFavButton.click();
    }


    @And("user clicks checkout button")
    public void userClicksCheckoutButton() {
     myCartPage.checkoutButton.click();
    }





    @Then("user should see added product on My favorites page")
    public void userShouldSeeAddedProductOnMyFavoritesPage() {
        List<String> actualFavsName = BrowserUtils.getElementsText(favoritesPage.productNames);
        List<String> actualFavsNameRevised = new ArrayList<>();
        for (String s : actualFavsName) {
            String s1 =s.replace("- ", "").toLowerCase();
            actualFavsNameRevised.add(s1);
        }
     Collections.sort(actualFavsNameRevised);
     Collections.sort(expectedFavsName);
     Assert.assertEquals(expectedFavsName,actualFavsNameRevised);

    }


    @And("user enters adreess form")
    public void userEntersAdreessForm() {
        BrowserUtils.waitForVisibility(adressPAge.name, 10);
        adressPAge.name.sendKeys(faker.name().firstName());
        adressPAge.surname.sendKeys(faker.name().lastName());
        Select countryCodes = new Select(Driver.getDriver().findElement(By.id("select-country-code")));
        countryCodes.selectByIndex(0);
        adressPAge.phone.sendKeys("2078365454");
        adressPAge.postalCode.sendKeys("E1 6AN");
        adressPAge.city.sendKeys("London");
        adressPAge.addressText.sendKeys(faker.address().streetAddress());
        adressPAge.saveButton.click();
    }

    @And("user clicks order button by paypal")
    public void userClicksOrderButtonByPaypal() {
           BrowserUtils.waitForClickAbility(mainPage.placeOrder,10);
           mainPage.placeOrder.click();
           BrowserUtils.waitFor(3);
    }

    @Then("user should see paypal app")
    public void userShouldSeePaypalApp() {
           Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("paypal"));
    }
}

