package EnvironmentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnvironmentSetupTestSample {
	
	static String resource_URL = "https://selenium.dev";
	
	public static void main(String[] args) throws Exception{
		
		// Project Location
		String projectLocation = System.getProperty("user.dir");
		
		// Chrrome Driver
		//System.setProperty("webdriver.chrome.driver","G:\\LatestEclipse\\Selenium Development\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",projectLocation+"\\\\Lib\\\\WebDrivers\\\\chromedriver.exe");
		WebDriver web_driver = new ChromeDriver();
		web_driver.get("https://www.google.com");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Couldn't Resolve");
		}
		web_driver.close();
		
		// Gecko Driver
//		System.setProperty("webdriver.gecko.driver", projectLocation+"\\Lib\\WebDrivers\\geckodriver.exe");
//		System.setProperty("webdriver.firefox.bin", "Loction To Firefox bin ");
//		WebDriver gecko_driver = new FirefoxDriver();
		//WebDriver gecko_driver = new MarionetteDriver();
//		gecko_driver.get(resource_URL);
//		Thread.sleep(2000);
//		gecko_driver.close();
	}

}
