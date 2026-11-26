package com.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static final Properties prop = new Properties();
	
	static
	{
		try
		{
			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			prop.load(fis);
        } 
		catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties file.", e);
        }
	}
	
	public static String getProperty(String key) {
		
        // Priority 1: Maven CLI System Property (-Dkey=value)
//        String systemProp = System.getProperty(key);
//        
//        if (systemProp != null && !systemProp.trim().isEmpty()) {
//            return systemProp;
//        }
        
        // Priority 2: config.properties file
        return prop.getProperty(key);
    }

}
