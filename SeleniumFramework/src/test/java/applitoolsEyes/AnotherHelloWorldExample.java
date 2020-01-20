package applitoolsEyes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnotherHelloWorldExample {

	static WebDriver web_driver;
	static String test_URL = "https://applitools.com/helloworld";

	static Eyes eyes;
	static String API_KEY = "aUSoC102Hm1uJ10854AJ98y10Zxwg8tJU110xO9899BTe2H105a5F4110"; 


	public static void main(String[] args) {
		setupBrowser();
		commenceTest();

		System.out.println("Test Done...");
	}


	public static void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
	}

	public static void commenceTest() {
		eyes = new Eyes();

		try {

			eyes.setApiKey(API_KEY);

			eyes.open(web_driver, "Hello World2", "Visual Test", new RectangleSize(800, 600));

			//web_driver.get(test_URL+"2");
			//web_driver.get(test_URL+"?diff1");
			web_driver.get(test_URL+"?diff2");

			WebElement fancy_title = web_driver.findElement(By.xpath("//div[@class='fancy title primary']"));
			System.out.println(fancy_title.isDisplayed());
			eyes.checkElement(fancy_title);
			eyes.checkWindow("World!");

			//WebElement user_input = web_driver.findElement(By.cssSelector("#name"));
			//user_input.sendKeys("aBappy");

			//WebElement click_button = web_driver.findElement(By.cssSelector("#button"));
			//System.out.println(click_button.isDisplayed());
			//eyes.checkElement(click_button);
			//click_button.click();
			eyes.checkWindow("Click Me!");

			eyes.close();

		} catch (Exception ex) {

			// TODO: handle exception
			System.out.println(ex.getCause());

		} finally {
			
			System.out.println("Test Done...");
			
			//web_driver.close();
			web_driver.quit();

			// End main test
			System.exit(0);

		}
	}

}
