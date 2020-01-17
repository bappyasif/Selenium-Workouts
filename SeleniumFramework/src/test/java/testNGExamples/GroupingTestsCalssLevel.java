package testNGExamples;

import org.testng.annotations.Test;

@Test(groups="AllClassTestCases")
public class GroupingTestsCalssLevel {
	
	@Test(groups="sanity")
	public void firstUserTestCase() {
		System.out.println("Within firstUserTestCase");
	}
	
	@Test(groups= "smoke")
	public void secondUserTestCase() {
		System.out.println("Within secondUserTestCase");
	}
	
	@Test(groups= {"regression", "sanity"})
	public void thirdUserTestCase() {
		System.out.println("Within thirdUserTestCase");
	}
	
	@Test(groups={"regression", "smoke"})
	public void fourthUserTestCase() {
		System.out.println("Within fourthUserTestCase");
	}
	
	@Test(groups="windows.regression")
	public void WindowsUserTestCase() {
		System.out.println("Within windowsUserTestCase");
	}
	
	@Test(groups="linux.regression")
	public void linuxUserTestCase() {
		System.out.println("Within linuxUserTestCase");
	}
	
}
