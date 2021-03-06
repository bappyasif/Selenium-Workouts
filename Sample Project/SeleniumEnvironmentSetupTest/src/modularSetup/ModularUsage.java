package modularSetup;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import configSettings.PropertiesFileSettingsSetup;

public class ModularUsage {

	public static String browserPlatform; 
	static WebDriver web_driver;
	
	static String base_URL = "https://www.google.com";
	
	
	public static void main(String[] args) throws IOException {
		
//		PropertiesFileSettingsSetup.readFromPropertiesFile();
//		browserConfig();
//		commenceTest();
//		closeBrowser();
//		PropertiesFileSettingsSetup.writeIntoPropertiesFile();
		
		ModularUsage createdObject = new ModularUsage();
		
		//createdObject.setBrowser();
		PropertiesFileSettingsSetup.readFromPropertiesFile();
		createdObject.browserConfig();
		createdObject.commenceTest();
		createdObject.closeBrowser();
		PropertiesFileSettingsSetup.writeIntoPropertiesFile();
	}
	
	
	/**
	 * Initializing Browser
	 */
	public static void setBrowser() {
		browserPlatform = "Chrome";
	}

	/**
	 * Browser Configuration 
	 */
	public static void browserConfig() {
		// Project Location
		String projectLocation = System.getProperty("user.dir");
		//System.out.println(browserPlatform);
		
		if(browserPlatform.contains("Chrome")) {
			// Chrome Settings
			System.setProperty("webdriver.chrome.driver", projectLocation+"\\Lib\\WebDrivers\\chromedriver.exe");
			web_driver = new ChromeDriver();
		}

		if(browserPlatform.contains("Firefox")) {
			// Firefox Settings
			System.setProperty("webdriver.gecko.driver", projectLocation+"\\Lib\\WebDrivers\\geckodriver.exe");
			web_driver = new FirefoxDriver();
		}
	}

	/**
	 * Run test
	 */
	public static void commenceTest() {
		// Navigating To Provided Site
		web_driver.get(base_URL);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Couldn't Resolve");
		}
	}

	/**
	 * Closing Browser
	 */
	public static void closeBrowser() {
		web_driver.close();
	}
}
