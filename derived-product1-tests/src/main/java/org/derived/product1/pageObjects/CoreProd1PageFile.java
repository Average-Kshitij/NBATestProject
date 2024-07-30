package org.derived.product1.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.automation.framework.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CoreProd1PageFile extends Base{
	
	
	public CoreProd1PageFile(){
		//super(CoreProd1PageFile.class);
		PageFactory.initElements(tdriver.get(), this);	
	}
	
	@FindBy(xpath = "//div[@role='tablist']/button") private List<WebElement> we_slides;
	@FindBy(xpath = "//div[@role='tablist']/button/div") private List<WebElement> we_slideTexts;
	@FindBy(xpath = "//div[@data-testid='tile-hero-stories']  //a[@class='TileHero_tileLink__VTMPI']") private WebElement we_slideDynamicImage;
	
	
	
	
	public int countNoOfSlides()
	{
		WebDriverWait wait = new WebDriverWait(tdriver.get(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(we_slides));
		return we_slides.size();
	}
	
	public List<String> getTitleOfSlides()
	{
		List<String> slideList = new ArrayList<String>();
		WebDriverWait wait = new WebDriverWait(tdriver.get(), Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(we_slideTexts));
		
		we_slideTexts.stream().forEach(a->slideList.add(a.getText()));
		
		return slideList;
	}
	
	public Map<String,Long> getSlideTiming()
	{
 		Map<String,Long> slideTimings=  new HashedMap<String, Long>();
		String tempLink="",currentLink="";
		long startTime=0,endTime=0,currentTime=0,totalTime=0;
		for(int i = 0;i<4;i++)
		{
			tempLink = we_slideDynamicImage.getAttribute("href");
			startTime = System.currentTimeMillis();
		do
		{
			currentLink = we_slideDynamicImage.getAttribute("href");
			currentTime= System.currentTimeMillis();
			totalTime = (endTime - startTime) /1000;
		}
		while(tempLink.equals(currentLink) || totalTime>20);
		endTime = System.currentTimeMillis();
		totalTime = (endTime - startTime ) /1000;
		
		slideTimings.put("Slide "+i, totalTime);
		}
		
		return slideTimings;
		
	}
	
	
	
	
	

}
