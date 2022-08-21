package com.gov.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationBasedOnYourAnswers extends BasePage {

    @FindBy(xpath = "//a[@data-track-category='StartAgain']")
    public WebElement startAgainButton;
}