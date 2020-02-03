package multipleWindows;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ExampleUsage {
	static String test_URL = "https://automationstepbystep.com/";
	static WebDriver web_driver;
	
	public static void main(String[] args) {
		setupBrowser();
		commenceNavigation();
		commenceTest();
		tearDown();
	}
	
	public static void setupBrowser() {
		String project_dir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", project_dir+"\\WebDrivers\\chromeDriver\\chromedriver.exe");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("pageLoadStrategy","none");
		web_driver = new ChromeDriver(chromeOptions);
	}
	
	public static void commenceNavigation() {
		web_driver.get(test_URL);
		System.out.println("Nvigation Successfull");
		
		web_driver.manage().window().maximize();
	}
	
	public static void commenceTest() {
		web_driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
//		WebElement menu_button = web_driver.findElement(By.cssSelector("#mobile-menu"));
//		menu_button.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Actions actions = new Actions(web_driver);
		Action action;
		
		WebElement selenium_course = web_driver.findElement(By.linkText("Selenium"));
		System.out.println(selenium_course.isDisplayed());
		
		actions.moveToElement(selenium_course).build().perform();
		WebElement selenium_menus = web_driver.findElement(By.xpath("//a[contains(text(),'Selenium TIPS')]"));
		System.out.println(selenium_menus.isDisplayed());
		//WebElement sub_menu = web_driver.findElement(By.cssSelector("body.page-template-default.page.page-id-153.layout-rightbar:nth-child(7) div.wrapper.clearfix:nth-child(2) header.clearfix:nth-child(1) div.topnav nav:nth-child(2) ul.top-menu.maxwidth.clearfix li.menu-item.menu-item-type-post_type.menu-item-object-page.current-menu-ancestor.current-menu-parent.current_page_parent.current_page_ancestor.menu-item-has-children.menu-item-89:nth-child(3) > a:nth-child(1)"));
		
		//By seBy = web_driver.findElement(By.xpath(""));
		getElementByLocator(selenium_menus);
		web_driver.manage().timeouts().pageLoadTimeout(4000, TimeUnit.MILLISECONDS);
		
		//selenium_menus.click();
		//sub_menu.click();
		
//		JavascriptExecutor jsExecutor = (JavascriptExecutor)web_driver;
//		jsExecutor.executeScript("arguments[0].click();", selenium_menus);
		
//		WebElement selenium_menu = web_driver.findElement(By.xpath("//span[@class=\"open-submenu\"]"));
//		System.out.println(selenium_menu.isDisplayed());
//		
//		selenium_menu.click();
		//selenium_course.click();
		//action = actions.click(selenium_course).build();
		action = actions
				.moveToElement(selenium_course)
				.keyDown(Keys.CONTROL)
				.keyDown(Keys.SHIFT)
				.click(selenium_course)
				.keyUp(Keys.SHIFT)
				.build();
		action.perform();
		
		
		web_driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static WebElement getElementByLocator(WebElement locator) {
		web_driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		WebElement webElement = null;
		int tries = 0;
		while(tries < 4) {
			try {
				webElement = locator;
				//webElement.click();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			} finally {
				tries++;
			}
		}
		web_driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		return webElement;
	}
	
	public static void tearDown(){
		web_driver.quit();
		System.out.println("Test Done...");
	}

}
