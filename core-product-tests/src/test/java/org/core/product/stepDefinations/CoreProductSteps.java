package org.core.product.stepDefinations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.core.product.pageObjects.PageFactory;
import org.core.product.pageObjects.SearchJacketObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CoreProductSteps extends PageFactory{
	
	SearchJacketObjects searchObj ;
	String parentWindow = "";
	
	
	@Given("User has navigated to the home page URL")
	public void user_has_navigated_to_the_home_page_url() throws InterruptedException {
	   System.out.println("User has navigated to the home page URL");
	   
	   searchObj = getSearhJaketObj();
	   searchObj.getHomePageURL("https://www.nba.com/warriors");
	}
	
	@Then("close the dialog present on the homepage")
	public void close_the_dialog_present_on_the_homepage() {
	  
		try {
			searchObj.clickHomeXbutton();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Then("move to shop menu and click men's section.")
	public void move_to_shop_menu_and_click_men_s_section() {
	
		try {
			
			searchObj.hoverShop();
			
			parentWindow =tdriver.get().getWindowHandle();
			searchObj.clickMensSectionButton();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Then("Filter products with Jackets")
	public void filter_products_with_jackets() {
		try {
			//Swithcing to the new tab
			Set windows = tdriver.get().getWindowHandles();
			Iterator<String> it = windows.iterator();
			while(it.hasNext())
			{
				String child = it.next();
				if(!parentWindow.equalsIgnoreCase(child))
				{
					tdriver.get().switchTo().window(child);
				}
			}
			
			searchObj.filterJackets();
			
		} catch (Exception e) {
			try {
				searchObj.filterJackets();
			
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
	  
	}

	@Then("Get price , title and Seller message for all the products")
	public void get_price_title_and_seller_message_for_all_the_products() {

		File file = new File(System.getProperty("user.dir") + "/" + "ProductData.txt");

		try {

			boolean isCreated = file.createNewFile();

			if (isCreated) {
				System.out.println("New file created");
			} else {
				System.out.println("File creation failed");
			}

			FileWriter output = new FileWriter(file);
			
			List<String> toBeWrittenInFile = searchObj.getAllJackets();

			toBeWrittenInFile.stream().forEach(a -> {
				try {
					output.write(a);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

		} catch (Exception e) {

			e.printStackTrace();
		}
	    
	}

	@Then("hover on the triple dot menu")
	public void hover_on_the_triple_dot_menu() {
	    
		try {
			searchObj.hoverOnFeedMenu();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Then("click on the news and features option")
	public void click_on_the_news_and_features_option() {
		
		
		try {
			searchObj.clickNewsAndFeatures();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Then("count video feeds older than or equal to {int} days old")
	public void count_video_feeds_older_than_or_equal_to_days_old(Integer int1) {
	  
		try {
			int feedCount = searchObj.getVideoFeedCount(int1);
			System.out.println(feedCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	
	
}
