package com.test.jbehave.steps;

import com.test.jbehave.main.Base;
import com.test.jbehave.pages.GoogleHomePage;
import com.test.jbehave.pages.GoogleSearchPage;
import com.test.jbehave.pages.GoogleServiceLogin;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.testng.Assert;

import java.util.Map;

public class MySteps extends Base {

    private GoogleHomePage googleHomePage;
    private GoogleServiceLogin googleServiceLogin;
    private GoogleSearchPage googleSearchPage;
    private Map<String, String> message;

    @Given("home google page $url")
    public void givenGoogleBasePage(String url) {
        googleHomePage = new GoogleHomePage();
        googleHomePage.open(url);
    }

    @Given("gmail authentication form")
    public void givenGoogleAuthenticationForm() {
        googleServiceLogin = googleHomePage.clickLoginButton();
    }

    @When("the user has entered wrong $username and $password")
    public void whenEnteredWrongAccount(String username, String password) {
        googleServiceLogin.enterUserName(username);
        googleServiceLogin.enterPassword(password);
    }

    @When("log-in button has been pressed")
    public void whenPressedLoginButton() {
        googleServiceLogin.pressEnterButton();
    }

    @Then("the user should see corresponding error message: $examplesTable")
    public void thenExpectingErrorMessage(ExamplesTable examplesTable) {
        message = examplesTable.getRow(0);
        Assert.assertTrue(googleServiceLogin.isLoginErrorMessage(message.get("message")));
    }

    @Then("the user should transfer to the google search page")
    public void transferringToGoogleSearchPage(){
        googleSearchPage = new GoogleSearchPage();
    }

    @Then("new message on the top of screen should appeared: $examplesTable")
    public void messageAppeared(ExamplesTable examplesTable){
        message = examplesTable.getRow(0);
        Assert.assertEquals(message.get("message"),googleSearchPage.getMessage());
    }



}