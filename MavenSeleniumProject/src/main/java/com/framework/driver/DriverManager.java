package com.framework.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.framework.config.ConfigReader;

public final class DriverManager {
	
	private static WebDriver driver = null;
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static void setDriver(WebDriver _driver)
	{
		driver = _driver;
	}
	
	public static WebDriver initiateDriver(String browserName)
	{
        String browser = (browserName != null && !browserName.isEmpty())
		                ? browserName.toLowerCase()
		                : ConfigReader.getProperty("browser").toLowerCase();

        String executionmode = ConfigReader.getProperty("headless");
        WebDriver driver;

        switch (browser) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (executionmode.equalsIgnoreCase("true"))
                {
                    firefoxOptions.addArguments("-headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (executionmode.equalsIgnoreCase("true")) {
                    edgeOptions.addArguments("--headless=new");
                }
                driver = new EdgeDriver(edgeOptions);
                break;

            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                if (executionmode.equalsIgnoreCase("true")) {
                    chromeOptions.addArguments("--headless=new");
                }
                chromeOptions.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        int impwait = Integer.parseInt(ConfigReader.getProperty("implicitwait"));
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(impwait));
        driver.manage().window().maximize();
        
        return driver;
    }

}
