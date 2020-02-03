package com.example.selenium.webElememts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingMultipleWindowsExample {
	
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
		web_driver.manage().window().maximize();
		web_driver.manage().deleteAllCookies();
		web_driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
		web_driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		System.out.println("Navigation Successful");
	}

	public static void commenceTest() throws InterruptedException {
		Actions actions = new Actions(web_driver);
		Action action;
		
		JavascriptExecutor jsExecutor;

		WebElement search_input = web_driver.findElement(By.id("search-inp3"));
		search_input.click();
		WebElement search_overlays = web_driver.findElement(By.xpath("//input[@class=\"new-search-inp\"]"));
		//search_input.sendKeys("Selenium Certification");
		search_overlays.sendKeys("Selenium Certification");
		search_overlays.submit();


		jsExecutor = (JavascriptExecutor)web_driver;
		jsExecutor.executeScript("window.scrollBy(0,40)");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		Actions actions = new Actions(web_driver);
//		Action action;

		WebElement scroll_tag = web_driver.findElement(By.xpath("//h2[contains(text(),'Discover Top Categories')]"));
		actions.moveToElement(scroll_tag);
		actions.perform();

		String getParentWindowHandle = web_driver.getWindowHandle();
		System.out.println(getParentWindowHandle);

		WebElement all_courses = web_driver.findElement(By.linkText("Courses"));


		action = actions
				.moveToElement(all_courses)
				.sendKeys(Keys.CONTROL)
				//				.sendKeys(Keys.SHIFT)
				.keyDown(Keys.SHIFT)
				.click()
				.keyUp(Keys.SHIFT)
				.build();
		action.perform();
		web_driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.MILLISECONDS);
		Thread.sleep(8000);


		String courses_title = web_driver.getTitle(); 
		System.out.println(courses_title);

		if(courses_title.contains("Best Training")) {
			WebElement courses_list = web_driver.findElement(By.xpath("//a[@class='active']"));
			System.out.println(courses_list.isDisplayed());
			actions.moveToElement(courses_list).click().perform();
		}


		Set<String> allOpenedWindowsHandle = web_driver.getWindowHandles();
		System.out.println(allOpenedWindowsHandle.size());
		System.out.println(allOpenedWindowsHandle);

		web_driver.manage().window().setPosition(new Point(-600, 0));
		System.out.println("Second Checkpoint");
		Thread.sleep(4000);
		jsExecutor.executeScript("window.scrollBy(0,99)");
		Thread.sleep(4000);
		System.out.println("Third Checkpoint");

		for(String window : allOpenedWindowsHandle) {
			String check_title = web_driver.getTitle().toString();
			System.out.println(check_title);
			web_driver.switchTo().window(window);
			if(check_title.contains("Led Online")) {
				jsExecutor.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(4000);
				System.out.println("First Checkpoint");
				break;
			}
		}

	}
	
	public static void tearDown() {
		web_driver.quit();
		System.out.println("\n Test Done...");
	}

}
