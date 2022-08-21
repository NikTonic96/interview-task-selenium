package com.gov.pages;


import com.gov.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DoYouWantToWorkOutHoliday extends BasePage {

    @FindBy(xpath = "//label[@for='response-0']")
    public WebElement firstOptionButtonText;

    public void getListOfRadioButtons(int chooseRadioButton) {
        List<WebElement> listOfRadioButtons = Driver.getDriver().
                findElements(By.xpath("//input[@type='radio']"));

        listOfRadioButtons.get(chooseRadioButton).click();
    }

    public String getTitle() {
        String title = Driver.getDriver().getTitle();
        System.out.println("The title is = " + title);
        return title;
    }
}