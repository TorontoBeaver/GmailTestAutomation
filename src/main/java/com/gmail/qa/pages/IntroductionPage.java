package com.gmail.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmail.qa.base.TestBase;

public class IntroductionPage extends TestBase {

	// Page factory or Object rep:

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
	

	// Initilizing page objects:

	public IntroductionPage() {

		PageFactory.initElements(driver, this);
	}

	// Actions:

	public String validateIntroPageTitle() {

		return driver.getTitle();

	}

	public boolean validateGmailLogo() {
		return gmailLogo.isDisplayed();
	}
	
	public LogInPage signIn() {
		signIn.click();
		return new LogInPage();
	}

}
