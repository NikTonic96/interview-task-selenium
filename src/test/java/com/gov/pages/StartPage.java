package com.gov.pages;

import com.gov.utilities.ConfigurationReader;
import com.gov.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    public StartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goToGovUkStartPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gov.url"));
    }

    public String verifyUrlOfPage() {
        String url = Driver.getDriver().getCurrentUrl();
        System.out.println("The url is = " + url);
        return url;
    }

    @FindBy(xpath = "//button[@class='gem-c-button govuk-button']")
    public WebElement cookiesAccept;

    @FindBy(xpath = "//a[@class='gem-c-button govuk-button govuk-button--start']")
    public WebElement startButton;

    public void clickStartButton() {
        startButton.click();
    }
}