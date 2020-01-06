package extentsReportsUsageExample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicUsage {
	
	static WebDriver web_driver;
	static String base_URL = "https://www.google.com";
	
	static String search_phrase = "Automation Selenium";
	
	public static void main(String[] args) {
		
		// Start Reporter(s)
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		// Create And Attach Reporter(s)
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
		
		// Create A Toggle For The Given Test, Adds All Log Under It.
		ExtentTest extentTest = extentReports.createTest("Google Search Phrase Test", "To Make Sure It's Funtionality Working Accordingly.");
				
		// Commencing Google Search Example
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
		
		extentTest.log(Status.INFO, "Commencing Test");
		
		web_driver.get(base_URL);
		extentTest.pass("Navigation Successful");
		
		web_driver.findElement(By.name("q")).sendKeys(search_phrase);
		extentTest.pass("Seatrch Phrase Entered Successfully");
		
		try {
			web_driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		} catch (Exception e) {
			// TODO: handle exception
			extentTest.fail("Elemnt Uniteractable");
		}
		
		web_driver.findElement(By.name("btnK")).submit();
		extentTest.pass("Search Query Submitted Successfully");
		
		System.out.println("Page Title: "+web_driver.getTitle());
		extentTest.log(Status.INFO, "Search Done");
		
		web_driver.close();
		extentTest.pass("Closed Browser");
		
		extentTest.info("Test Completed");
		
		// Calling Flush To Write Everything To Log File
		extentReports.flush();
		
	}	

}
