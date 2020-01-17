package webElements;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindingLocators {
	
	static String base_URL = "http://www.google.com/";
	
	static WebDriver web_driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
		web_driver.get(base_URL);
		web_driver.findElement(By.name("q")).sendKeys("Selenium Automation");
		//WebElement searchBox = web_driver.findElement(By.id("lst-ib"));
		//WebElement searchBox = web_driver.findElement(By.className("gLFyf gsfi"));
		//WebElement searchBox = web_driver.findElement(By.name("q"));
		WebElement searchBox = web_driver.findElement(By.xpath("//input[@name=\"q\"]"));
		searchBox.submit();
		java.util.List<WebElement> webListOfElements = web_driver.findElements(By.xpath("//input"));
		int count = webListOfElements.size();
		System.out.println("Input Elements Options Available  : "+count);
		
		web_driver.close();
	}

}
