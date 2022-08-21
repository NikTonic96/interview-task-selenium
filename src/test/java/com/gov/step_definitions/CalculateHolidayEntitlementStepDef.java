package com.gov.step_definitions;

import com.gov.pages.InputBoxPage;
import com.gov.pages.IsTheHolidayEntitlementBasedOn;
import com.gov.pages.LocatorsThatAreReusable;
import com.gov.pages.StartPage;
import com.gov.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculateHolidayEntitlementStepDef {

    StartPage startPage = new StartPage();
    IsTheHolidayEntitlementBasedOn isTheHolidayEntitlementBasedOn = new IsTheHolidayEntitlementBasedOn();
    InputBoxPage inputBoxPage = new InputBoxPage();
    LocatorsThatAreReusable reusableLocator = new LocatorsThatAreReusable();

    @Given("User is on the Calculate your holiday entitlement page")
    public void user_is_on_the_calculate_your_holiday_entitlement_page() {
        startPage.goToGovUkStartPage();
        startPage.cookiesAccept.click();
        String expectedUrl = "https://www.gov.uk/calculate-your-holiday-entitlement";
        String actualUrl = startPage.verifyUrlOfPage();

        assertEquals(expectedUrl, actualUrl);
    }

    @Given("User clicks the start button")
    public void user_clicks_the_start_button() {
        startPage.clickStartButton();
    }

    @Given("User is on the next page")
    public void user_is_on_the_next_page() {
        String actualTitle = isTheHolidayEntitlementBasedOn.getTitle();
        String expectedTitle = "Is the holiday entitlement based on: - Calculate holiday entitlement - GOV.UK";
        System.out.println("Title = " + actualTitle);
        assertEquals(expectedTitle, actualTitle);
    }

    @When("User selects first option")
    public void user_selects_first_option() {
        isTheHolidayEntitlementBasedOn.getListOfRadioButtons(0);
    }

    @When("User clicks continue button")
    public void user_clicks_continue_button() {
        reusableLocator.continueButton.click();
    }

    @Then("User clicks on input box")
    public void user_clicks_on_input_box() {
        inputBoxPage.inputBox.click();
    }

    @Then("User then sees information page")
    public void user_then_enters_information_page() {
        String expectedTitle = "Outcome - Calculate holiday entitlement - GOV.UK";
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @And("User inputs the {string} of days worked")
    public void userInputsTheOfDaysWorked(String option) {
        inputBoxPage.inputBox.click();
        inputBoxPage.inputBox.sendKeys(option);
        reusableLocator.continueButton.click();
    }

    @Then("User gets the error message")
    public void userGetsTheErrorMessage() {
        String expectedErrorMessage = "Error:\n" +
                "There are only 7 days in a week. Please check and enter a correct value.";
        String actualErrorMessage = inputBoxPage.errorMessage.getText();
        // System.out.println("actualErrorMessage = " + actualErrorMessage);
        assertTrue(inputBoxPage.errorMessage.isDisplayed());
        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}