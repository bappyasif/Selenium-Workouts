package desiredCapabilitiesUsageExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCpabilitiesEnvironmentTest {

	static WebDriver web_driver;
	static String base_URL = "https://www.google.com";

	static DesiredCapabilities desiredCapabilities;

	public static void main(String[] args) {

		//usingIE(); // Will Cause Protective Mode Browsing Exception.
		usingChrome();
		tearDown();

		try {
			usingIE();
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

		tearDown();

	}

	public static void usingChrome() {

		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();

		web_driver.get(base_URL);
		web_driver.findElement(By.name("q")).sendKeys("Selenium Automation");
		web_driver.findElement(By.name("btnK")).submit();

	}


	public static void usingIE() {

		// Using Driver Absolute Path
		//String project_path = System.getProperty("user.dir");
		//System.setProperty("webdriver.ie.driver", project_path+"\\Lib\\Web Drivers\\IE Driver\\IEDriverServer.exe");

		// Using WebDriverManager
		WebDriverManager.iedriver().setup();
		
		// DesiredCapabilities For IE Has Been Deprecated.
		
		//desiredCapabilities.setCapability("ignoreProtectedModeSettings	", false);
		//web_driver = new InternetExplorerDriver(desiredCapabilities);

		// To Overcome Protective Mode Exception Of IE Driver 
		// We Will Employ InternetExplorerOptions.
		InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
		//desiredCapabilities.setCapability("ignoreProtectedModeSettings", false);
		//desiredCapabilities.setCapability(internetExplorerOptions.setCapability("ignoreProtectedModeSettings", false));

		internetExplorerOptions.setCapability("ignoreProtectedModeSettings", true);
		web_driver = new InternetExplorerDriver(internetExplorerOptions);

		web_driver.get(base_URL);
		web_driver.findElement(By.name("q")).sendKeys("Seas");
		web_driver.findElement(By.name("btnK")).submit();
	}

	public static void tearDown() {

		//desiredCapabilities = (DesiredCapabilities) ((RemoteWebDriver)web_driver).getCapabilities();

		String browser_name = ((RemoteWebDriver)web_driver).getCapabilities().getBrowserName().toLowerCase();

		if(browser_name.contains("chrome")) {
			web_driver.close();
			web_driver.quit();
		}

		System.out.println(browser_name);
		if(browser_name.contains("internet explorer")) {
			web_driver.quit();
			//web_driver.close();
		}

		System.out.println("Test Done...");
	}

}
