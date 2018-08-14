package com.gmail.qa.tests;

import com.gmail.qa.base.TestBase;
import com.gmail.qa.pages.HomePage;
import com.gmail.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class HomePageTests extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTests() {
        super();
    }
    @BeforeMethod

    public void setUp() {
        initialisation(prop.getProperty("signInPageUrl"));
        loginPage = new LoginPage();
        homePage = new HomePage();
    }
    @Test(priority=1)
    public void sendMessageTest() {
        homePage = loginPage.logInUserName(prop.getProperty("username"), prop.getProperty("password"));
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String title = loginPage.validateLoginPageTitle();
        String userName = prop.getProperty("username");
        Assert.assertTrue(title.contains(userName), "Username or password do not match.");
        System.out.println("You have successfully logged in.");

     homePage.sentMessage(prop.getProperty("newMessageEmail"),
             prop.getProperty("newMessageSubject"),prop.getProperty("newMessage"));

     String checkEmail = homePage.test();
        System.out.print(checkEmail);
     //Assert.assertEquals(checkEmail,prop.getProperty("newMessageSubject"));
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
