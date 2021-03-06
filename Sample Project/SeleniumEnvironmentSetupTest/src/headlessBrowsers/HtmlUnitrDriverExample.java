package headlessBrowsers;

import java.lang.reflect.Field;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

public class HtmlUnitrDriverExample {

	static String base_URL = "http://www.seleniumhq.org/";

	public static void main(String[] args) {
		//browserSpecefic();
		try {
			confirmingBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Specific Browser 
	 */
	public static void browserSpecefic() {
		// Browsers Specific
		HtmlUnitDriver unit_driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER);
		
		unit_driver.get(base_URL);
		
		System.out.println("Title Of This Page : "+unit_driver.getTitle());
		
		unit_driver.close();
	}

	
	/**
	 * Generic Browsers
	 */
	public static void genericBrowsers() {
		// Generic Invocation Of Browsers
		HtmlUnitDriver unit_driver = new HtmlUnitDriver();

		unit_driver.get(base_URL);

		System.out.println("Title Of This Page : "+unit_driver.getTitle());

		unit_driver.close();

	}
	
	/**
	 * Confirming Test Ran On Browser Specified Platform Not Else.
	 * @throws Exception 
	 */
	public static void confirmingBrowser() throws Exception {
		HtmlUnitDriver unit_driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER);
		
		unit_driver.get(base_URL);
		
		System.out.println("Title Of This Page : "+unit_driver.getTitle());
		
		WebClient web_client = 	(WebClient) get(unit_driver, "webClient");
		
		System.out.println("Browser Platform : "+web_client.getBrowserVersion());
		
		System.out.println("Browser IE? : "+web_client.getBrowserVersion().isIE());
		
		System.out.println("Browser Chrome? : "+web_client.getBrowserVersion().isChrome());
		
		unit_driver.close();
	}
	
	private static Object get(Object object, String field) throws Exception {
		Field accessible_field = object.getClass().getDeclaredField(field);
		accessible_field.setAccessible(true);
		return accessible_field.get(object);
	}

}
