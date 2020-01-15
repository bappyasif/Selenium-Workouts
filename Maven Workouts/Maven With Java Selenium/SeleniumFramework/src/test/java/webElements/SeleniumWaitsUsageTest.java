package webElements;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitsUsageTest {
	
	static WebDriver web_driver;
	static String base_URL = "https://www.google.com";
	
	static WebDriverWait driverWait;
	static String search_phrase = "Selenium";
	
	public static void main(String[] args) {
		setupBrowser();
		navigationMethod();
		findingElements();
		//seleniumImplicitlyWaitUsage();
		seleniumExplicitlyWaitUsage();
		tearDown();
	}
	
	public  static void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
	}
	
	public static void navigationMethod( ) {
		web_driver.get(base_URL);
	}
	
	public static void findingElements( ) {
		
		web_driver.findElement(By.name("q")).sendKeys(search_phrase);
		//web_driver.findElement(By.name("btnK")).sendKeys((Keys.RETURN));
		web_driver.findElement(By.name("btnK")).submit();
		
	}
	
	public static void seleniumImplicitlyWaitUsage() {
		
		// Implicitly Wait Executes On Thread Rather Than Any Particular Element.
		web_driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		web_driver.findElement(By.linkText("Selenium Wikipedia")).click();
	}
	
	public static void seleniumExplicitlyWaitUsage() {
		// Explicitly Wait Executes On A Specific Web Element To Be Visible.
		WebElement selenium_listing = web_driver.findElement(By.xpath("//h3[contains(text(),'Selenium (software) - Wikipedia')]"));
		driverWait = new WebDriverWait(web_driver, 2);
		driverWait.until(ExpectedConditions.elementToBeClickable(selenium_listing));
		selenium_listing.click();
		
		WebElement selenium_IDE = new WebDriverWait(web_driver, 2).
				until(ExpectedConditions.elementToBeClickable(web_driver.findElement
						(By.xpath("//span[@class='toctext'][contains(text(),'Selenium IDE')]"))));
		System.out.println(web_driver.getTitle());
		
	}
	
	public static void tearDown() {
		web_driver.close();
		web_driver.quit();
	}

}
