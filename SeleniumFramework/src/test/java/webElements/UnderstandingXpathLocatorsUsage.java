package webElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnderstandingXpathLocatorsUsage {
	static String base_URL = "https://www.ebay.com/";
	static WebDriver web_driver;
	
	public static void main(String[] args) {
		setupBrowser();
		commenceNavigation();
		commenceTest();
		tearDown();
	}
	
	public static void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
	}
	
	public static void commenceNavigation() {
		web_driver.get(base_URL);
		System.out.println("Navigation Successful");
		//web_driver.manage().window().maximize();
		web_driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	public static void commenceTest() {
		
		WebElement search_box = web_driver.findElement(By.xpath("//input[@id=\"gh-ac\"]"));
		WebElement search_button = web_driver.findElement(By.xpath("//input[@id=\"gh-btn\"]"));
		
//		WebElement search_box = web_driver.findElement(By.cssSelector("[name^='_nkw']"));
//		WebElement search_button = web_driver.findElement(By.cssSelector("[class='gh-td gh-sch-btn']"));
		
		Actions action_builders = new Actions(web_driver);
		Action action_series = action_builders
				.moveToElement(search_box)
				.sendKeys(search_box, "Guitar")
				.click(search_button)
//				.keyDown(search_button, Keys.SHIFT)
//				.keyUp(search_button, Keys.SHIFT)
				.build();
		action_series.perform();
		web_driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		// Some XPath Creating Examples
		/*
		 * //input[@name="username"] | //input[@id="login-username"]
		 * //*[contains(text(),"& Orders")]
		 * //img[contains(@src="sprite")]
		 * //input[@name="username"]
		 * 
		 * */
	}
	
	public static void tearDown() {
		web_driver.quit();
		System.out.println("\n Test Done...");
	}
}
