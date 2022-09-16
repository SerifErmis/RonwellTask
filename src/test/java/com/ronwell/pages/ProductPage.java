package com.ronwell.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(id = "add-to-basket")
    public WebElement addToCartButton;

    @FindBy(id = "add-to-favorites")
    public WebElement addToFavorites;

    @FindBy(css ="span.product-info-product-name")
    public WebElement productName;

    @FindBy(xpath ="//img[contains(@src,'images/20210209/17/61517715/71127643/2/2_org_zoom.jpg')]")
    public WebElement productImage;

    @FindBy(xpath = "//*[@class='variant  active']")
    public WebElement productSize;

    @FindBy(xpath = " //*[@class='pdp-price sellingPrice']")
    public WebElement productPrice;






}
