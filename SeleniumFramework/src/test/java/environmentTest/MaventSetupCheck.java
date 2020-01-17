package environmentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaventSetupCheck {
	
	static String base_URL = "http://www.seleniumhq.org/";
	static String project_dir = System.getProperty("user.dir");
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", project_dir+"\\Lib\\Web Drivers\\Chrome Driver\\chromedriver.exe");
		WebDriver web_driver = new ChromeDriver();
		web_driver.get(base_URL);
		Thread.sleep(2000);
		web_driver.close();
		System.out.println("Test Done...");
	}
	
}
