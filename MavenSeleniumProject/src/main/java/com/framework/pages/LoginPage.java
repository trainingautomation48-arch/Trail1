package com.framework.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

	By txtemail = By.id("customer_email");
	By txtpwd = By.id("customer_password");
	By btnSignin = By.xpath("//input[@value='Sign In']");
	
	public void LoginAs(String email, String pwd)
	{
		driver.findElement(txtemail).sendKeys(email);
		driver.findElement(txtpwd).sendKeys(pwd);
		driver.findElement(btnSignin).click();
	}
	
	public boolean isLoginPageDisplayed()
	{
		return driver.findElement(txtemail).isDisplayed() &&
				driver.findElement(txtemail).isDisplayed() &&
				driver.findElement(btnSignin).isDisplayed();

	}
	
}
