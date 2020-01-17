package sauceLabs;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumTest {

	public static final String USERNAME = "aBappy";
	public static final String ACCESS_KEY = "2bf5572f-5cbc-4e6a-8c73-a480a3719633";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	static String base_URL = "https://www.google.com";
	static WebDriver web_driver;

	public static void main(String[] args) throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("username", USERNAME);
		capabilities.setCapability("accessKey", ACCESS_KEY);
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("version", "79.0");
		capabilities.setCapability("build", "Onboarding Sample App - Java-TestNG");
		capabilities.setCapability("name", "3-cross-browser");

		/** If you're accessing the EU data center, use the following endpoint:.
		 * https://ondemand.eu-central-1.saucelabs.com/wd/hub
		 * */
		web_driver = new RemoteWebDriver(new URL(URL), capabilities);

		commenceTest();

		System.out.println("Test Done...");
		web_driver.close();

	}


	public static void commenceTest() {
		web_driver.get(base_URL);
		web_driver.findElement(By.name("q")).sendKeys("Selenium Automation");
		web_driver.findElement(By.name("btnK")).submit();
		System.out.println(web_driver.getTitle());
	}

}
