package testNGExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowsersParallelTesting {
	
	WebDriver web_driver;
	String base_URL = "https://www.google.com";
	//String base_URL = "https://www.goldgrizzly.com";
	
	
	@BeforeTest
	@Parameters("browserName")
	public void setupBrowser(String browserName) {
		
		System.out.println("Browser Running : "+browserName);
		
		System.out.println("Thread ID : "+Thread.currentThread().getId());
		
		System.out.println("Thread Name : "+Thread.currentThread().getName());
		
		System.out.println(("Thread Priority : "+Thread.currentThread().getPriority()));
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			web_driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("IE")) {
			InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
			internetExplorerOptions.ignoreZoomSettings();
			internetExplorerOptions.setCapability("ignoreProtectedModeSettings", true);
			WebDriverManager.iedriver().setup();
			web_driver = new InternetExplorerDriver(internetExplorerOptions);
		}
	}
	
	@Test(priority=0)
	public void navigationTest() {
		web_driver.get(base_URL);
		System.out.println("Navigation Successful");
	}
	
	@Test(priority=1)
	public void commenceTest() throws InterruptedException {
		web_driver.findElement(By.name("q")).sendKeys("AD");
		//Thread.sleep(2000);
		//web_driver.findElement(By.xpath("//form[@class='search-bar small--hide']//input[@placeholder='Search']")).sendKeys("AD");
		web_driver.findElement(By.name("btnK")).submit();
		//web_driver.findElement(By.id("search")).click();
	}
	
	@AfterTest
	public void tearDown( ) {
		web_driver.close();
		System.out.println("Test Done...");
	}

}
