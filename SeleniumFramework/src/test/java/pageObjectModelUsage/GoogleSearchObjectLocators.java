package pageObjectModelUsage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchObjectLocators {
	
	private static WebDriver web_driver;
	
	// Object Locators
	By google_search_text_box = By.name("q");
	
	By google_search_box_button =  By.name("btnK");

	// Calling Constructor
	public GoogleSearchObjectLocators (WebDriver webDriver) {
		this.web_driver = webDriver;
	}
	
	// Object Actions
	public void setGoogleSearchPhrase(String searchText) {
		web_driver.findElement(google_search_text_box).sendKeys(searchText);
	}
	
	public void clickGoogleSearchButton() {
		try {
			web_driver.findElement(google_search_box_button).sendKeys(Keys.RETURN);
			web_driver.findElement(google_search_box_button).submit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Web Element Not Interactable");
		}
	}
	
}
