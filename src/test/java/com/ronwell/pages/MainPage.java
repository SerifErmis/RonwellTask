package com.ronwell.pages;

import com.ronwell.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends BasePage{
    public void getLink(String link){
        Driver.getDriver().findElement(By.partialLinkText(link)).click();

    }

    public void search(String product){
        Driver.getDriver().findElement(By.xpath("//input[@class='search-bar']")).sendKeys(product+ Keys.ENTER);
    }

    @FindBy(css = "div.product")
    public WebElement firstProduct;

    @FindBy(css = "div.basket-preview-wrapper")
    public WebElement myCartButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptButton;

    @FindBy(xpath = "//*[@class='font-icon icon-web-header-favorites']")
    public WebElement myFavButton;

    @FindBy(id = "place-order-button")
    public WebElement placeOrder;



    public void countrySelect(){
        new Select(Driver.getDriver().findElement(By.xpath("//select"))).selectByVisibleText("United Kingdom");
        Driver.getDriver().findElement(By.xpath("//button[.='Select']")).click();
    }
    public void alertExit(){
        Alert alert =Driver.getDriver().switchTo().alert();
        alert.accept();

    }






}
