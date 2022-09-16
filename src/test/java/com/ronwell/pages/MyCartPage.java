package com.ronwell.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyCartPage extends BasePage{

    @FindBy(css ="p.product-name")
    public List<WebElement> productNames;

    @FindBy(css ="p.product-size")
    public WebElement productSize;

    @FindBy(css ="p.sale-price")
    public WebElement productPrice;

    @FindBy(xpath ="//img[contains(@src,'images/20210209/17/61517715/71127643/2/2_org_zoom.jpg')]")
    public WebElement productImage;

    @FindBy(xpath = "//button[.='CHECKOUT']")
    public WebElement checkoutButton;




}
