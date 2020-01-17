package propertiesFileUsageExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class UsingPropertiesFileExample {
	
	static String project_path = System.getProperty("user.dir");
	static Properties propObject;
	
	static String browserPlatform;
	
	public static void main(String[] args) throws Exception {
		try {
			accessPropertiesPairedValues();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Caught Exception...");
		}
		
		writeIntoPropertiesFile();
		accessPropertiesPairedValues();
	}
	
	public static void accessPropertiesPairedValues() throws IOException {
		
		// Creating A Properties Object
		propObject = new Properties();
		
		InputStream inStream = new FileInputStream(project_path+"\\src\\main\\java\\propertiesFileUsageExamples\\exampleConfig.properties");
		
		propObject.load(inStream);
		
		browserPlatform =  propObject.getProperty("browserPlatform");
		
		System.out.println("Value Found : "+browserPlatform);
		
		// Extension OF TestNG Mechanism
		
	}
	
	public static void writeIntoPropertiesFile() {
		try {
			OutputStream ouStream = new FileOutputStream(project_path+"\\src\\main\\java\\propertiesFileUsageExamples\\exampleConfig.properties");
			
			propObject.setProperty("browserPlatform", "IE");
			
			propObject.store(ouStream, "Editted From Java Program");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Caught File Writing Exception");
		}
	}
	
}
