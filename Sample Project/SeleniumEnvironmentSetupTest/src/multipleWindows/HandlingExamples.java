package multipleWindows;

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

public class HandlingExamples {
	
	static String test_URL = "https://www.edureka.co/";
	static WebDriver web_driver;
	
	static String project_path;
	static JavascriptExecutor jsExecutor;
	
	public static void main(String[] args) throws InterruptedException {
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
	
	public static void commenceTest() throws InterruptedException {
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
		
		WebElement scroll_tag = web_driver.findElement(By.xpath("//h2[contains(text(),'Discover Top Categories')]"));
		actions.moveToElement(scroll_tag);
		actions.perform();
		
		String getParentWindowHandle = web_driver.getWindowHandle();
		System.out.println(getParentWindowHandle);
		
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
		web_driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.MILLISECONDS);
		Thread.sleep(8000);
		
//		WebElement scroll_point = web_driver.findElement(By.xpath("//a[@class='giTrackElement'][contains(text(),'Programming & Frameworks')]"));
//		WebElement click_course = web_driver.findElement(By.xpath("//h3[contains(text(),'Selenium Certification Training')]"));
//		actions.moveToElement(scroll_point);
//		actions.perform();
		
//		action = actions.moveByOffset(0, 200).build();
//		action.perform();
		
		jsExecutor.executeScript("window.scrollBy(0,100)");
		
//		action = actions.moveToElement(click_course).click().build();
//		action.perform();
		
//		System.out.println(click_course.isDisplayed());
//		action = actions
//				.moveToElement(click_course)
//				.sendKeys(Keys.CONTROL)
//				.keyDown(Keys.SHIFT)
//				.click(click_course)
//				.click()
//				.click(click_course)
//				.keyUp(Keys.SHIFT)
//				.build();
//		action.perform();
		
		String courses_title = web_driver.getTitle(); 
		System.out.println(courses_title);
		
		if(courses_title.contains("Best Training")) {
			WebElement courses_list = web_driver.findElement(By.xpath("//a[@class='active']"));
			System.out.println(courses_list.isDisplayed());
			actions.moveToElement(courses_list).click().perform();
		}
		//click_course.click();
//		action = actions
//				.moveByOffset(0, 100)
//				.moveToElement(scroll_point)
//				.click()
////				.click(scroll_point)
//				.build();
//		action.perform();
		
		//jsExecutor.executeScript("arguments[0].scrollIntoView(false);", scroll_point);
		
		//jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");
		
//		jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//jsExecutor.executeScript("window.scrollTo({ left: 0, top: document.body.scrollHeight, behavior: \"smooth\" });");
		
//		actions.moveToElement(scroll_tag);
//		actions.perform();
//		jsExecutor.executeScript("window.scrollBy(0,200)");
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//WebElement scroll_tag = web_driver.findElement(By.xpath("//h2[contains(text(),'Discover Top Categories')]"));
//		actions.moveToElement(scroll_tag, 0, -100).perform();
//		action = actions.moveToElement(scroll_tag, 0, -100).build();
//		action.perform();
//		actions.perform();
		
		
//		JavascriptExecutor scriptExecutor;
//		scriptExecutor = (JavascriptExecutor)web_driver;
//		scriptExecutor.executeScript("window.scrollBy(0,650)");
//		scriptExecutor.executeScript("document.querySelector('body').scrollTop-=100;");
		
//		WebElement courses_list = web_driver.findElement(By.xpath("//a[@class='active']"));
//		System.out.println(courses_list.isDisplayed());
		
		Set<String> allOpenedWindowsHandle = web_driver.getWindowHandles();
		System.out.println(allOpenedWindowsHandle.size());
		System.out.println(allOpenedWindowsHandle);
		
//		WebElement courses_list = web_driver.findElement(By.xpath("//a[@class='active']"));
//		System.out.println(courses_list.isDisplayed());
//		actions.moveToElement(courses_list).click().perform();
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
		
//		WebElement all_courses = web_driver.findElement(By.linkText("Courses"));
//		//all_courses.click();
//		//actions.sendKeys(all_courses, Keys.CONTROL).keyDown(all_courses, Keys.SHIFT).keyUp(all_courses, Keys.SHIFT).build();
//		//actions.sendKeys(Keys.CONTROL).keyDown(Keys.SHIFT).click(all_courses).keyUp(Keys.SHIFT).build();
//		action = actions
//				.moveToElement(all_courses)
//				.sendKeys(Keys.CONTROL)
////				.sendKeys(Keys.SHIFT)
//				.keyDown(Keys.SHIFT)
//				.click()
//				.keyUp(Keys.SHIFT)
//				.build();
//		action.perform();
//		web_driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.MILLISECONDS);
//		Thread.sleep(8000);

	}
	
	public static void tearDown() {
		web_driver.quit();
		System.out.println("Test Done...");
	}

}
