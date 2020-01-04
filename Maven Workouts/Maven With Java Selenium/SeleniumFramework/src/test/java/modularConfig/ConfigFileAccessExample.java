package modularConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigFileAccessExample {

	// We Will Use Two Function One For Reading File Data From Properties File.
	// Another One For Writing Into It.

	static String project_path = System.getProperty("user.dir");
	static String config_file = project_path+"\\src\\test\\java\\modularConfig\\config.properties";

	// Create A Properties Object
	static Properties propertiesFile = new Properties();

	public static void main(String[] args) throws Exception{
		readFromProeprtiesFile();
		writeIntoPropertiesFile();
	}

	public static void readFromProeprtiesFile() throws IOException {
		// Create A Properties Object
		//Properties propertiesFile = new Properties();

		// Creating An InputStream Object
		InputStream inputStream = new FileInputStream(config_file);

		// Loading File Into InputStream
		propertiesFile.load(inputStream);

		// Reading Data From File
		System.out.println(propertiesFile.getProperty("browser_platform"));
		
		// Commencing Config.Properties File Data Into configModular Variable.
		modularConfig.UsingconfigPropertiesFile.browser_platform = propertiesFile.getProperty("browser_platform");
		System.out.println("modularConfig : "+modularConfig.UsingconfigPropertiesFile.browser_platform);

	}

	public static void writeIntoPropertiesFile() throws IOException {
		// Create An OutputStream Object
		OutputStream outputStream = new FileOutputStream(config_file);
		
		// Writing Into Properties File
		propertiesFile.setProperty("browser_platform", "Chrome");
		propertiesFile.setProperty("Result", "Pass");
		
		// Also Writing Comment Along
		propertiesFile.store(outputStream, "Written From Java Program");
		
	}

}
