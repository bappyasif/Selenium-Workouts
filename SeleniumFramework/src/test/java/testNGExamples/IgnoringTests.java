package testNGExamples;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

// Ignore All Test Cases Within Class Level Implementation 
//@Ignore
public class IgnoringTests {
	
	// Using Method Level Ignore 
	@Ignore
	@Test
	public void testShowcase() {
		System.out.println("Within testShowcase");
	}
	
	@Test
	public void showcaseTest() {
		System.out.println("Within showcaseTest");
	}

}
