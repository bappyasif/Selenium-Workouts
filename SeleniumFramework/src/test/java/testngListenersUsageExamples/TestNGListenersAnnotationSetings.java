package testngListenersUsageExamples;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//We Can Omit This Annotation From Here As We Have Added This In Our .XML File.
//@Listeners(TestNGListenersExampleTest.class)
public class TestNGListenersAnnotationSetings {
	
	// Creating Example Test Cases To Initiate ITestListeners Class.
	
	@Test
	public void exampleTest() {
		System.out.println("Within exampleTest()");
	}
	
	@Test
	public void anotherExample() {
		System.out.println("Within anotherExample()");
		Assert.assertTrue(false);
	}
	
	@Test
	public void anotherTest() {
		System.out.println("Within anotherTest()");
		throw new SkipException("Test Case Is Skipped");
	}
	
	@Test
	public void testExample() {
		System.out.println("Within testExample()");
	}	

}
