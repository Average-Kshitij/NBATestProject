package org.derived.product1.stepDefinition;

import java.io.IOException;

import org.automation.framework.Base;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Base{
	
	@BeforeClass
    public static void beforeSuite() {
    	System.out.println("Inside Before class");
       
    }

    @Before
    public void setUp() throws IOException{
    	System.out.println("Inside Before");
    	
    	initialzedriver();
    }

    @After
    public static void tearDown(Scenario scenario){

    	System.out.println("Inside Before Tear down");
    	tdriver.get().quit();
    }

    @AfterClass
    public static void afterSuite(){
    	System.out.println("Inside After class");
    	
        
    }

}
