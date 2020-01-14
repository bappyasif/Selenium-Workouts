package testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryFailedTestCases {
	
	@Test(retryAnalyzer=testngListenersUsageExamples.TestNGRetryAnalyzerExample.class)
	public void sampleTest() {
		System.out.println("Within sampleTest");
		Assert.fail("Asserted Fail");
	}
	
	@Test
	public void testSample() {
		System.out.println("Within testSample");
		int i = 1/0;
	}
	
	@Test
	public void testExample() {
		System.out.println("Within testExample");
		//Assert.assertTrue(false, "False Asserted");
	}
	
	@Test
	public void exampleTest() {
		System.out.println("Within exampleTest");
		Assert.assertTrue(0>1);
	}

}
