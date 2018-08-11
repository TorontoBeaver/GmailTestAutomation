package com.gmail.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gmail.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {

			prop = new Properties();

			FileInputStream ip = new FileInputStream(System.getProperty(
					"/Users/vladimirnemtcev/eclipse-workspace/GmailTests/src/main/java/com/gmail/qa/config/config.properties"));

			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialisation() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/vladimirnemtcev/eclipse-workspace/selenium-for-beginers/src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/vladimirnemtcev/eclipse-workspace/selenium-for-beginers/src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}
}