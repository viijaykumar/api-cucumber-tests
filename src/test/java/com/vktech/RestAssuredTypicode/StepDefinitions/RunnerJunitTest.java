package com.vktech.RestAssuredTypicode.StepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		plugin	= 	{"pretty",
				  	 "json:target/cucumber-json-report.json",
					 "html:target/site/cucumber-pretty"},
		
		glue 	= 	{"com/vktech/RestAssuredTypicode/StepDefinitions"},
		features= 	{"src/test/resources/ValidatePostDeleteAndPut.feature"}
				
				)
public class RunnerJunitTest {
}
