package testNGExamples;

import org.testng.annotations.Test;

public class UsingDependencies {
	
	// Even If There Is Priority Parameters Been Initialized
	// DependsOnMethods Will Have Higher Preference. 
	@Test(dependsOnMethods="testExample", priority=2)
	public void exampleTest() {
		System.out.println("Within exampleTest");
	}
	
	@Test(priority=4, dependsOnGroups="Sanity")
	public void testExample() {
		System.out.println("Within testExample");
	}
	
	@Test(dependsOnMethods= {"exampleTest", "testExample"})
	public void anotherExample() {
		System.out.println("Within anotherExample");
	}
	
	@Test(groups="Sanity")
	public void anotherTest() {
		System.out.println("Within anotherTest");
	}
	
	@Test(groups="Smoke")
	public void yetAnother() {
		System.out.println("Within yetAnother");
	}
	
	@Test(groups="Smoke_")
	public void usingAnother() {
		System.out.println("Within usingAnother");
	}
	
	@Test(groups="Smoke_Test")
	public void hereAnother() {
		System.out.println("Within hereAnother");
	}
	
	@Test(dependsOnGroups="Smoke.*")
	public void usingRegex() {
		System.out.println("Within usingRegex");
	}
}
