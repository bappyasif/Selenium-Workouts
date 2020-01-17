package systemExamples;

public class JavaErrotHandlingExamples {

	static int variable_value = 99;

	public static void main(String[] args)  throws Exception{
		
		try {
			invokeException();
			anotherInvocation();
			// This Require Function To Throw Exception To Run Successfully.
			anotherInvocationErrorMethod();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Cauught Exception...");
		} finally {
			commencingErrorHandlingTest();
			System.out.println("Test Done...");
		}
	}

	public static void commencingErrorHandlingTest() {

		System.out.println("\n Usual Flow Of Code");
		
		try {
			System.out.println("Operation Value : "+(variable_value/0));
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("Get Message : "+ex.getMessage());
			System.out.println("Get Cause : "+ex.getCause());
			ex.printStackTrace();
			
		} finally {
			System.out.println("Finally Block Will Exceute");
		}
		
	}

	public static void invokeException() {

		System.out.println("Usual Flow Of Code");

		System.out.println("Operation Value : "+(variable_value/0));
	}
	
	public static void anotherInvocationErrorMethod() throws Exception {
		
		System.out.println("Usual Flow Of Code");

		System.out.println("Operation Value : "+(variable_value/0));
	}
	
	public static void anotherInvocation() throws Exception {
		//System.out.println("Usual Flow Of Code");
		
		throw new ArithmeticException("Not A Valid Operation!!");

		//System.out.println("Operation Value : "+(variable_value/0));
	}

}
