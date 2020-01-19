package sauceLabs;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnotherExample {
	public static final String USERNAME = "aBappy";
	public static final String ACCESS_KEY = "2bf5572f-5cbc-4e6a-8c73-a480a3719633";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	static String base_URL = "https://www.saucedemo.com/";
	static WebDriver web_driver;

	public static void main(String[] args) throws MalformedURLException {
		//WebDriverManager.chromedriver().setup();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("username", USERNAME);
		capabilities.setCapability("accessKey", ACCESS_KEY);
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("version", "79.0");
		capabilities.setCapability("build", "Onboarding Sample App - Java-TestNG");
		capabilities.setCapability("name", "3-cross-browser");

		web_driver = new RemoteWebDriver(new URL(URL), capabilities);

		commenceLogin();

		System.out.println("Test Done...");
		web_driver.close();

	}

	public static void commenceLogin() {
		// Perform actions on HTML elements, entering text and submitting the form
		WebElement usernameElement     = web_driver.findElement(By.xpath("//input[@id='user-name']"));
		WebElement passwordElement     = web_driver.findElement(By.xpath("//input[@id='password']"));
		//WebElement formElement        = web_driver.findElement(By.id("loginForm"));

		usernameElement.sendKeys("standard_user");
		passwordElement.sendKeys("secret_sauce");

		//passwordElement.submit(); // submit by text input element
		//formElement.submit();        // submit by form element
		web_driver.findElement(By.xpath("//input[@class='btn_action']")).click();
	}
}
