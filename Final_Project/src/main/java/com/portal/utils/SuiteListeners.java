package com.portal.utils;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SuiteListeners implements ITestListener, IAnnotationTransformer {

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("New Test Started: " + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("New Test Success: " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("New Test Failure: " + result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println("New Test Skipped: " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("New Test FailedButWithinSuccessPercentage: " + result.getName());

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

		System.out.println("New Test FailedWithTimeout: " + result.getName());

	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("New Test Start: " + context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("New Test Finish: " + context.getName());

	}

	
}
