package testngListenersUsageExamples;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//We Can Omit This Annotation From Here As We Have Added This In Our .XML File.
//@Listeners(TestNGListenersExampleTest.class)
public class TestNGListenersAnnotationSetup {
	
	// Creating Example Test Cases To Initiate ITestListeners Class.
	
	@Test
	public void ExampleTest() {
		System.out.println("Within Method : ");
	}
	
	@Test
	public void AnotherExample() {
		System.out.println("Within Method : ");
		//Assert.assertTrue(false);
	}
	
	@Test
	public void AnotherTest() {
		System.out.println("Within Method : ");
		//throw new SkipException("Test Case Is Skipped");
	}
	
	@Test
	public void TestExample() {
		System.out.println("Within Method : ");
	}	

}
