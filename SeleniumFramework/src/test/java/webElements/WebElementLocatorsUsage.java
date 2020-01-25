package webElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementLocatorsUsage {
	
	static String base_URL = "https://login.yahoo.com/";
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
		//web_driver.manage().window().maximize();
		web_driver.manage().deleteAllCookies();
		web_driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
		web_driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		System.out.println("Navigation Successful");
	}
	
	public static void commenceTest() {
		
		web_driver.findElement(By.partialLinkText("Create")).click();
		web_driver.findElement(By.xpath("//input[@id=\"login-username\"]")).click();
		
	}
	
	public static void tearDown() {
		web_driver.quit();
		System.out.println("\n Test Done...");
	}
	
	public static void googleSearch() {
		WebElement search_box = web_driver.findElement(By.name("q"));
		WebElement search_button = web_driver.findElement(By.name("btnK"));
		
		Actions actions = new Actions(web_driver);
		actions.sendKeys(search_box, "Selenium").build().perform();
		//actions.click(search_button).build().perform();
		search_button.submit();
		web_driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
		web_driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	public static void yahooLogin() {
		Actions action_builders = new Actions(web_driver);
		
		WebElement user_id = web_driver.findElement(By.id("login-username"));
		//WebElement next_button = web_driver.findElement(By.id("login-signin"));
		WebElement next_button = web_driver.findElement(By.xpath("//input[@id=\"login-signin\"]"));
		System.out.println(next_button.isDisplayed());
		next_button.click();
			
		user_id.sendKeys("bappy_aiesec@yahoo.com");
		//next_button.click();
		action_builders.click(next_button);
		web_driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
		web_driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		try {
			WebElement troubleshoot_login = web_driver.findElement(By.linkText("Forgot username?"));
			troubleshoot_login.click();
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
		}
		
//		WebElement password_input = web_driver.findElement(By.id("login-passwd"));
//		WebElement next_login = web_driver.findElement(By.id("login-signin"));
//		
//		password_input.sendKeys("abracadabra");
//		next_login.click();

		
//		Action action_userID = action_builders
//				.moveToElement(user_id)
//				.sendKeys(user_id, "bappy_aiesec@yahoo.com")
//				.keyDown(next_button, Keys.SHIFT)
//				.keyUp(next_button, Keys.SHIFT)
//				.build();
//		action_userID.perform();
		
//		WebElement password_input = web_driver.findElement(By.id("login-passwd"));
//		WebElement next_login = web_driver.findElement(By.id("login-signin"));
//		
//		//Actions action_builders = new Actions(web_driver);
//		Action action_userPassword = action_builders
//				.moveToElement(password_input)
//				.sendKeys(password_input, "abracadabra")
//				.click(next_login)
//				.build();
//		action_userPassword.perform();
		
		WebElement user_input = web_driver.findElement(By.cssSelector("#login-username"));
		user_input.sendKeys("bappy_aiesec@yahoo.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement click_next = web_driver.findElement(By.cssSelector("#login-signin"));
		click_next.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Element Clicked");
	}

}
