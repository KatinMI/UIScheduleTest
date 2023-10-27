package com.test;

import com.test.model.Lecture;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * class for working with full schedule
 */
public class FullSchedulePage extends BasePage {
    @FindBy(xpath = "/html/body/div[1]/div[1]/a")
    private WebElement oldScheduleButton;
    @FindBy(xpath = "//*[@id=\"MessForPrint\"]/table")
    private WebElement table;
    @FindBy(xpath = "//*[@id=\"hideCont1\"]/table")
    private WebElement oldTable;
    public FullSchedulePage(){
        driver.get("https://sd.mstuca1.ru/d/full?fac=3&flow=162&grp=1&lsubgrp=4&esubgrp=0");
        PageFactory.initElements(driver, this);
    }

    /**
     * A method for getting a lecture that will be either today or in the future
     * @param day -The day on which you need to get a lecture. Value 1 is the current day
     * @param numOnSchedule - How much is the lecture in the schedule
     * @return - Lecture on current parameters
     */
    public Lecture getLecture(int day, int numOnSchedule) {
        WebElement element = table.findElement(By.xpath(".//tbody/tr[" + day + "]/td[" + (numOnSchedule + 3) + "]"));
        try {
            return new Lecture(element.findElement(By.xpath(".//a/font/b")).getText(),
                    element.findElement(By.xpath(".//a/font/small")).getText(),
                    (!element.getAttribute("class").equals("day_labwork")) ?
                            element.findElement(By.xpath(".//a/font/i[1]/u")).getText() :
                            element.findElement(By.xpath(".//a/font/i/u")).getText(),
                    (!element.getAttribute("class").equals("day_labwork")) ?
                            element.findElement(By.xpath(".//a/font/i[2]/u")).getText() :
                            element.findElement(By.xpath(".//a/font/span/i/u")).getText());
        } catch (NoSuchElementException e){
            return null;
        }
    }
    /**
     * The method returns the lecture from the first of September to the current day
     * @param day -The day on which you need to get a lecture. Value 1 is the 1 september
     * @param numOnSchedule - How much is the lecture in the schedule
     * @return - Lecture on current parameters
     */
    public Lecture getOldLecture(int day, int numOnSchedule) {
        oldScheduleButton.click();
        WebElement element = oldTable.findElement(By.xpath(".//tbody/tr[" + day + "]/td[" + (numOnSchedule + 3) + "]"));
        try {
            return new Lecture(element.findElement(By.xpath(".//a/font/b")).getAttribute("innerText"),
                    element.findElement(By.xpath(".//a/font/small")).getAttribute("innerText"),
                    (!element.getAttribute("class").equals("day_labwork")) ?
                            element.findElement(By.xpath(".//a/font/i[1]/u")).getAttribute("innerText") :
                            element.findElement(By.xpath(".//a/font/i/u")).getAttribute("innerText"),
                    (!element.getAttribute("class").equals("day_labwork")) ?
                            element.findElement(By.xpath(".//a/font/i[2]/u")).getAttribute("innerText") :
                            element.findElement(By.xpath(".//a/font/span/i/u")).getAttribute("innerText"));
        } catch (NoSuchElementException e){
            return null;
        }
    }
}

