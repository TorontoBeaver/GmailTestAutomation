package com.gmail.qa.tests;
import com.gmail.qa.base.TestBase;
import com.gmail.qa.pages.HomePage;
import com.gmail.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginNegativeTests extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginNegativeTests() {
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialisation(prop.getProperty("signInPageUrl"));
        loginPage = new LoginPage();
    }
    @Test(priority=1)
    public void validateLoginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        String expectedMailTitle =prop.getProperty("mailTitle");
        Assert.assertEquals(title,expectedMailTitle,"Wrong page, because page title is different");
    }
    @Test(priority=3)
    public void wrongUserName(){
        loginPage.wronglogInUserName(prop.getProperty("wrongUsername"));
    }
    @Test(priority =2)
    public void wrongPassword(){
        loginPage.wrongLoginPassword(prop.getProperty("username"),prop.getProperty("wrongPassword"));
    }
    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}
