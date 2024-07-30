package org.derived.product2.pageObjects;

import org.automation.framework.Base;


public class PageFactory extends Base{
	
	CoreProd2PageFile coreProduct2;
	
	public CoreProd2PageFile getSearhJaketObj() {
		if(coreProduct2 == null)
		{
			coreProduct2 = new CoreProd2PageFile();
		}	
		return coreProduct2;
			
	}
	
}
