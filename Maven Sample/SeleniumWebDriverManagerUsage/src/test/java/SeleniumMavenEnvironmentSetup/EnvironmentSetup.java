package SeleniumMavenEnvironmentSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnvironmentSetup {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver web_driver = new ChromeDriver();
		
		web_driver.get("hhtps://www.selenium.dev");
		//web_driver.wait();
		web_driver.close();
	}

}
