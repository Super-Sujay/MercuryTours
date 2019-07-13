package com.newtours.utilities;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListnersTest implements ITestListener, ISuiteListener, IInvokedMethodListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Execution of the test " + result.getName() + " started");
		Reporter.log("Execution of the test " + result.getName() + " started<br>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		printTestResults(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		printTestResults(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		printTestResults(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("About to begin executing Test " + context.getName());
		Reporter.log("About to begin executing Test " + context.getName() + "<br>");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("About to end executing Test " + context.getName());
		Reporter.log("About to end executing Test " + context.getName() + "<br>");
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		String methodName = method.getTestMethod().getRealClass().getSimpleName() + "." + method.getTestMethod().getMethodName();
		System.out.println("About to begin executing following method: " + methodName);
		Reporter.log("About to begin executing following method: " + methodName + "<br>");
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		String methodName = method.getTestMethod().getRealClass().getSimpleName() + "." + method.getTestMethod().getMethodName();
		System.out.println("About to end executing following method: " + methodName);
		Reporter.log("About to end executing following method: " + methodName + "<br>");
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("About to begin executing Suite " + suite.getName());
		Reporter.log("About to begin executing Suite " + suite.getName() + "<br>");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("About to end executing Suite " + suite.getName());
		Reporter.log("About to end executing Suite " + suite.getName() + "<br>");
	}
	
	private void printTestResults(ITestResult result) {
		System.out.println("Test Method resides in " + result.getTestClass().getName());
		Reporter.log("Test Method resides in " + result.getTestClass().getName() + "<br>");
		
		if (result.getParameters().length != 0) {
			String params = "";
			for (Object parameter : result.getParameters()) {
				params += parameter.toString() + ", ";
			}
			params = params.substring(0, params.length()-2);
			System.out.println("Test Method has the following parameters: " + params);
			Reporter.log("Test Method has the following parameters: " + params + "<br>");
		}
		
		String status;
		switch(result.getStatus()){
		case ITestResult.SUCCESS:
			status = "Pass";
			break;
		case ITestResult.FAILURE:
			status = "Failed";
			break;
		case ITestResult.SKIP:
			status = "Skipped";
			break;
		default:
			status = null;
		}
		
		System.out.println("Test Status: " + status);
		Reporter.log("Test Status: " + status + "<br>");
	}

}
