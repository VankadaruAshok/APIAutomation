package com.api.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty:target/cucumber/cucumber.txt",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "html:target/cucumber/report",
		"json:target/cucumber/cucumber.json", "com.api.utils.MyTestListener" }, features = {
				"src/test/resources/features/" }, glue = { "com.api.stepdefinition" }, monochrome = true, tags = ""

)
public class TestRunner extends AbstractTestNGCucumberTests {

}
