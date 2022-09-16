package com.ronwell.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FavoritesPage extends BasePage{

    @FindBy(css ="div.product-name")
    public List<WebElement> productNames;

    @FindBy(xpath ="//img[contains(@src,'images/20210209/17/61517715/71127643/2/2_org_zoom.jpg')]")
    public WebElement productImage;
}
