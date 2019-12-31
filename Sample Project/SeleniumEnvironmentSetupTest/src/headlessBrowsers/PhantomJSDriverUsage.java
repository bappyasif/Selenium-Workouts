package headlessBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomJSDriverUsage {
	static String base_URL = "http://www.seleniumhq.org/";
	public static void main(String[] args) throws InterruptedException {
		String project_dir = System.getProperty("user.dir");
		System.setProperty("phantomjs.binary.path", project_dir+"\\Lib\\phantomJS\\phantomjs.exe");
		WebDriver phnatom_driver = new PhantomJSDriver();
		phnatom_driver.get(base_URL);
		System.out.println("Title Is : "+phnatom_driver.getTitle());
		//phnatom_driver.wait(2000);
		System.out.println("Test Succeessful");
		phnatom_driver.close();
	}
}
