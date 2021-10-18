package com.Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\main\\java\\com\\features\\GETRequest.feature"},
		glue = {"com/StepDefinitions"},
		plugin = {"pretty"
		},
		publish = true,
		monochrome = true
		)
public class RunnerTest {

}
