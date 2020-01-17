package extentsReportsUsageExample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicUsageWithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extentReports;

	ExtentTest extentTest;

	private static WebDriver web_driver;
	static String base_URL= "https://www.google.com";

	static String searchText = "Selenium Automation Current Trends";

	@BeforeSuite
	public void setupEnvironment() {

		// Start Reporter(s)
		htmlReporter = new ExtentHtmlReporter("extentReports.html");

		// Create And Attach Reporter(s)
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);

		// Create A Toggle For The Given Test, Adds All Log Under It.
		extentTest = extentReports.createTest("Google Search Phrase Test", "To Make Sure It's Funtionality Working Accordingly Powered By TestNG Framework");
		extentTest.log(Status.INFO, "Extent Reports Environment Ready");
	}

	@BeforeTest
	public void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
		extentTest.info("Commencing Test");
	}

	@Test(priority=0)
	public void urlNavigation() {

		//		// Create A Toggle For The Given Test, Adds All Log Under It.
		//		extentTest = extentReports.createTest("Google Search Phrase Test", "To Make Sure It's Funtionality Working Accordingly Powered By TestNG Framework");

		web_driver.get(base_URL);
		extentTest.pass("Navigation Successful");

	}

	@Test(priority=1)
	public void commenceTest() {

		WebElement search_box = web_driver.findElement(By.name("q"));
		
		try {
			web_driver.findElement(By.id("lsb-id")).sendKeys(Keys.RETURN);
		} catch (Exception e) {
			// TODO: handle exception
			extentTest.fail("Element Uniteractable");
		}
		
		search_box.sendKeys(searchText);
		extentTest.pass("Search Phrase Entered Successfyully");

		try {
			web_driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		} catch (Exception e) {
			// TODO: handle exception
			extentTest.fail("Elemnt Uniteractable");
		}

		WebElement search_button = web_driver.findElement(By.name("btnK"));
		search_button.submit();
		extentTest.pass("Search Button Submitted Successfyully");
	}


	@AfterTest
	public void teardownBrowser() {

		web_driver.close();
		extentTest.log(Status.INFO, "Browser Closed");
	}

	@AfterSuite
	public void preparingReport() {

		extentReports.flush();
		extentTest.info("Test Done...");
	}

}
