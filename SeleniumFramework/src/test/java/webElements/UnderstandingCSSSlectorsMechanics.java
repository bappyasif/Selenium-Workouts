package webElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UnderstandingCSSSlectorsMechanics {
	
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
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor)web_driver;
		
		WebElement search_input = web_driver.findElement(By.cssSelector("#gh-ac"));
		WebElement search_area = web_driver.findElement(By.cssSelector("[name^='_nkw']"));
		System.out.println(search_area.isDisplayed());
		//search_input.sendKeys("OnePlus6T");
		search_area.sendKeys("Samsung");
		
		WebElement search_button = web_driver.findElement(By.cssSelector("#gh-btn"));
		WebElement search_icon = web_driver.findElement(By.cssSelector("[class='gh-td gh-sch-btn']"));
		System.out.println(search_icon.isDisplayed());
		//search_button.click();
		search_icon.click();
		
		jsExecutor.executeScript("window.scrollBy(0,300)");
		//WebElement item_searched = web_driver.findElement(By.cssSelector("span[class*=item__price]"));
		WebElement item_searched = web_driver.findElement(By.cssSelector("div>span.s-item__price"));
		System.out.println(item_searched.isDisplayed());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// CSS Web Locators Examples
		// div>span.s-item__price
		// span[class*=s-item__price]
		// span[class=s-item__price]
		// span[class*=item__price]
		
		
//		search_input.sendKeys("Samsung");
//		search_icon.click();
		
//		search_area.sendKeys("Samsung");
//		search_icon.click();
		
//		action_builders.sendKeys(search_input, "Samsung").click(search_button);
//		action_builders.sendKeys(search_area, "Samsung").click(search_icon);
//		action_builders.moveToElement(search_area).sendKeys(search_area, "Samsung");
//		action_builders.moveToElement(search_icon).click(search_icon);
		
		
		//Action action_series = action_builders.sendKeys(search_area, "Samsung").keyDown(search_icon, Keys.SHIFT).keyUp(search_icon, Keys.SHIFT).build();
		
	}
	
	public static void tearDown() {
		web_driver.quit();
		System.out.println("\n Test Done...");
	}
	
	public static void testAction(Actions action_builders, WebElement searchBox, WebElement searchBtn) {

		Action action_series = action_builders
				.sendKeys(searchBox, "Iphone11")
				.keyDown(searchBtn, Keys.SHIFT)
				.keyUp(searchBtn, Keys.SHIFT)
				.build();
		
		action_series.perform();
		
		try {
			
			Thread.sleep(2000);
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.getStackTrace();
		}

	}
	
	public static void usingXpath() {
		WebElement search_xpath = web_driver.findElement(By.xpath("//input[@id='gh-ac']"));
		WebElement button_xpath = web_driver.findElement(By.xpath("//input[@id='gh-btn']"));
		
		Actions action_builders = new Actions(web_driver);
		
		Action action_series = action_builders
				.moveToElement(search_xpath)
				.sendKeys(search_xpath, "Samsung")
				.click(button_xpath)
				.build();
		action_series.perform();
		
		testAction(action_builders, search_xpath, button_xpath);
	}

}
