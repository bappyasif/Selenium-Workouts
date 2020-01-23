package webElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropW3Schools {
	
	static String base_URL = "https://www.w3schools.com/html/html5_draganddrop.asp";
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
		web_driver.manage().window().maximize();
		web_driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	public static void commenceTest() {
		Actions action_builders = new Actions(web_driver);
		
		WebElement drag_source = web_driver.findElement(By.id("div1"));
		WebElement drop_target = web_driver.findElement(By.id("div2"));
		
		action_builders.clickAndHold(drag_source);
		action_builders.dragAndDrop(drag_source, drop_target);
	}
	
	public static void tearDown() {
		web_driver.quit();
		System.out.println("\n Test Done...");
	}
	

}
