package com.gmail.qa.tests;
import com.gmail.qa.base.TestBase;
import com.gmail.qa.pages.IntroductionPage;
import com.gmail.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;

public class IntroductionPageTest extends TestBase {

        IntroductionPage introductionPage;
        LoginPage loginPage;

        public IntroductionPageTest() {
            super();
        }
        @BeforeMethod
        public void setUp() {
            initialisation(prop.getProperty("welcomPageUrl"));
            introductionPage = new IntroductionPage();
        }
        @Test
        public void validateIntroPageTitleTest() {
        String title = introductionPage.validateIntroPageTitle();
        String introPageTitle = prop.getProperty("introPageTitle");
        Assert.assertEquals(title, introPageTitle,"Wrong page, because page title is different");
        }
        @Test
        public void GmailLogoTest() {
            boolean flag=introductionPage.validateGmailLogo();
            Assert.assertTrue(flag);
        }
        @Test
        public void signInTest(){
            loginPage = introductionPage.signIn();
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
        }


