package com.test;

import com.test.model.Lecture;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class for working with one day schedule
 */
public class OneDaySchedulePage extends BasePage {
    @FindBy(xpath = "/html/body/div[1]/table[4]")
    private WebElement table;
    @FindBy(xpath = "/html/body/div[1]/center[1]/input[1]")
    private WebElement prevButton;
    @FindBy(xpath = "/html/body/div[1]/center[1]/input[3]")
    private WebElement nextButton;
    public OneDaySchedulePage() {
        driver.get("https://sd.mstuca1.ru/d/oneday?fac=3&flow=162&grp=1&lsubgrp=4&esubgrp=0");
        PageFactory.initElements(driver,this);
    }

    /**
     *
     * @param data - data in format yyyy-MM-dd
     */
    public OneDaySchedulePage(String data){
        driver.get("https://sd.mstuca1.ru/d/oneday?fac=3&flow=162&grp=1&lsubgrp=4&esubgrp=0&ofdate="+data);
        PageFactory.initElements(driver,this);
    }

    /**
     * Retrieves lecture data from the schedule for the day
     * @param numOfSchedule - Lecture number in order
     * @return - lectures data
     */
    public Lecture getLecture(int numOfSchedule){
        WebElement element = table.findElement(By.xpath(".//tbody/tr["+ (1 + numOfSchedule)+ "]"));
        try {
    return new Lecture(element.findElement(By.xpath(".//td[2]/a/font/b")).getText(),
            element.findElement(By.xpath(".//td[2]/a/font/small")).getText(),
            (!element.findElement(By.xpath(".//td[1]")).getAttribute("class").equals("day_labwork")) ?
                    element.findElement(By.xpath(".//td[2]/a/font/i[1]/u")).getText() :
                    element.findElement(By.xpath(".//td[2]/a/font/i/u")).getText(),
            (!element.findElement(By.xpath(".//td[1]")).getAttribute("class").equals("day_labwork")) ?
                    element.findElement(By.xpath(".//td[2]/a/font/i[2]/u")).getText() :
                    element.findElement(By.xpath(".//td[2]/a/font/span/i/u")).getText());
    } catch (NoSuchElementException e){
    return null;
    }
}

    /**
     *  Schedule for the next day
     * @return - page with schedule for the next day
     */
    public OneDaySchedulePage nextDay(){
    Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
    Matcher matcher = p.matcher(nextButton.getAttribute("onclick"));
    nextButton.click();
    if (matcher.find()) return new OneDaySchedulePage(matcher.group());
    else return null;
}

    /**
     * Schedule for the previous day
     * @return page with schedule for the previous day
     */
    public OneDaySchedulePage prevDay(){
    Pattern p = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
    Matcher matcher = p.matcher(prevButton.getAttribute("onclick"));
    prevButton.click();
    if (matcher.find()) return new OneDaySchedulePage(matcher.group());
    else return null;
}

    /**
     * Schedule for the concrete day
     * @param date - data in format yyyy-MM-dd
     * @return - page with schedule for the concrete day
     */
    public OneDaySchedulePage getConcretePage(String date){
    return new OneDaySchedulePage(date);
    }
}
