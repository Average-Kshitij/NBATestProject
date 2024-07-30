package org.derived.product2.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
	
	public static  ExtentReports getReportObject()
	{
	String path = System.getProperty("user.dir")+"/index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Result");
	reporter.config().setDocumentTitle("Test Results");
	
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("QA", "Kshitij Sawant");
	
	
	return extent;
	
	
	}

}
