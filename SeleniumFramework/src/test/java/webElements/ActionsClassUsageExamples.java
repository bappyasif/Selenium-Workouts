package webElements;

import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassUsageExamples {
	static String base_URL = "https://www.edureka.co/";
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
		Actions actions_builder = new Actions(web_driver);
		// Move To Categories Element
		WebElement categories_options = web_driver.findElement(By.id("header_topcat"));
		actions_builder.moveToElement(categories_options).build().perform();
		web_driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		
		// Move To Software Testing
		WebElement software_testing = web_driver.findElement(By.cssSelector("#software-testing-certification-courses"));
		actions_builder.moveToElement(software_testing).build().perform();
		web_driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		
		// Click Software Testing Link
		WebElement click_link = web_driver.findElement(By.xpath("//ul[@class=\"dropdown-menu\"]//li //a[text()=\"Software Testing\"]"));
		click_link.click();
		web_driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		
		// Using Search Box Element
		WebElement search_input = web_driver.findElement(By.id("search-inp3"));
		actions_builder.moveToElement(search_input).build().perform();
		web_driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		
		WebElement search_button = web_driver.findElement(By.xpath("//span[@class=\"typeahead__button new_search_typeahead_button\"]"));
		actions_builder.moveToElement(search_button).build().perform();
		web_driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
		
		// Performing Series Of Actions
		org.openqa.selenium.interactions.Action seriesOfActions;
		//Action seriesOfActions;
		seriesOfActions = actions_builder
				.sendKeys(search_input, "Selenium")
				.keyDown(search_button, Keys.SHIFT)
				.keyUp(search_button, Keys.SHIFT)
				.build();
		seriesOfActions.perform();
		web_driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
	}
	
	public static void tearDown() {
		web_driver.quit();
		System.out.println("\n Test Done...");
	}
}
