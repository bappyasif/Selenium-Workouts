package environmentTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITUsageTExampleTest {

	static WebDriver web_driver;
	static String base_URL = "http://www.tinyupload.com/";

	public static void main(String[] args) {
		setupBrowser();
		navigationMethod();
		commenceTest();
		tearDown();
	}

	public  static void setupBrowser() {
		WebDriverManager.chromedriver().setup();
		//ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--headless");
		web_driver = new ChromeDriver();
	}

	public static void navigationMethod( ) {
		web_driver.get(base_URL);
	}

	public static void commenceTest() {
//		//WebElement choose_file = web_driver.findElement(By.xpath("//input[@name='uploaded_file']"));
//		WebElement choose_file = web_driver.findElement(By.name("uploaded_file"));
//		choose_file.click();
//		System.out.println("Element Clicked");

		// Using Script Created From AutoIT Editor
		
		System.out.println(web_driver.findElement(By.xpath("//input[@name='uploaded_file']")).isDisplayed());
		
//		JavascriptExecutor scriptExecutor = (JavascriptExecutor)web_driver;
//		scriptExecutor.executeScript("arguments[0].click()", web_driver.findElement(By.name("uploaded_file")));
		
		WebElement choose_file = web_driver.findElement(By.xpath("//input[@name='uploaded_file']"));
		Actions actions = new Actions(web_driver);
		//actions.doubleClick(choose_file).perform();
		actions.click(choose_file).perform();
		
		try {
			//Thread.sleep(2000);
			//WebElement choose_file = web_driver.findElement(By.xpath("//input[@name='uploaded_file']"));
			//WebElement choose_file = web_driver.findElement(By.cssSelector("input[name=\"uploaded_file\"]"));
			//web_driver.findElement(By.cssSelector("css=input[name=\"uploaded_file\"]")).click();
			//choose_file.click();
			//choose_file.submit();
			System.out.println("Element Clicked");
			Thread.sleep(2000);
			//Runtime.getRuntime().exec("G:\\\\AutoIt\\\\TestFileUploadScript.exe");
			Runtime.getRuntime().exec("G:\\AutoIt\\TestFileUploadScript.exe");
			System.out.println("Script Executed");
			Thread.sleep(2000);
			WebElement file_upload = web_driver.findElement(By.xpath("//td[contains(text(),'File to upload :')]"));
			System.out.println(file_upload.isDisplayed());
			actions.click(file_upload);
			//actions.doubleClick(file_upload);
			Thread.sleep(2000);
			System.out.println("File Uploaded");
			//Runtime.getRuntime().exec("G:\\AutoIt\\FileUploadScriptTest.exe");
		
			//web_driver.getWindowHandle();
			//web_driver.switchTo().frame("generator");
			
			//System.out.println(web_driver.getTitle());
			
			//web_driver.switchTo().alert().dismiss();
			web_driver.switchTo().defaultContent();
			System.out.println(web_driver.getTitle());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception Caught");
		}

	}

	public static void tearDown() {
		web_driver.close();
		web_driver.quit();

		System.out.println("Test Done...");
	}

}
