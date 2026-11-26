package com.framework.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.framework.driver.DriverManager;
import com.framework.utils.ExtentReportManager;
import com.framework.utils.ScreenshotUtil;


public class TestListener implements ITestListener {

	private static final ExtentReports extent = ExtentReportManager.getInstance();
	
	public void onTestStart(ITestResult result)
	{
		String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();
        ExtentTest test = extent.createTest(testName, description)
                .assignCategory(result.getTestClass().getRealClass().getSimpleName());
        test.info("Executed on Thread ID: " + Thread.currentThread().getId());
        ExtentReportManager.setTest(test);
	}
	
	
	public void onTestSuccess(ITestResult result)
	{
		ExtentReportManager.getTest().log(Status.PASS, "Test Passed Successfully");
        ExtentReportManager.unload();
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		ExtentTest test = ExtentReportManager.getTest();
        test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
        String base64Screenshot="";
		
		try {
			base64Screenshot =  ScreenshotUtil.CaptureScreenShot(DriverManager.getDriver(),result.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Screenshot is captured");
		
		if (!base64Screenshot.isEmpty()) {
            test.fail("Failure Screenshot:",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
        ExtentReportManager.unload();
	}
	

	public void onTestSkipped(ITestResult result)
	{
		ExtentReportManager.getTest().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        ExtentReportManager.unload();
	}
	

	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	
}
