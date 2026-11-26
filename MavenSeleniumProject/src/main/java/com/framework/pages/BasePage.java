package com.framework.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.config.ConfigReader;
import com.framework.driver.DriverManager;

public abstract class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage()
	{
		this.driver = DriverManager.getDriver();
		int timeout = Integer.parseInt(ConfigReader.getProperty("explicitwait"));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyPageTitle(String expectedPageTitle, String actualPageTitle)
	{
		return expectedPageTitle.equalsIgnoreCase(actualPageTitle);
	}

}
