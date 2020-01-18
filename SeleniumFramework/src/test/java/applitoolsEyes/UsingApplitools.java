package applitoolsEyes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

import io.github.bonigarcia.wdm.WebDriverManager;


public class UsingApplitools {
	
	static WebDriver web_driver;
	static String test_URL = "https://applitools.com/helloworld";
		
	public static void main(String[] args) {
		commenceApplitoolsEyesTest();
	}
	
	
	public static void commenceApplitoolsEyesTest() {

		WebDriverManager.chromedriver().setup();

		//Use Chrome browser
		web_driver = new ChromeDriver();

		// Initialize the eyes SDK and set your private API key.
		Eyes eyes = new Eyes();

		// Set the API key from the env variable. Please read the "Important Note"
		// section above.
		eyes.setApiKey("aUSoC102Hm1uJ10854AJ98y10Zxwg8tJU110xO9899BTe2H105a5F4110");

		try {

			// Start test and set the browser to these specifics
			eyes.open(web_driver,"Hello World!", "Selenium Hands On Visual Validation Test", new RectangleSize(800,600));

			// navvigate to Hello World website.
			//driver.get("http://applitools.com/helloworld");

			// Navigating another version of this page
			// driver.get("https://applitools.com/helloworld?diff1");

			// Navigating to the other one version of this page
			//web_driver.get("https://applitools.com/helloworld?diff2");
			//web_driver.get(test_URL+"?diff1");
			web_driver.get(test_URL+"?diff2");

			// Visual Checkpoint #01
			eyes.checkWindow("Hello!");

			// Click the button says 'Click Me!'
			web_driver.findElement(By.tagName("button")).click();

			// Visual Checkpoint #02
			eyes.checkWindow("Click!");

			eyes.close();

		} catch (Exception e) {

			System.out.println(e);

		} finally {

			// Close the browser.
			web_driver.quit();

			// End main test
			System.exit(0);

		}
	}


}
