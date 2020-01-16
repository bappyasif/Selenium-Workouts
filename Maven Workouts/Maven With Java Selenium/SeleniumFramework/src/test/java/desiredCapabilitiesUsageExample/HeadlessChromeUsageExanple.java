package desiredCapabilitiesUsageExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessChromeUsageExanple {
	static WebDriver web_driver;
	static String base_URL = "https://www.google.com/";

	
	public static void main(String[] args) {
		setupBrowser();
		navigationMethod();
		findingElements();
		tearDown();
	}	
	
	
	public static void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		
		// Using Headless As An Argument For ChromeOptions Object Created.
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("window-size=1920,1080");
		//System.out.println(chromeOptions.getPlatform());
		
		web_driver = new ChromeDriver(chromeOptions);
	}

	public static void navigationMethod( ) {
		web_driver.get(base_URL);
	}

	public static void findingElements( ) {

		web_driver.findElement(By.name("q")).sendKeys("Selenium Automation");
		//web_driver.findElement(By.name("btnK")).sendKeys((Keys.RETURN));
		web_driver.findElement(By.name("btnK")).submit();
		
		System.out.println(web_driver.getTitle());

	}

	public static void tearDown() {
		web_driver.close();
		web_driver.quit();
		
		System.out.println("Test Done...");
	}
}
