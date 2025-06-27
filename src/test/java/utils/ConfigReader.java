package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/*
 * first set the path of config.properties file
 * create an object for Properties class
 * create an object for fileinputstream
 * load data to properties object from fileinputstream
 * 
 * get the data from property file as string
 * write a method to get the data from property file as integer
 * */

public class ConfigReader 
{
	Properties properties;
	private static final String CONFIG_FILE_PATH=".//src//test//resources//config.properties";
	
	
	  public ConfigReader() {
	        properties = new Properties();
	        try (FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH)) 
	        {
	            properties.load(fileInputStream);
	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to load config.properties file");
	        }
	    }
	
	  
	  public String getProperty(String key)
	  {
		  return properties.getProperty(key);
	  }
	
	  
	  public int getIntProperty(String key)
	  {
		  return Integer.parseInt(properties.getProperty(key));
	  }
}
