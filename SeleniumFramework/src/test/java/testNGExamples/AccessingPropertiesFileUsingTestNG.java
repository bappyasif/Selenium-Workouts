package testNGExamples;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccessingPropertiesFileUsingTestNG {
	
	private static WebDriver web_driver;
	static String base_URL= "https://www.google.com";

	static String searchText = "Selenium Automation Current Trends";
	public static String browserPlatform;

	@BeforeTest
	public void setupBrowser() throws IOException {
		
		// With Already Implemented Properties FIle Accessing Class
		modularConfig.UsingPropertiesFileExample.accessPropertiesPairedValues();
		
		if(browserPlatform.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			web_driver = new ChromeDriver();
		}
		
		if(browserPlatform.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			web_driver = new InternetExplorerDriver();
		}
	}

	@Test(priority=0)
	public void urlNavigation() {
		web_driver.get(base_URL);
		System.out.println("Navigation Successful");
	}

	@Test(priority=1)
	public void commenceTest() {
		
		WebElement search_box = web_driver.findElement(By.name("q"));
		search_box.sendKeys(searchText);
		
		WebElement search_button = web_driver.findElement(By.name("btnK"));
		WebDriverWait driverWait = new WebDriverWait(web_driver, 2);
		driverWait.until(ExpectedConditions.elementToBeClickable(search_button));
	}
	
//	@Test(priority=2)
//	public void findElement() {
//		web_driver.get("https://www.seleniumhq.org");
////		WebElement foundElement = web_driver.findElement(By.xpath("whatIsSelenium?_heading3"));
////		foundElement.click();
//	}
	
	@AfterTest
	public void tearDown() {
		web_driver.close();
		System.out.println("Test Done...");
		// With Already Implemented Properties FIle Accessing Class
		modularConfig.UsingPropertiesFileExample.writeIntoPropertiesFile();
	}
}
