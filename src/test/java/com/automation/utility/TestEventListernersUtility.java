package com.automation.utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.base.BaseTest;


public class TestEventListernersUtility implements ITestListener {
	
	private static ExtentReportsUtility extentReport;

	@Override
	public void onTestStart(ITestResult result) {
		extentReport.startSingleTestReport(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentReport.logTestpassed(result.getMethod().getMethodName()+"is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentReport.logTestFailed(result.getMethod().getMethodName()+"is failed");
		extentReport.logTestFailedWithException(result.getThrowable());
		BaseTest ob=new BaseTest();
		WebDriver driver=ob.returnDriverInstamce();
		extentReport.logTestWithScreenshot(ob.getScreenshotOfThePage(driver).getAbsolutePath());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		extentReport=ExtentReportsUtility.getInstance();
		extentReport.startExtentReport();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.endReport();
	}


}
