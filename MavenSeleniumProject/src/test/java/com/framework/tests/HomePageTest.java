package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.framework.base.BaseTest;
import com.framework.listeners.TestListener;
import com.framework.pages.HomePage;
import com.framework.pages.LoginPage;

@Listeners(TestListener.class)
public class HomePageTest extends BaseTest {
	
  @Test
  public void VerifyHomePageIsDisplayed() {
	  HomePage homepage = new HomePage();
	  Assert.assertTrue(verifyPageTitle("Sauce Demo", homepage.getTitle()),
			  "Expected page title : Sauce Demo"+'\n'+
			  "Actual page title : "+ homepage.getTitle() +'\n'
			  );

  }
  
  @Test
  public void VerifyLoginPageIsDisplayed() {
	  HomePage homepage = new HomePage();
	  homepage.clickLogin();
	  
	  LoginPage loginpage = new LoginPage();
	  loginpage.LoginAs("test", "test");
	  
	  //Assert.assertTrue(loginpage.isLoginPageDisplayed(),"Login page is not displayed.");
	  

  }
}
