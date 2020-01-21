package applitoolsEyes;

import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UsingPlatform {
	
	static WebDriver web_driver;
	static String test_URL = "https://applitools.com/helloworld2";

	static private String  appName  = "Hello World Web App";
	static private String  testName = "Hello World Web Test";
	static String serverURLstr = "https://eyesapi.applitools.com";
	static Boolean urlChanged = false;
	//static Boolean urlChanged = true;
	
	static Eyes eyes;
	static String API_KEY = "aUSoC102Hm1uJ10854AJ98y10Zxwg8tJU110xO9899BTe2H105a5F4110";
	
	public static void main(String[] args) {
		URI serverURL = null;
		try {
			serverURL = new URI(serverURLstr);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		eyes = new Eyes();
		eyes.setServerUrl(serverURL);
		setUp(eyes);
		
		RectangleSize viewport_size = new RectangleSize(/* Width */1024, /*height*/768);
		//RectangleSize viewport_size = new RectangleSize(/* Width */500, /*height*/900);
		
		WebDriverManager.chromedriver().setup();
		web_driver = new ChromeDriver();
		
		if(!urlChanged) {
			commenceTest(web_driver, eyes, viewport_size);
		} else {
			testChanged(web_driver, eyes, viewport_size);
		}
	
	}
	
	public static void commenceTest(WebDriver inner_driver, Eyes eyes, RectangleSize view_port) {
		eyes.open(inner_driver, appName, testName, view_port);
		
		try {
			inner_driver.get(test_URL);
			eyes.checkWindow("Before Entering User Name");
			
			inner_driver.findElement(By.id("name")).sendKeys("aBappy");
			eyes.checkWindow("After Entering User Name");
			
			inner_driver.findElement(By.tagName("button")).click();
			eyes.checkWindow("After Clicking Click Button");
			
			TestResults testResults = eyes.close(false);
			handleResults(testResults);
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		} finally {
			eyes.abortIfNotClosed();
		}
		web_driver.quit();
	}
	
	public static void handleResults(TestResults teResults) {
		String resultStr;
		String url;
		if(teResults == null) {
			resultStr = "Test aborted";
            url = "undefined";
		} else {
			url = teResults.getUrl();
			int totalSteps = teResults.getSteps();
			if(teResults.isNew()) {
				resultStr = "New Baseline Created: " + totalSteps + " steps";
			} else if (teResults.isPassed()) {
				resultStr = "All steps passed:     " + totalSteps + " steps";
			} else {
				resultStr = "Test Failed     :     " + totalSteps + " steps";
                resultStr += " matches=" +  teResults.getMatches();      /*  matched the baseline */
                resultStr += " missing=" + teResults.getMissing();       /* missing in the test*/
                resultStr += " mismatches=" + teResults.getMismatches(); /* did not match the baseline */
			}
		}
		
		resultStr += "\n Results At : "+url;
		System.out.println(resultStr);
	}
	
	public static void testChanged(WebDriver inner_driver, Eyes eyes, RectangleSize view_port ) {
		TestResults test_results;
		
		eyes.open(inner_driver, appName, testName, view_port);
		
		try {
			String testUrlToUSe = test_URL;
			
			if (urlChanged) {
				testUrlToUSe += "?diff2";
				
				web_driver.get(testUrlToUSe);
				if(!urlChanged) {
					eyes.checkWindow("Before Entering User Name");
				}
				
				inner_driver.findElement(By.id("name")).sendKeys("aBappy");
				eyes.checkWindow("After Entering User Name");
				
				inner_driver.findElement(By.tagName("button")).click();
				eyes.checkWindow("After Clicking Click Button");
				
				if(urlChanged) {
					eyes.checkWindow("After Clicking Click Again");
				}
				
				test_results = eyes.close(false);
				handleResults(test_results);
			}
			
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		} finally {
			eyes.abortIfNotClosed();
		}
		web_driver.quit();
	}
	
	public static void setUp(Eyes eyes) {
		String apiKEY = API_KEY;
		System.out.println(apiKEY);
		eyes.setApiKey(apiKEY);
	}

}
