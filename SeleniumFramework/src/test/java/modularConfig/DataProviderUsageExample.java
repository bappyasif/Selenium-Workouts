package modularConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import usingExcelDataFiles.DataProviderExcelUtils;
import usingExcelDataFiles.ExcelUtilsExampleUsage;

public class DataProviderUsageExample {

	static WebDriver web_driver;
	static String project_path;
	static String excel_path;
	static String sheet_name;
	static String base_URL = "https://opensource-demo.orangehrmlive.com/";
	
	public static void main(String[] args) {

		project_path = System.getProperty("user.dir");
		excel_path = project_path+"\\Excel Files\\Data Sheet.xls";
		sheet_name = "Sheet1";
		
		configBrowser();
		commenceTest();
		settingUpDataProvider(excel_path, sheet_name);
		tearDown();
	}

	public static void settingUpDataProvider(String excelPath, String sheetName) {

		//Object excel_data [][] = DataProviderExcelUtils.dataProviderExcelSheet(excel_path, sheet_name);
		//  Creating An ExcelUtils Object
		ExcelUtilsExampleUsage excel_utils = new ExcelUtilsExampleUsage(excelPath, sheetName);
		// Calling Methods From Excel Utils
//		int row_count = excel_utils.getSheetRowCount();
//		int col_count = excel_utils.getSheetCollumnCount();

		// Creating Object Type Array
		//Object[][] excel_sheet = new Object[row_count][col_count]; 

//		for(int rowCounter = 1; rowCounter<row_count; rowCounter++) {
//			for(int colCounter = 0; colCounter<col_count; colCounter++) {
//				String ua_value = excel_utils.accessSheetStringData(rowCounter, colCounter);
//				System.out.println("User"+ua_value);
//				String up_value = excel_utils.accessSheetStringData(rowCounter, colCounter+1);
//				System.out.println("Password"+up_value);
//			}
//		}
		
		String ua_value = excel_utils.accessSheetStringData(1, 0);
		System.out.println(ua_value);
		
		setLocatorUserName(ua_value);
		
		String up_value = excel_utils.accessSheetStringData(1, 1);
		System.out.println(up_value);
		
		setLocatorUserPassword(up_value);
		
		String ua_Next = excel_utils.accessSheetStringData(2, 0);
		System.out.println(ua_Next);
		
		setLocatorUserName(ua_Next);
		
		String up_Next = excel_utils.accessSheetStringData(2, 1);
		System.out.println(up_Next);
		
		setLocatorUserPassword(up_Next);
	}

	public static void configBrowser() {
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
	}

	public static void commenceTest() {
		
		web_driver.get(base_URL);
		System.out.println("Navigation Done...");
		
	}
	
	public static void setLocatorUserName (String uName) {
		WebElement u_name = web_driver.findElement(By.name("txtUsername"));
		u_name.clear();
		u_name.sendKeys(uName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setLocatorUserPassword(String uPassword) {
		WebElement u_password = web_driver.findElement(By.name("txtPassword"));
		u_password.clear();
		u_password.sendKeys(uPassword);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void tearDown() {
		web_driver.close();
		System.out.println("Test Done...");
	}

}
