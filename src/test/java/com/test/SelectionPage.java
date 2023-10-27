package com.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for filling in the schedule selection page
 */
public class SelectionPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"fac\"]")
    private WebElement facList;
    @FindBy(xpath = "//*[@id=\"fac\"]/option[8]")
    private WebElement facValue;
    @FindBy(xpath = "//*[@id=\"flow\"]")
    private WebElement potList;
    @FindBy(xpath = "//*[@id=\"flow\"]/option[4]")
    private WebElement potValue;
    @FindBy(xpath = "//*[@id=\"groups\"]")
    private WebElement groupList;
    @FindBy(xpath = "//*[@id=\"groups\"]/option[2]")
    private WebElement groupValue;
    @FindBy(xpath = "//*[@id=\"lsubgrp\"]")
    private WebElement labList;
    @FindBy(xpath = "//*[@id=\"lsubgrp\"]/option[3]")
    private WebElement labValue;
    @FindBy(xpath = "//*[@id=\"submit1\"]")
    private WebElement fullSubmitButton;
    @FindBy(xpath = "//*[@id=\"submit2\"]")
    private WebElement submitButton;

    public SelectionPage() {
        driver.get("https://sd.mstuca1.ru/d/chgr");
        PageFactory.initElements(driver, this);
    }

    /**
     * The method fills the lists with the necessary values of the group
     */
    private void fillSelectors(){
        facList.click();
        facValue.click();
        potList.click();
        potValue.click();
        groupList.click();
        groupValue.click();
        labList.click();
        labValue.click();
    }

    /**
     * The method redirects to a page with a full schedule
     * @return - class for working with full schedule page
     */
    public FullSchedulePage openFullSchedule(){
    fillSelectors();
    fullSubmitButton.click();
    return new FullSchedulePage();
    }

    /**
     * The method redirects to a page with a one day schedule
     * @return - class for working with one day schedule page
     */
    public OneDaySchedulePage openScheduleOnOneDay(){
    fillSelectors();
    submitButton.click();
    return new OneDaySchedulePage();
    }

}
