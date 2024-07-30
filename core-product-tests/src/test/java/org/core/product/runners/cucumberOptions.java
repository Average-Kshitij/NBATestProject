package org.core.product.runners;


import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"},
        features= "src/test/resources/features",
        glue="org.core.product.stepDefinations",
        monochrome = true
      
        )
/**
 * Class for run cucumber features.
 */
public class cucumberOptions extends AbstractTestNGCucumberTests{
//	@Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
