package testNGExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCasesPriorityExample {
	
	static WebDriver web_driver;
	static String base_URL = "https://www.google.com";
	
	@BeforeTest
	public void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
		
		//System.out.println(context.getName());
	}
	
	@Test(priority = 1)
	public void commenceNavigation() {
		web_driver.get(base_URL);
		System.out.println("Navigation Successful");
		
		//System.out.println("Test Navigation");
		//System.out.println(result.getName());
	}
	
	@Test(priority = 2)
	public void commenceTest() {
		web_driver.findElement(By.name("q")).sendKeys("Selenium Automation");
		web_driver.findElement(By.name("btnK")).submit();
		
		//System.out.println("Test Case");
		//System.out.println(result.getName());
	}
	
	@Test(priority = -1)
	public void anotherTest() {
		
		web_driver.get("https://www.seleniumhq.org");
		
		//System.out.println("Another Test");
	}
	
	@Test(priority = 0)
	public void anotherExample() {
		
		web_driver.get("https://www.drive,google.com");
		
		//System.out.println("Another Example");
	}

	
	@AfterTest
	public void tearDown() {
		web_driver.close();
		System.out.println("Test Done");
		
		//System.out.println(context.getName());
	}

}
