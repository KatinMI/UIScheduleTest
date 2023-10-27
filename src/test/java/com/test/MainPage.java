package com.test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Main page class
 */
public class MainPage extends BasePage{
private final SelenideElement link = $x("/html/body/div[1]/table[3]/tbody/tr/td[1]/a");

    /**
     *
     * @param url - this is a link to the main page of the site with a schedule
     */
    public MainPage(String url) {
        Selenide.open(url);
    }

    /**
     * The method redirects to the schedule selection page
     * @return - class for working with schedule selection page
     */
    public SelectionPage clickOnLink(){
    link.click();
    return new SelectionPage();
}
}
