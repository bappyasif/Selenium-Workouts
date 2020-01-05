package pageObjectModelUsage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPageObjects {
	
	private static WebElement searchBox;
	private static WebElement searchButton;
	
	public static WebElement googleSearchTextBox(WebDriver webDriver) {
	
		searchBox = webDriver.findElement(By.name("q"));
		return searchBox;
		
	}
	
	public static WebElement clickGoogleSearchButton (WebDriver webDriver) {
		
		searchButton =  webDriver.findElement(By.name("btnK"));
		return searchButton;
	}

}
