package webElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitUsageTest {
	
	static WebDriver web_driver;
	static String base_URL = "https://www.google.com";
	
	static String search_phrase = "abcd";
	static JavascriptExecutor scriptExecutor;
	
	public static void main(String[] args) {
		
		setupBrowser();
		navigationMethod();
		
		findingElements();
		fluentWaits();
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
	
	
	public static void pageScrolling() {
		scriptExecutor = (JavascriptExecutor)web_driver;
		scriptExecutor.executeScript("window.scrollBy(0,1250)");
	}
	
	
	public static void fluentWaits() {
		
		pageScrolling();
		//web_driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		web_driver.findElement(By.xpath("//a[@class='fl'][contains(text(),'2')]")).click();
		
		//scriptExecutor = (JavascriptExecutor)web_driver;
		scriptExecutor.executeScript("window.scrollBy(0,250)");
		WebElement link_text = web_driver.findElement(By.xpath("//h3[contains(text(),'Careers -ABCD Action for Boston Community Developm')]"));
		System.out.println(link_text);
		//WebElement link_text = web_driver.findElement(By.linkText("ABCD² Score for TIA - MDCalc"));
		
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(web_driver)
		  .withTimeout(Duration.ofSeconds(2))
		  .pollingEvery(Duration.ofSeconds(1))
		  .ignoring(NoSuchElementException.class);

		WebElement found_link = wait.until(new Function<WebDriver, WebElement>() {
		  public WebElement apply(WebDriver web_driver) {
		    WebElement find_link =  web_driver.findElement(By.xpath("//h3[contains(text(),'Careers -ABCD Action for Boston Community Developm')]"));
		    if (find_link.isEnabled()) {
				System.out.println("Element Visible");
			}
		    
		    return find_link;
		  }
		});
		
		found_link.click();
		//link_text.click();
	}
	
	public static void tearDown() {
		web_driver.close();
		//web_driver.quit();
	}

}
