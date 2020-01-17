package testNGExamples;

import org.testng.annotations.Test;

public class anotherTestNGPriorityExample {
	
	@Test
	public void testCaseExampleOne() {
		System.out.println("Example One");
	}
	
	@Test(priority = -1)
	public void testCaseExampleTwo() {
		System.out.println("Example Two");
	}
	
	@Test
	public void testCaseExampleThree() {
		System.out.println("Example Three");
	}
	
	@Test(priority = 0)
	public void testCaseExampleFour() {
		System.out.println("Example Four");
	}
	
}
