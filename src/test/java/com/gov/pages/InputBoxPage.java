package com.gov.pages;

import com.gov.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class InputBoxPage extends BasePage {

    @FindBy(xpath = "//input[@id='response']")
    public WebElement inputBox;

    @FindBy(xpath = "//div[@class='summary']")
    public WebElement informationSummary;

    @FindBy(xpath = "//p[@class='gem-c-error-message govuk-error-message']")
    public WebElement errorMessage;

    public String getTitle() {
        String title = Driver.getDriver().getTitle();
        System.out.println("The title is = " + title);
        return title;
    }
}