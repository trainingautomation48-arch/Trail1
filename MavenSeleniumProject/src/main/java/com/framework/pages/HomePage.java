package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	
	By lnkLogin = By.id("customer_login_link");
	
	public void clickLogin()
	{
		driver.findElement(lnkLogin).click();
	}
	
	
}
