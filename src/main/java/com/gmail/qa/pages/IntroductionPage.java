package com.gmail.qa.pages;

import com.gmail.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



        public class IntroductionPage extends TestBase {

            @FindBy(xpath = " //a[contains(@class,'sign-in')]")
            WebElement signIn;

            @FindBy(xpath = " //a[@href='/gmail/about/for-work/']")
            WebElement forWork;

            @FindBy(xpath = "//a[contains(@class,'create-account')]")
            WebElement createAccount;

            @FindBy(xpath = "//div[contains(@class,'gmail-logo')]")
            WebElement gmailLogo;

            @FindBy(xpath = "//a[contains(.,'CREATE AN ACCOUNT')]")
            WebElement CreateAccountLabel;


            public IntroductionPage() {

                PageFactory.initElements(driver, this);
            }
               public String validateIntroPageTitle() {

                return driver.getTitle();
            }
            public boolean validateGmailLogo() {

                return gmailLogo.isDisplayed();
            }
            public LoginPage signIn() {
                signIn.click();
                return new LoginPage();
            }

        }


