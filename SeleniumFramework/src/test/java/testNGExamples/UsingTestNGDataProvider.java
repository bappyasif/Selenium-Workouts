package testNGExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import usingExcelDataFiles.UsingExcelDataProvider;

public class UsingTestNGDataProvider {

//	static String project_path = System.getProperty("user.dir");
//
//	static String excel_path = project_path+"\\Excel Files\\Test Data.xlsx";
//
//	static String sheet_name = "Sheet1";
	
	WebDriver web_driver;
	static String base_URL = "https://opensource-demo.orangehrmlive.com/";
	
	@BeforeTest
	public void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
	}

	@Test(priority=0)
	public void urlNavigation() {
		web_driver.get(base_URL);
		System.out.println("Navigation Successful");
	}

	
	@Test(dataProvider="Test_Data", priority=1)
	public void commenceTest(String userName, String password) throws InterruptedException {
		System.out.println(userName+" | "+password);
		
		WebElement u_name = web_driver.findElement(By.name("txtUsername"));
		u_name.clear();
		u_name.sendKeys(userName);
		WebElement u_password = web_driver.findElement(By.name("txtPassword"));
		u_password.clear();
		u_password.sendKeys(password);
		
		Thread.sleep(2000);
		
	}

	@DataProvider(name="Test_Data")
	public static Object[][] getData() {
		
		String project_path = System.getProperty("user.dir");
		
		String excel_path = project_path+"\\Excel Files\\Test Data.xlsx";
		
		String sheet_name = "Sheet1";
		
		Object data[][] = UsingExcelDataProvider.testData(excel_path, sheet_name);
		
		return data;
	}

}
