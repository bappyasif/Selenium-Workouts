package loj4jUsage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleTest {
	// Create Logger Class Object
	static Logger logger = LogManager.getLogger(ExampleTest.class);
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		performTask();
		
		System.out.println("Test Done...");
	}
	
	public static void performTask() {
		
		// Using Logger To Console
		// Logger Uses Logger Up And Above Error Level Priorities.
		logger.info("Information Log For TestCase");
		
		logger.error("Error Message If Any");
		
		logger.warn("Message Supplied As Warning");
		
		logger.fatal("Object Message For Fatality");
		
		// Trace Logs Doesn't Get Appended By Default Unless Log Level Is 
		// Changed To Accommodate This From log4j2.properties File.
		logger.trace("This Is A Trace Level Logger Message. \r \r");
		
	}
}
