package org.derived.product1.stepDefinition;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.map.HashedMap;
import org.core.product.pageObjects.SearchJacketObjects;
import org.derived.product1.pageObjects.CoreProd1PageFile;
import org.derived.product1.pageObjects.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CoreProduct1Steps extends PageFactory{
	
	SearchJacketObjects coreProdObj =  new SearchJacketObjects();
	CoreProd1PageFile coreProd1Obj = new CoreProd1PageFile();
	
	Map<String,Long> slideTimings = new HashedMap<String, Long>(); 
	
	@Given("user has navigated to the home page {string}")
	public void user_has_navigated_to_the_home_page_https_www_nba_com_sixers(String url) {
		try {
			coreProdObj.getHomePageURL(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  
	}

	@Then("count number of slids present under ticket menu")
	public void count_number_of_slids_present_under_ticket_menu() {
	  
		try {
			int slideCount = coreProd1Obj.countNoOfSlides();
			Assert.assertEquals(slideCount, 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  
	}

	@Then("get title with each slide and valdidate with expected title")
	public void get_title_with_each_slide_and_valdidate_with_expected_title() {
	   
		List<String> slideTitles =  coreProd1Obj.getTitleOfSlides();
	}

	@Then("Count how much duration each slide is playing")
	public void count_how_much_duration_each_slide_is_playing() {
		try {
			slideTimings=coreProd1Obj.getSlideTiming();
			System.out.println(slideTimings);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("validate the time with expected value")
	public void validate_the_time_with_expected_value() {
		
		boolean isUnderLimit = true;
		try {
			SoftAssert sassert = new SoftAssert();
			Set<String> keys =slideTimings.keySet();
			Iterator<String> it =  keys.iterator();
			while(it.hasNext())
			{
				String key = it.next();
				
				long slideTime =slideTimings.get(key);
				if(slideTime >10)
				{
					isUnderLimit = false;
				
				}
				sassert.assertTrue(isUnderLimit,"Slide timer assertion");
			}
			sassert.assertAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	
	
	
}