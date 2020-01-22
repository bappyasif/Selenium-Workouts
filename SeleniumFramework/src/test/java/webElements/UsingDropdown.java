package webElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingDropdown {
	static String base_URL = "https://www.facebook.com/";
	static WebDriver web_driver;

	public static void main(String[] args) {
		setupBrowser();
		commenceNavigation();
		commenceTest();
		tearDown();
	}

	public static void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
	}

	public static void commenceNavigation() {
		web_driver.get(base_URL);
		System.out.println("Navigation Successful");
	}

	public static void commenceTest() {
		web_driver.manage().window().maximize();

		WebElement day_element = web_driver.findElement(By.id("day"));
		Select select_day = new Select(day_element);
		select_day.selectByIndex(8);
		List<WebElement> day_elemnts_select_options = select_day.getOptions();
		int total_days = day_elemnts_select_options.size();
		System.out.println("Total Dayss : "+total_days);
		for(WebElement element: day_elemnts_select_options) {
			String day_founds = element.getText();
			System.out.println("Days Are : "+day_founds);
		}
		System.out.println("\n");

		WebElement month_element = web_driver.findElement(By.id("month"));
		Select select_month = new Select(month_element);
		select_month.selectByVisibleText("Dec");
		List<WebElement> month_elemnts_select_options = select_month.getOptions();
		int total_months = day_elemnts_select_options.size();
		System.out.println("Total Months : "+total_months);
		for(WebElement element : month_elemnts_select_options) {
			String months_found = element.getText();
			System.out.println("Months Are : "+months_found);
		}
		System.out.println("\n");

		WebElement year_element = web_driver.findElement(By.id("year"));
		Select select_year = new Select(year_element);
		select_year.selectByValue("2000");
		List<WebElement> year_elemnts_select_options = select_year.getOptions();
		int total_Years = day_elemnts_select_options.size();
		System.out.println("Total Years : "+total_Years);
		for(WebElement element : year_elemnts_select_options) {
			String years_found = element.getText();
			System.out.println("Years Are : "+years_found);
		}
		System.out.println("\n");
	}

	public static void tearDown() {
		web_driver.quit();
		System.out.println("\n Test Done...");
	}
}
