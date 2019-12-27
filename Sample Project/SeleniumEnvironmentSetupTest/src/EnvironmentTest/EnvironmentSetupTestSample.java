package EnvironmentTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnvironmentSetupTestSample {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","G:\\LatestEclipse\\Selenium Development\\chromedriver_win32\\chromedriver.exe");
		WebDriver web_driver = new ChromeDriver();
		web_driver.get("https://www.selenium.dev");
		web_driver.close();
	}

}
