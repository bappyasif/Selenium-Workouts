package multipleWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HandlingExamples {
	
	static String test_URL = "https://www.edureka.co/";
	static WebDriver web_driver;
	
	static String project_path;
	static JavascriptExecutor jsExecutor;
	
	public static void main(String[] args) {
		setpuBrowser();
		commenceNavigation();
		commenceTest();
		tearDown();
	}
	
	public static void setpuBrowser() {
		
		project_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",project_path+"\\Lib\\WebDrivers\\chromedriver.exe");
		
		web_driver = new ChromeDriver();
	}
	
	public static void commenceNavigation() {
		web_driver.get(test_URL);
		web_driver.manage().window().maximize();
		System.out.println("Navigation Successful");
	}
	
	public static void commenceTest() {
		WebElement search_input = web_driver.findElement(By.id("search-inp3"));
		search_input.click();
		WebElement search_overlays = web_driver.findElement(By.xpath("//input[@class=\"new-search-inp\"]"));
		//search_input.sendKeys("Selenium Certification");
		search_overlays.sendKeys("Selenium Certification");
		search_overlays.submit();
		
//		WebElement search_button = web_driver.findElement(By.xpath("//span[@class=\"typeaheadbutton\"]"));
//		search_button.click();
		
		jsExecutor = (JavascriptExecutor)web_driver;
		jsExecutor.executeScript("window.scrollBy(0,40)");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Actions actions = new Actions(web_driver);
		Action action;
		WebElement all_courses = web_driver.findElement(By.linkText("Courses"));
		//all_courses.click();
		//actions.sendKeys(all_courses, Keys.CONTROL).keyDown(all_courses, Keys.SHIFT).keyUp(all_courses, Keys.SHIFT).build();
		//actions.sendKeys(Keys.CONTROL).keyDown(Keys.SHIFT).click(all_courses).keyUp(Keys.SHIFT).build();
		action = actions
				.moveToElement(all_courses)
				.sendKeys(Keys.CONTROL)
//				.sendKeys(Keys.SHIFT)
				.keyDown(Keys.SHIFT)
				.click()
				.keyUp(Keys.SHIFT)
				.build();
		action.perform();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jsExecutor = (JavascriptExecutor)web_driver;
		jsExecutor.executeScript("window.scrollBy(0,100)");
	}
	
	public static void tearDown() {
		web_driver.quit();
		System.out.println("Test Done...");
	}

}