package webElements;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.fasterxml.jackson.databind.Module.SetupContext;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleWindowsExamples {

	//static String base_URL = "https://www.toolsqa.com/automation-practice-switch-windows/";
	//static String base_URL = "https://www.edureka.co/community/";

	//static String base_URL = "https://www.naukri.com/";
	static String base_URL = "https://www.edureka.co/";
	static WebDriver web_driver;

	public static void main(String[] args) {
		setupBrowser();
		commenceNavigation();
		try {
			commenceTest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tearDown();
	}

	public static void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		//		ChromeOptions chromeOptions = new ChromeOptions();
		//		chromeOptions.addArguments("--disable-features=VizDisplayCompositor");
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

	public static void commenceTest() throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)web_driver;
		String page_title = "";
		
		Actions action_builders = new Actions(web_driver);
		
		page_title = web_driver.getTitle();
		System.out.println("Page Title : "+page_title);
		
		WebElement search_input = web_driver.findElement(By.cssSelector("#search-inp3"));
		System.out.println(search_input.isDisplayed());
		//search_input.sendKeys("Selenium Certification");
		//action_builders.sendKeys(search_input, "Selenium Certifications");
		//action_builders.moveToElement(search_input).sendKeys(search_input, "Selenium Certifications");
		//web_driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
		Thread.sleep(2000);
		//jsExecutor.executeScript("window.scrollBy(0,40)");
		//web_driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
		Thread.sleep(2000);
		WebElement search_icon = web_driver.findElement(By.xpath("//span[@class=\"typeahead__button new_search_typeahead_button\"]"));
		System.out.println(search_icon.isDisplayed());
		//action_builders.click(search_icon);
		WebElement courses_menu = web_driver.findElement(By.xpath("//li[@class='ga-allcourses']//a[@class='giTrackElementHeader'][contains(text(),'Courses')]"));
		
		//Actions action_builders = new Actions(web_driver);
		//action_builders.sendKeys(Keys.CONTROL).keyDown(Keys.SHIFT).click(courses_menu).keyUp(Keys.SHIFT).build();
		Action action_series = action_builders.moveToElement(search_input)
				.sendKeys(search_input, "Selenium Certifications")
				.moveToElement(search_icon)
				.click(search_icon)
//				.keyDown(Keys.CONTROL)
				.keyDown(search_icon, Keys.SHIFT)
				.keyUp(search_icon, Keys.SHIFT)
				.build();
		action_series.perform();
//		search_input.submit();
		//search_icon.submit();
		action_builders.sendKeys(Keys.CONTROL).keyDown(Keys.SHIFT).click(courses_menu).keyUp(Keys.SHIFT).build();
		Thread.sleep(2000);
		
		Set<String> openedWindows = web_driver.getWindowHandles();
		System.out.println("How Many Windows Are Opened : "+openedWindows.size());
		System.out.println(openedWindows);
		System.out.println("First Chekpoint");
		
		for(String window : openedWindows) {
			String check_title = web_driver.getTitle();
			System.out.println("Current Page Title Is : "+check_title);
			web_driver.switchTo().window(window);
			if(web_driver.getTitle().contains("Best Training")) {
				System.out.println("Second Chekpoint");
				jsExecutor.executeScript("window.scrollBy(0,1000)");
				//web_driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
				Thread.sleep(2000);
				System.out.println("Third Chekpoint");
				WebElement all_courses = web_driver.findElement(By.linkText("All Courses"));
				action_builders.moveToElement(all_courses).click();
				web_driver.manage().window().setPosition(new Point(-2000, 0));
				System.out.println("Fourth Chekpoint");
				Thread.sleep(2000);
			}
		}
		
		Thread.sleep(2000);
		
		Set<String> allWindows = web_driver.getWindowHandles();
		System.out.println("Currently Opened : "+allWindows.size());
		System.out.println(allWindows);
		System.out.println("Fifth Chekpoint");
		
		for(String handle : allWindows) {
			web_driver.switchTo().window(handle);
			System.out.println("Sixth Chekpoint");
			jsExecutor.executeScript("window.scrollBy(0, 400)");
			Thread.sleep(2000);
		}
	}

	public static void testOnSiteNaukri( ) {
		
		String getParentWindowHandle = web_driver.getWindowHandle();
		Set<String> allWindows = web_driver.getWindowHandles();

		Iterator<String> iterator = allWindows.iterator();
		while(iterator.hasNext()) {
			String childWindow = iterator.next();
			if(!getParentWindowHandle.equalsIgnoreCase(childWindow)) {
				web_driver.switchTo().window(childWindow);
				System.out.println(web_driver.switchTo().window(childWindow).getTitle());
				web_driver.close();
			}
		}
		web_driver.switchTo().window(getParentWindowHandle);
		System.out.println(web_driver.getTitle());
		
	}

	public static void yetAnotherExampleTest() {
		String getParentWindowHandle = web_driver.getWindowHandle();
		System.out.println("Parent Window : "+getParentWindowHandle);

		WebElement webElement = web_driver.findElement(By.id("button1"));
		System.out.println(webElement.isDisplayed());

		for(int i=0; i<3; i++) {
			webElement.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Set<String> allOpenedWindowHandles = web_driver.getWindowHandles();
		String last_handles = "";

		for(String handle : allOpenedWindowHandles) {
			System.out.println("Swtching To : "+handle);
			web_driver.switchTo().window(handle);
			System.out.println(web_driver.getTitle());
			last_handles = handle;
		}
		web_driver.switchTo().window(getParentWindowHandle);
		web_driver.close();
		web_driver.switchTo().window(last_handles);
		System.out.println(web_driver.getPageSource());
	}

	public static void anotherQaToolsTest() {

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
			//web_driver.switchTo().window(handle);
			//web_driver.get("https://www.goldgrizzly.com/");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("Navagating To Google Site");
			web_driver.switchTo().window(handle);
			//System.out.println(web_driver.getTitle());
			//System.out.println(web_driver.switchTo().window(handle).getTitle());
			//web_driver.get("https://www.google.com/");
			//web_driver.switchTo().window(handle);
			//web_driver.close();
			//handle = iterator.next();
		}

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