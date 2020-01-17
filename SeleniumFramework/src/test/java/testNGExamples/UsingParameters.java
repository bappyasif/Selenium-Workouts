package testNGExamples;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UsingParameters {
	
	@Test
	@Parameters("exParam")
	public void exampleTest(String param) {
		System.out.println("Varaible Used : "+param);
	}
	
	@Test
	@Parameters("paramEx")
	public void anotherExample(@Optional("Test_Automation") String param) {
		System.out.println("Another Parameter : "+param);
	}
}
