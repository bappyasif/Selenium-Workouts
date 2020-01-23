package webElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropActions {
	
	static String base_URL = "https://jqueryui.com/droppable/";
	static WebDriver web_driver;
	
	public static void main(String[] args) throws InterruptedException {
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
		web_driver.manage().window().maximize();
		web_driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	public static void commenceTest() throws InterruptedException {
		// Switch To Iframe Window
		// Index Is 0 Because There Is Only One IFrame Present In That Page.
		web_driver.switchTo().frame(0);
		
		// Finding Locators For Drag And Drop
		WebElement drag_source = web_driver.findElement(By.id("draggable"));
		WebElement drop_target = web_driver.findElement(By.id("droppable"));
		
		// Creating Actions Class Object
		Actions actoion_builder = new Actions(web_driver);
		Thread.sleep(2000);
		
		// Initiating Drag And Drop
		actoion_builder.dragAndDrop(drag_source, drop_target);
		Thread.sleep(2000);
		
		// Initiating Click And Hold Which Is Alternate To Drag And Drop
		actoion_builder.clickAndHold(drag_source).moveToElement(drop_target).release().build().perform();
		Thread.sleep(2000);
	}
	
	public static void tearDown() {
		web_driver.quit();
		System.out.println("\n Test Done...");
	}

}
