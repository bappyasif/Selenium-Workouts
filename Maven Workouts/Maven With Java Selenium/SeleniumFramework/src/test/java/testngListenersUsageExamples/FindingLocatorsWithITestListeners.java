package testngListenersUsageExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindingLocatorsWithITestListeners {
	
	static WebDriver web_driver;
	static String base_URL = "https://www.google.com";
	
	@BeforeSuite(description="Before Test Suite Annotation")
	public void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
	}
	
	@BeforeTest(description="Before Test Case Annotation")
	public void commenceNavigation() {
		web_driver.get(base_URL);
		System.out.println("Navigation Successful");
	}
	
	@Test
	public void commenceTest() {
		web_driver.findElement(By.name("q")).sendKeys("Selenium Automation");
		web_driver.findElement(By.name("btnK")).submit();
	}
	
	@AfterSuite
	public void tearDown() {
		web_driver.close();
		System.out.println("Test Done");
	}
}
