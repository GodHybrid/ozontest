package test.tesuto.Utility;

import test.tesuto.Pages.BasePageObj;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class Initialization
{
    public static TestProperties settingProperties = TestProperties.getInstance();

    public static void initializeDriver()
    {
        switch ("chrome")
        {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", settingProperties.getProperty("firefoxdriver"));
                BasePageObj.driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", settingProperties.getProperty("chromedriver"));
                BasePageObj.driver = new ChromeDriver();
        }

        BasePageObj.driver.manage().window().maximize();
        BasePageObj.driver.get(settingProperties.getProperty("url"));
        BasePageObj.driver.manage().timeouts().implicitlyWait(Integer.parseInt(settingProperties.getProperty("general-timeout")), TimeUnit.SECONDS);
        BasePageObj.driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(settingProperties.getProperty("onload-timeout")), TimeUnit.SECONDS);
        BasePageObj.driver.manage().deleteAllCookies();
    }

    public static WebDriver getDriver()
    {
        if(BasePageObj.driver == null)initializeDriver();
        return BasePageObj.driver;
    }
}