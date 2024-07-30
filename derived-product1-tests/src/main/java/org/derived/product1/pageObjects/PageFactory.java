package org.derived.product1.pageObjects;

import org.automation.framework.Base;


public class PageFactory extends Base{
	
	CoreProd1PageFile coreProduct1;
	
	public CoreProd1PageFile getSearhJaketObj() {
		if(coreProduct1 == null)
		{
			coreProduct1 = new CoreProd1PageFile();
		}	
		return coreProduct1;
			
	}
	
}
