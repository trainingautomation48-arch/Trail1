package com.framework.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.framework.config.ConfigReader;
import com.framework.driver.DriverManager;
import com.framework.pages.BasePage;

public class BaseTest extends BasePage{
	
	protected String url;
	protected WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(@Optional("") String browser)
	{
		url = ConfigReader.getProperty("baseurl");
		driver = DriverManager.initiateDriver(browser);
		DriverManager.setDriver(driver);
		driver.get(url);
	}
	
	@AfterClass
	public void testDown()
	{
		driver.quit();
	}

}
