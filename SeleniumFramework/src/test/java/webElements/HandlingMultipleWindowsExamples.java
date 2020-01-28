package webElements;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.fasterxml.jackson.databind.Module.SetupContext;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleWindowsExamples {

	static String base_URL = "https://www.toolsqa.com/automation-practice-switch-windows/";
	//static String base_URL = "https://www.edureka.co/community/";
	static WebDriver web_driver;

	public static void main(String[] args) {
		setupBrowser();
		commenceNavigation();
		commenceTest();
		tearDown();
	}

	public static void setupBrowser() {
		WebDriverManager.chromedriver().setup();
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--headless");
//		web_driver = new ChromeDriver(chromeOptions);
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
		String getParentWindowHandle = web_driver.getWindowHandle();
		System.out.println("Parent Window : "+getParentWindowHandle);
		
		WebElement windowElemnt = web_driver.findElement(By.id("button1"));
		System.out.println(windowElemnt.isDisplayed());
		
		for(int counter = 0; counter < 3; counter++) {
//			Actions actions = new Actions(web_driver);
//			actions.click(windowElemnt);
			windowElemnt.click();
		}
		
		Set<String> allOpenedWindowHandles = web_driver.getWindowHandles();
		System.out.println("\n"+allOpenedWindowHandles);
		System.out.println(allOpenedWindowHandles.size());
		//Iterator<String> iterator = allOpenedWindowHandles.iterator();
		
		for(String handle : allOpenedWindowHandles) {
			System.out.println("Switching Window : "+handle);
			System.out.println(web_driver.getTitle());
			//System.out.println("Navagating To Google Site");
			//web_driver.switchTo().window(handle);
			//System.out.println(web_driver.switchTo().window(handle).getTitle());
			//web_driver.get("https://www.google.com/");
			//web_driver.switchTo().window(handle);
			//web_driver.close();
			//handle = iterator.next();
		}
		//web_driver.switchTo().window(getParentWindowHandle);
	}

	public static void edurekaCommunityPageExample() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)web_driver;
		String mainWindow = web_driver.getWindowHandle();
		System.out.println("Main Window : "+mainWindow);

		WebElement edurekaLink = web_driver.findElement(By.xpath("//a[@class=\"qa-logo-link edureka\"]"));
		edurekaLink.sendKeys(Keys.SHIFT, Keys.ENTER);
		//web_driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);

		jsExecutor.executeScript("window.scrollBy(0, 400)");
		//web_driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		Set<String> allOpenedWindowHandles = web_driver.getWindowHandles();
		System.out.println("Opened windows : "+allOpenedWindowHandles);

		//Iterator<String> iterator = allOpenedWindowHandles.iterator();
		Iterator<String> iterator = allOpenedWindowHandles.iterator();
		System.out.println(iterator.hasNext());
		while(iterator.hasNext()) {
			//Thread.sleep(2000);
			//web_driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
			jsExecutor.executeScript("window.scrollBy(0, 400)");
			//Thread.sleep(2000);
			//String childWindow = allOpenedWindowHandles.iterator().next();
			String childWindow = iterator.next();
			System.out.println(childWindow);

			if(!mainWindow.equals(childWindow)) {
				//WebDriver windowElelemnt = web_driver.switchTo().window(childWindow);
				web_driver.switchTo().window(childWindow);
				System.out.println(web_driver.switchTo().window(childWindow).getTitle());
				//System.out.println(web_driver.getTitle());
				web_driver.close();
				//web_driver.quit();
			}
		}
		web_driver.switchTo().window(mainWindow);
	}

	public static void toolsqaExample() {
		String getParentWindowHandle = web_driver.getWindowHandle();
		System.out.println("Parent Window Handle Is : "+getParentWindowHandle);;

		WebElement windowElement = web_driver.findElement(By.id("button1"));
		for(int count = 0; count < 3; count++) {
			windowElement.click();
			web_driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
		}

		Set<String> allOpenedWindowHandles = web_driver.getWindowHandles();
		for(String handle : allOpenedWindowHandles) {
			System.out.println("Window Handles : "+handle);
		}

	}

	public static void tearDown() {
		web_driver.quit();
		System.out.println("\n Test Done...");
	}

}
