package org.derived.product2.stepDefinitions;

import java.util.List;

import org.derived.product1.pageObjects.CoreProd1PageFile;
import org.derived.product2.pageObjects.CoreProd2PageFile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CoreProduct2Steps {
	
	CoreProd1PageFile coreProduct1 = new CoreProd1PageFile();
	CoreProd2PageFile coreProduct2 = new CoreProd2PageFile();
	
	@Given("User has navigated to the home page {string}")
	public void user_has_navigated_to_the_home_page(String string) {
		try {
			coreProduct1.navigateToURL(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Then("scroll down till the bottom of the page")
	public void scroll_down_till_the_bottom_of_the_page() {
	   
		try {
			coreProduct2.scrollToTheBottom();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("different links for various categories are present")
	public void different_links_for_various_categories_are_present() {
		try {
			coreProduct2.checkFooterLinks();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("find all the hyperlinks for the footer the into a CSV file and report")
	public void find_all_the_hyperlinks_of_the_into_a_csv_file_and_report() {
		
		try {
			coreProduct2.getLinksIntoCsv();
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
	}

	@And("report if any duplicates are present.")
	public void report_if_any_duplicates_are_present() {
		
		try {
			List<String> dupLinks= coreProduct2.checkForDuplicateFooterLinks();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
