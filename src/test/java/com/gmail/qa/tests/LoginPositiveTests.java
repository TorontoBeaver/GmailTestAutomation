package com.gmail.qa.tests;

import com.gmail.qa.base.TestBase;
import com.gmail.qa.pages.HomePage;
import com.gmail.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginPositiveTests extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPositiveTests() {
        super();
    }
    @BeforeMethod

    public void setUp() {
        initialisation(prop.getProperty("signInPageUrl"));
        loginPage = new LoginPage();
        homePage = new HomePage();
    }
    @Test(priority=1)
    public void validateLoginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        String expectedMailTitle =prop.getProperty("mailTitle");
        Assert.assertEquals(title,expectedMailTitle," Wrong page because page title is different");
    }
    @Test(priority=2)
    public void logInTest() throws InterruptedException {
        homePage = loginPage.logInUserName(prop.getProperty("username"),prop.getProperty("password"));
        sleep(3000);
        String title = loginPage.validateLoginPageTitle();
        String userName =prop.getProperty("username");
        Assert.assertTrue(title.contains(userName),"Username or password do not match.");
        System.out.println("Test completed. You have successfully logged in.");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}



