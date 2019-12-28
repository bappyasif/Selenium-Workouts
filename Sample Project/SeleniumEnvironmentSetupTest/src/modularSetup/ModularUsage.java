package modularSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ModularUsage {

	static String browserPlatform; 
	static WebDriver web_driver;
	
	static String base_URL = "https://www.google.com";
	
	
	public static void main(String[] args) {
		ModularUsage createdObject = new ModularUsage();
		
		createdObject.setBrowser();
		createdObject.browserConfig();
		createdObject.commenceTest();
		createdObject.closeBrowser();
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
