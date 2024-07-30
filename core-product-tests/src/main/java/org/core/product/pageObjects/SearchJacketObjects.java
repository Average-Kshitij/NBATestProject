package org.core.product.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.automation.framework.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchJacketObjects extends Base{
	
	
	public SearchJacketObjects() {
		PageFactory.initElements(tdriver.get(), this);
	}
	
	@FindBy(xpath = "//div[@role='dialog'] //div[text()='x']") private WebElement we_xButton;
	@FindBy(xpath = "//nav[@aria-label='header-primary-menu'] //li //span[text()='Shop']") private WebElement we_shopButton;
	@FindBy(xpath = "//nav[@aria-label='submenu'] //a[contains(text(),'Men')]") private WebElement we_mensSectionButton;
	@FindBy(xpath = "//div[@class='side-nav-facets'] //li/a[@data-trk-id='jackets']") private WebElement we_selectJackets;
	@FindBy(xpath = "//div[@class='product-card row']") private List<WebElement> we_allJackets;
	@FindBy(xpath = "//li[@role='menuitem'] //a/span[text()='...']") private WebElement we_menuFeedIcon;
	@FindBy(xpath = "//nav[@class='_headerSecondaryMenu_1d1mm_28'] //li[@role='menuitem'] //a[@title='News & Features']") private WebElement we_newsAndFeatures;
	
	
	int feedCount;
	
	
	
	public void clickHomeXbutton()
	{
		tdriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		clickButton(we_xButton);
		
	}
	
	public void getHomePageURL(String URL)
	{	
		tdriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		navigateToURL(URL);
		
	}
	
	public void hoverShop()
	{
		moveToElementAction(we_shopButton);
	}
	
	public void clickMensSectionButton()
	{
		clickAction(we_mensSectionButton);
	}
	
	public void filterJackets()
	{
		clickAction(we_selectJackets);
	}
	
	
	public List<String> getAllJackets()
	{
		
		List<String> productData = new ArrayList<String>();
		List<WebElement> productPriceElems = new ArrayList<WebElement>();
		List<WebElement> productTitleElems = new ArrayList<WebElement>();
		List<WebElement> noOfPages = new ArrayList<WebElement>();
		int j=0;
		noOfPages = tdriver.get().findElements(By.xpath("//div[@class='grid-paginator'] //li[contains(@class,'show-for-large')]/a"));
		while(j < noOfPages.size() )
		{
		noOfPages = tdriver.get().findElements(By.xpath("//div[@class='grid-paginator'] //li[contains(@class,'show-for-large')]/a"));
		clickAction(noOfPages.get(j));
		productPriceElems = tdriver.get().findElements(By.xpath("//div[@class='product-card row'] //div[@class='price-row'] [1] //span[@class='money-value'] //span[@class='sr-only']"));
		productTitleElems = tdriver.get().findElements(By.xpath("//div[@class='product-card row'] //div[@class='product-card-title'] //a"));
		for(int i = 0 ; i<productPriceElems.size();i++) {
			String temp ="";
			temp+= "Price : "+productPriceElems.get(i).getAttribute("innerHTML");
			temp+= "\nTitle : "+productTitleElems.get(i).getText();
			temp+= "\nSeller Message : Not sure which element is needed here\n\n";
			
			productData.add(temp);
		}
		j++;
		}
		
		return productData;
		
		
	}
	
	public void hoverOnFeedMenu()
	{
		moveToElementAction(we_menuFeedIcon);
	}
	
	public void clickNewsAndFeatures()
	{
		clickButton(we_newsAndFeatures);
	}
	
	public int getVideoFeedCount(int daysOld)
	{
		
		
		List<WebElement> videoFeedCount = tdriver.get().findElements(By.xpath(
				"//div[@data-testid='heading'] //*[text()='VIDEOS']/parent::div/parent::div //li //div[@data-testid='tile-meta'] //span[contains(text(),'d')]"));
		;
		videoFeedCount.stream().forEach(a -> {
			String feedDyasText = a.getText();
			int currFeedDays = Integer.parseInt(feedDyasText.trim().replaceAll("[^0-9]", ""));
			if (currFeedDays >= daysOld) {
				feedCount++;
			}

		});
		
	return feedCount;
	}

}
