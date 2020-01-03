package EnvironmentTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class ModularRunForBrowsersPlatform {
	
	static String base_URL = "http://www.seleniumhq.org/";
	static String project_path = System.getProperty("user.dir");
	
	static WebDriver web_driver;
	static String browser_platform = "IE";
	
	public static void main(String[] args) {
		ModularRunForBrowsersPlatform objCreated = new ModularRunForBrowsersPlatform();
		objCreated.configBrowser();
		//objCreated.browserWindow();
		objCreated.commenceTest();
		objCreated.closeBrowser();
	}
	
	public static void browserWindow() {
		web_driver.manage().window().maximize();
	}
	
	public static void configBrowser() {
		if(browser_platform.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", project_path+"\\Lib\\Web Drivers\\Chrome Driver\\chromedriver.exe");
			web_driver = new ChromeDriver();
		} else if (browser_platform.contains("IE")) {
			System.setProperty("webdriver.ie.driver", project_path+"\\Lib\\Web Drivers\\IE_Driver\\IEDriverServer.exe");
			// Changing Settings For Zoom
//			InternetExplorerOptions capabilities = new InternetExplorerOptions();
//			capabilities.ignoreZoomSettings();
//			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
//					   true);
			// Else Change Zoom Preference Manually From browser Settings
//			web_driver = new InternetExplorerDriver(capabilities);
			web_driver = new InternetExplorerDriver();
		} else {
			System.out.println("No Preferred Browser Detected");
		}
	}
	
	public static void commenceTest() {
		//browserWindow();
		web_driver.get(base_URL);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Activate Windows For Error Free Browsing With IE
		// Also Change System Font Size Settings To 100% To Make it Work.
		
		// Most Of All You Have To Make Changes In your Protected Mode 
		// Settings To UnCheck For All modes. 
		System.out.println("Page Title : "+web_driver.getTitle());
		System.out.println("Navigation Successful");
	}
	
	public static void closeBrowser() {
		//web_driver.getWindowHandle();
		//web_driver.manage().window().setSize(Dimension 50);
		web_driver.quit();
		//web_driver.getWindowHandles().size();
		//web_driver.close();
//		if(browser_platform.contains("IE")) {
//			ModularRunForBrowsersPlatform ob_created = new ModularRunForBrowsersPlatform();
//		}
		System.out.println("Test Conpleted...");
	}

}
