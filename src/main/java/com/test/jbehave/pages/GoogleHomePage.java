package com.test.jbehave.pages;

import com.test.jbehave.main.Driver;
import com.test.jbehave.main.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleksandr_Kara on 12-Jun-14.
 */
public class GoogleHomePage extends Page{

    @FindBy (id = "gb_70")
    WebElement button;

    public void open(String url) {
        Driver.driver.get(url);
    }

    public GoogleServiceLogin clickLoginButton() {
        button.click();
        return new GoogleServiceLogin();
    }

}
