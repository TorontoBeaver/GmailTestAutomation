package com.gmail.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gmail.qa.base.TestBase;

public class LogInPage extends TestBase {

	// Page factory

	@FindBy(xpath = " //*[@id=\"identifierId\"]")
	WebElement emailField;

	@FindBy(xpath = "//*[@id=\"identifierNext\"]")
	WebElement nextButton;

	@FindBy(xpath = " //span[contains(text(),'Forgot email?')]")
	WebElement forgotEmail;

	@FindBy(xpath = " //a[contains(text(),'Learn more')]")
	WebElement learnMore;

	@FindBy(xpath = " //span[contains(text(),'Create account')]")
	WebElement createAccount;

	@FindBy(xpath = "//div[@id='lang-chooser']")
	WebElement english;

	@FindBy(xpath = "//a[contains(text(),'Help')]")
	WebElement help;

	@FindBy(xpath = "//a[contains(text(),'Privacy')] ")
	WebElement privacy;

	@FindBy(xpath = "//a[contains(text(),'Terms')]")
	WebElement terms;

	@FindBy(xpath = " //input[contains(@aria-label,'Enter your password')]")
	WebElement enterYourPasspordField;

	@FindBy(xpath = "//*[@id='passwordNext']")
	WebElement passwordNextButton;

	@FindBy(xpath = "//span[contains(text(),\"Forgot password?\")]")
	WebElement forgotPassword;

	@FindBy(xpath = " //div[@id=\"profileIdentifier\"]      */")
	WebElement emailOrPhoneField;

}