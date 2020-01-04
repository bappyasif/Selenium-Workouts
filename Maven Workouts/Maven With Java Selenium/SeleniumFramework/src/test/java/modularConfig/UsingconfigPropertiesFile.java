package modularConfig;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import modularConfig.ConfigFileAccessExample;

public class UsingconfigPropertiesFile {
	
	static String base_URl = "https://www.seleniumhq.org/";
	static WebDriver web_driver;
	
	public static String browser_platform;
//	String projet_path = System.getProperty("user.dir");
//	String propertiesFile = projet_path+"\\console.properties";
	
	public static void main(String[] args) throws Exception {
		//browserSetup();
		modularConfig.ConfigFileAccessExample.readFromProeprtiesFile();
		configBrowser();
		commenceTest();
		tearDown();
	}
	
	public static void browserSetup() {
		browser_platform = "Chrome";
//		String projet_path = System.getProperty("user.dir");
//		String propertiesFile = projet_path+"\\console.properties";
	}
	
	public static void configBrowser() {
		
		String projet_path = System.getProperty("user.dir");
//		String propertiesFile = projet_path+"\\console.properties";
		
		if(browser_platform.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			web_driver = new ChromeDriver();
		}
		
		if(browser_platform.contains("IE")) {
			WebDriverManager.iedriver().setup();
			web_driver = new InternetExplorerDriver();
		}
	}
	
	public static void commenceTest() {
		web_driver.get(base_URl);
		System.out.println("Navigation Successful");
		System.out.println("Page Title : "+web_driver.getTitle());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void tearDown() {
		web_driver.close();
		System.out.println("Test Done...");
	}

}
