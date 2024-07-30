package org.derived.product2.runners;


import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"},
        features= "src/test/resources/features",
        glue="org.core.product2.stepDefinations",
        monochrome = true
        )
/**
 * Class for run cucumber features.
 */
public class cucumberOptions extends AbstractTestNGCucumberTests{
	
}
