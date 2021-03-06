package configSettings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import modularSetup.ModularUsage;

public class PropertiesFileSettingsSetup {
	
	// Create A Properties Object
	static Properties propObject = new Properties();
	
	public static void main(String[] args) throws FileNotFoundException {
		PropertiesFileSettingsSetup createdObject = new PropertiesFileSettingsSetup();
		
		try {
			createdObject.readFromPropertiesFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			createdObject.writeIntoPropertiesFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		createdObject.readFromPropertiesFile();
	}
	
	
	
	public static void readFromPropertiesFile() throws FileNotFoundException {
		// Create A Properties Object
		//Properties propObject = new Properties();
		
		// Create Object Of Input Stream
		InputStream inputStream = new FileInputStream("G:\\LatestEclipse\\Selenium Development\\Selenium Workouts\\Sample Project\\SeleniumEnvironmentSetupTest\\src\\configSettings\\config.properties");
		try {
			// Load Properties Input File
			propObject.load(inputStream);
			
//			ModularUsage.browserPlatform = propObject.getProperty("browserPlatform");
//			System.out.println(ModularUsage.browserPlatform);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Get Values From Properties File
//		System.out.println(propObject.getProperty("browserPlatform"));
		ModularUsage.browserPlatform = propObject.getProperty("browserPlatform");
		System.out.println(ModularUsage.browserPlatform);
	}
	
	
	public static void writeIntoPropertiesFile() throws IOException {
		
		try {
			// Create Object Of Output Stream
			OutputStream outputStream = new FileOutputStream("G:\\LatestEclipse\\Selenium Development\\Selenium Workouts\\Sample Project\\SeleniumEnvironmentSetupTest\\src\\configSettings\\config.properties");
			
			// Write Into Properties File Object
			propObject.setProperty("browserPlatform", "Chrome");
			propObject.setProperty("result", "pass");
			
			// Write Any Comment While Storing
			propObject.store(outputStream, "Written From Java Program");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		// Write Into Properties File Object
//		propObject.setProperty("browserPlatform", "Chrome");
//		
//		// Write Any Comment While Storing
//		propObject.store("outputSttream", "Written From Java Program");
		
	}
}
