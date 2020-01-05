package webElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import pageObjectModelUsage.GoogleSearchPageObjects;

public class GoogleSearchUsingPOM {

	private static WebDriver web_driver;
	static String base_URL= "https://www.google.com";

	static String searchText = "Selenium Automation Current Trends";

	public static void main(String[] args) {
		setupBrowser();
		try {
			commenceTest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tesrDown();
	}

	public static void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
	}

	public static void commenceTest() throws InterruptedException {

		web_driver.get(base_URL);

		System.out.println("Navigation Successful");

//		WebElement googleSearchTextbox = web_driver.findElement(By.name("q"));
//
//		googleSearchTextbox.sendKeys(searchText);
		
		GoogleSearchPageObjects.googleSearchTextBox(web_driver).sendKeys(searchText);
		
		//WebElement searchButton = web_driver.findElement(By.name("btnK"));
		WebElement searchButton = GoogleSearchPageObjects.clickGoogleSearchButton(web_driver);
		//searchButton.click();
		
		// Using WebDriverWait 
		WebDriverWait driver_wait = new WebDriverWait(web_driver, 8);
		driver_wait.until(ExpectedConditions.elementToBeClickable(searchButton));
	}

	public static void tesrDown() {
		web_driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		web_driver.close();
		System.out.println("Test Done...");
	}

}
