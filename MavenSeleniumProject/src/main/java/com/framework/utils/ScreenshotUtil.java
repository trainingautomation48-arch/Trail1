package com.framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.framework.driver.DriverManager;

public class ScreenshotUtil {
	
	public static String Timestamp()
	{
		LocalDateTime ldt = LocalDateTime.now();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd_hh-mm-ss");
		String timestamp = ldt.format(dtf);
		
		return timestamp;
	}
	
	public static String CaptureScreenShot(WebDriver driver, String testName) throws IOException {
		TakesScreenshot ts  = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		
		String screenshotpath = System.getProperty("user.dir") 
				+ "\\Screenshots\\" 
				+ testName 
				+ "_"
				+ Timestamp()
				+ ".png";
		File destination = new File(screenshotpath);
		
		Files.createDirectories(destination.toPath().getParent());
		
		Files.copy(source.toPath(), destination.toPath());
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

}
