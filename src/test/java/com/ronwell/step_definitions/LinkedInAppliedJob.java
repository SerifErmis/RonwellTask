package com.ronwell.step_definitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LinkedInAppliedJob {

    @FindBy(xpath = "//*[@class='entity-result__primary-subtitle t-14 t-black t-normal']")
    public List<WebElement> appliedCompanies;




}
