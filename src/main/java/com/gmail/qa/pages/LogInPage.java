package com.gmail.qa.pages;

import com.gmail.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LoginPage extends TestBase {
        @FindBy(xpath = " //*[@id=\"identifierId\"]")
        WebElement emailField;
        @FindBy(xpath = "//*[@id=\"identifierNext\"]")
        WebElement nextButton;
        @FindBy(xpath = " //input[contains(@aria-label,'Enter your password')]")
        WebElement enterYourPasspordField;
        @FindBy(xpath = "//*[@id='passwordNext']")
        WebElement passwordNextButton;
        @FindBy(xpath = "//*[@id=\"profileIdentifier\"]")
        WebElement emailIdentifire;

        public LoginPage() {

                PageFactory.initElements(driver, this);
        }
        public String validateLoginPageTitle() {
                return driver.getTitle();
        }
        public HomePage logInUserName(String username, String password) {
                emailField.sendKeys(username);
                nextButton.click();
                enterYourPasspordField.sendKeys(password);
                passwordNextButton.click();
                return new HomePage();
        }
        public void wronglogInUserName(String wrongUsername) {
                emailField.sendKeys(wrongUsername);
                nextButton.click();
                try {
                        if (!emailIdentifire.isDisplayed()) {
                                System.out.print("Test is failed");
                        }
                } catch (Exception e) {
                        System.out.print("Test is passed");
                }
        }
        public  void wrongLoginPassword(String username, String wrongPassword){
                emailField.sendKeys(username);
                nextButton.click();
                enterYourPasspordField.sendKeys(wrongPassword);
                passwordNextButton.click();
                try {
                        sleep(3000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
                try {
                        if (!emailIdentifire.isDisplayed()) {
                                System.out.print("Test is passed");
                        }
                } catch (Exception e) {
                        System.out.print("Test is failed ");
                }





        }
}









