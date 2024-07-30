package org.derived.product2.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.automation.framework.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoreProd2PageFile extends Base{

	
	List<String[]> footerLinks =  new ArrayList<String[]>();
	String filePath = System.getProperty("user.dir")+"/footerLinks.csv";
	List<String> dupfooterLinks =  new ArrayList<String>();
	
	public CoreProd2PageFile()
	{
		PageFactory.initElements(tdriver.get(), this);
	}
	
	@FindBy(xpath ="//footer //a") private List<WebElement> we_footerLinks;
	
	public void scrollToTheBottom()
	{
		scrollTillTheBottom();
	}
	
	public void checkFooterLinks()
	{
		WebDriverWait wait = new WebDriverWait(tdriver.get(), Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(we_footerLinks));
	}
	
	public void getLinksIntoCsv()
	{
			we_footerLinks.stream().forEach(a -> {
			footerLinks.add(new String[] { a.getAttribute("href") });
		});

		writeCsvData(filePath, footerLinks);
	}
	
	public List<String> checkForDuplicateFooterLinks()
	{
		boolean isLinkDuplicate = false;
		
		Set<String> dupCheckSet = new HashSet<String>();
		
		for(int i=0;i<footerLinks.size();i++ )
		{
			String currentLink = footerLinks.get(i)[0];
			
			if(!dupCheckSet.add(currentLink))
			{
				dupfooterLinks.add(currentLink);
			}
		}
		
		return dupfooterLinks;
	}
	
	
}
