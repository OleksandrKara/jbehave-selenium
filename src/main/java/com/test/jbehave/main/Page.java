package com.test.jbehave.main;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Oleksandr_Kara on 12-Jun-14.
 */
public class Page /*extends WebDriverPage*/ {

    public Page() {
        PageFactory.initElements(Driver.driver, this);
    }

    protected boolean isElementPresent(By locator) {
        Driver.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        List<WebElement> elements = Driver.driver.findElements(locator);
        Driver.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return elements.size() > 0 && elements.get(0).isDisplayed();
    }

    protected void type(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

    protected void acceptConfirmationMessage() {
        Alert alert = Driver.driver.switchTo().alert();
        alert.accept();
    }

    protected void selectElementByTheText(String locator, String text){
        Select select = new Select(Driver.driver.findElement(By.xpath(locator)));
        select.selectByVisibleText(text);
        select.getFirstSelectedOption();
    }

    protected void deselectAllAndSelectElementByTheText(String locator, String text){
        Select select = new Select(Driver.driver.findElement(By.xpath(locator)));
        select.deselectAll();
        select.selectByVisibleText(text);
        select.getFirstSelectedOption();
    }

    protected void javaScriptCodeExecutor(String javaScriptCode){
        ((JavascriptExecutor) Driver.driver).executeScript(javaScriptCode);
    }

    protected void javaScriptClick(String locator){
        JavascriptExecutor executor = (JavascriptExecutor)Driver.driver;
        executor.executeScript("arguments[0].click();", locator);
    }

    protected void waitExplicitlyWebElement(WebElement locator, int seconds){
        WebDriverWait waiter = new WebDriverWait(Driver.driver, seconds);
        waiter.until(ExpectedConditions.visibilityOf(locator));
    }

}
