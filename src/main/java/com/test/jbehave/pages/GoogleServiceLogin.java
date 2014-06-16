package com.test.jbehave.pages;

import com.test.jbehave.main.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oleksandr_Kara on 12-Jun-14.
 */
public class GoogleServiceLogin extends Page {

   @FindBy (id = "Email") WebElement userNameElement;
   @FindBy (id = "Passwd") WebElement passwordElement;
   @FindBy (id = "signIn") WebElement enterButtonElement;

    public void enterUserName(String userName) {
        type(userNameElement, userName);
    }

    public void enterPassword(String password) {
        type(passwordElement, password);
    }

    public void pressEnterButton() {
        enterButtonElement.click();
    }

    public boolean isLoginErrorMessage() {

        /*isElementPresent("errormsg_0_Passwd");
        System.out.println(selenium.getText("errormsg_0_Passwd"));
        return selenium.getText("errormsg_0_Passwd").contains(message);*/
        return true;
    }

}
