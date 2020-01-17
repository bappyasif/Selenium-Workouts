package testngListenersUsageExamples;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListenersExampleTest implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("** Coming From Test Listeners ** "+"Test Commenced : "+result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("** Coming From Test Listeners ** "+"Test Succeed : "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("** Coming From Test Listeners ** "+"Test Failed : "+result.getName());
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("** Coming From Test Listeners ** "+"Test Skipped : "+result.getName());
	}
	
	public void onStart(ITestContext context) {
		System.out.println("** Coming From Test Listeners ** "+"Test Started : "+context.getName());
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("** Coming From Test Listeners ** "+"Test Finished : "+context.getName());
	}
}
