package com.newtours.utilities;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListners implements ITestListener, ISuiteListener, IInvokedMethodListener, IReporter {

	private ExtentReports extent;
	
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
	
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		init(xmlSuites);
		suites.forEach(suite -> {
			Map<String, ISuiteResult> results = suite.getResults();
			results.values().forEach(result -> {
				ITestContext context = result.getTestContext();
				buildTestNodes(context.getFailedTests(), Status.FAIL);
				buildTestNodes(context.getSkippedTests(), Status.SKIP);
				buildTestNodes(context.getPassedTests(), Status.PASS);
			});
		});
		Reporter.getOutput().forEach(extent::setTestRunnerOutput);
		extent.flush();
	}

	private void buildTestNodes(IResultMap tests, Status status) {
		SortedSet<ITestResult> sortedSet = new TreeSet<ITestResult>();
		tests.getAllResults().forEach(sortedSet::add);
		if (tests.size() > 0) {
			sortedSet.forEach(result -> {
				ExtentTest test = extent.createTest(result.getTestContext().getCurrentXmlTest().getName() + " - " + result.getMethod().getMethodName());
				test.assignCategory(result.getMethod().getRealClass().getSimpleName());
				Throwable throwable = result.getThrowable();
				if (throwable != null) {
					Object[] parameters = result.getParameters();
					if (parameters.length > 0) {
						try {
							String params = Arrays.asList(parameters).stream().map(p -> (String) p).collect(Collectors.joining(", "));
							test.info(params);
						} catch (ClassCastException e) {
							@SuppressWarnings("unchecked")
							Map<String, String> data = (Map<String, String>) parameters[0];
							test.info(data.toString());
						}
					} else
						test.info("This test doesn't have data");
					test.log(status, throwable);
				} else
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				test.getModel().setStartTime(getTime(result.getStartMillis()));
				test.getModel().setEndTime(getTime(result.getEndMillis()));
			});
		}
	}

	private Date getTime(long millis) {
		return Date.from(Instant.ofEpochMilli(millis));
	}

	private void init(List<XmlSuite> xmlSuites) {
		String suiteName = xmlSuites.get(0).getName();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("");
		htmlReporter.config().setDocumentTitle("ExtentReports: " + suiteName);
		htmlReporter.config().setReportName(suiteName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setEncoding("utf-8");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setReportUsesManualConfiguration(true);
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
