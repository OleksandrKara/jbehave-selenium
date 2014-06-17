package com.test.jbehave.pages;

import com.test.jbehave.main.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleksandr_Kara on 17-Jun-14.
 */
public class GoogleSearchPage extends Page{

    @FindBy (xpath = "//*[@id=\"pushdown\"]/div[2]/span[@class='pdtext']")
    WebElement successMessage;

    public String getMessage() {
        return successMessage.getText();
    }
}
