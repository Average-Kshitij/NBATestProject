package org.derived.product2.stepDefinitions;

import java.io.IOException;

import org.automation.framework.Base;
import org.derived.product2.Report.ExtentReporterNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Base{
	
	public static ThreadLocal<ExtentTest> extentTestReport = new ThreadLocal<ExtentTest>();
	public static ExtentTest test=null;
	static ExtentReports extent = ExtentReporterNG.getReportObject();
	
	@BeforeClass
    public static void beforeSuite() {
    	System.out.println("Inside Before class");
       
    }

    @Before
    public static void setUp(Scenario scenario) throws IOException{
    	System.out.println("Inside Before");
    	initialzedriver();
    	test = extent.createTest(scenario.getName());
		extentTestReport.set(test);
    }

    @After
    public static void tearDown(Scenario scenario){

    	System.out.println("Inside Before Tear down");
    	
    	String status = scenario.getStatus().toString();
    	if(status.equalsIgnoreCase("PASSED"))
    	{
    		String scenarioName= scenario.getName();
    		try {
    			extentTestReport.get().log(Status.PASS,"Test Case passed");
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    	}
    	else if(status.equalsIgnoreCase("FAILED"))
    	{
    		String scenarioName= scenario.getName();
    		try {
    			extentTestReport.get().log(Status.FAIL,"Test Case failed");
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    	}
    	 	
    	
    	tdriver.get().quit();
    }

    @AfterClass
    public static void afterSuite(){
    	System.out.println("Inside After class");
    	
        
    }

}
