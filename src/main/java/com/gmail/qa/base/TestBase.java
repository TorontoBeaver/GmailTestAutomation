package com.gmail.qa.base;
import com.gmail.qa.utill.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase(){
        FileInputStream ip = null;
        prop = new Properties();
        try {
            ip = new FileInputStream("src\\main\\java\\com\\gmail\\qa\\config\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialisation(String url){

        String browserName =prop.getProperty("browser");
        if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe"   );
        driver=new ChromeDriver();
        }
        else if (browserName.equals("FF")){
        System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(url);
    }
        }


