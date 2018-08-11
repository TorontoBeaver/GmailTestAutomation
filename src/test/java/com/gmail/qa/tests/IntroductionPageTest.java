package com.gmail.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gmail.qa.base.TestBase;
import com.gmail.qa.pages.IntroductionPage;
import com.gmail.qa.pages.LogInPage;

public class IntroductionPageTest extends TestBase {
	
	IntroductionPage introductionPage;
	LogInPage loginPage;

	public IntroductionPageTest() {
		super();
	}

	@BeforeMethod

	public void setUp() {
		initialisation();
		introductionPage = new IntroductionPage();

	}

	@Test(priority=1)
	public void validateIntroPageTitleTest() {
		String title = introductionPage.validateIntroPageTitle();
		Assert.assertEquals(title, "Gmail - Free Storage and Email from Google ");
	}

	@Test(priority=2)
	public void GmailLogoTest() {
		boolean flag=introductionPage.validateGmailLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void signInTest(){
		loginPage=introductionPage.signIn();
		
		
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

}