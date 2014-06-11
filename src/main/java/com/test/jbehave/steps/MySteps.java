package com.test.jbehave.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class MySteps {

    static WebDriver driver;

    @Given("I am in FF")
    public void invokeBrowser() {
        driver = new FirefoxDriver();
    }

    @Given("I navigate to google")
    public void navigate() {
        driver.get("http://www.google.co.in");
    }

    @Then("I verify search field")
    public void verify() {// verifying search element in google home page
        driver.findElement(By.id("gs_htif01")).isDisplayed();
        driver.quit();
    }

}