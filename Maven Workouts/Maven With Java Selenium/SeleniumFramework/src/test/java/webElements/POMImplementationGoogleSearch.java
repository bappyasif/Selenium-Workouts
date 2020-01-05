package webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModelUsage.GoogleSearchObjectLocators;

public class POMImplementationGoogleSearch {
	
	private static WebDriver web_driver;
	static String base_URL= "https://www.google.com";

	static String searchText = "Selenium Automation Current Trends";

	public static void main(String[] args) {
		setupBrowser();
		commencingGoogleSearchTest();
		
		tearDown();
	}
	
	public static void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
	}
	
	public static void commencingGoogleSearchTest() {
		//web_driver.get(base_URL);
		GoogleSearchObjectLocators searchObject = new GoogleSearchObjectLocators(web_driver);
		
		web_driver.get(base_URL);
		
		System.out.println("Navigation Successful");
		
		searchObject.setGoogleSearchPhrase(searchText);
		
		searchObject.clickGoogleSearchButton();
		
	}
	
	public static void tearDown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		web_driver.close();
		System.out.println("Test Done...");
	}

}
