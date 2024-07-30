package org.core.product.pageObjects;

import org.automation.framework.Base;

public class PageFactory extends Base{
	
	SearchJacketObjects searchJacketObj ;

	public SearchJacketObjects getSearhJaketObj() {
		if(searchJacketObj == null)
		{
			searchJacketObj = new SearchJacketObjects();
		}	
		return searchJacketObj;
			
	}

	
	
	
	

}
