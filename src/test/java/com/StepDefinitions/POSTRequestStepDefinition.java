package com.StepDefinitions;

import org.json.simple.JSONObject;

import com.factory.ObjectFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import junit.framework.Assert;

public class POSTRequestStepDefinition {
	
	ObjectFactory factory = new ObjectFactory();
	JSONObject json;
	
	@Given("Github APIs are up and operational")
	public void github_ap_is_are_operational() {
	  
		factory.setRequestSpecification(RestAssured.given());
	}
	
	@When("{string} and {string} cookies are passed")
	public void and_cookies_are_passed(String auth, String cookies) {
	
		factory.setAuth(auth);
		factory.setRequestSpecification(factory.getRequestSpecification().auth().preemptive().basic("vishwpatel511", auth).header("accept", "application/vnd.github.v3+json"));
	}

	@When("{string} is prepared")
	public void is_prepared(String string) {
	   
		json = new JSONObject();
		json.put("name", "ThisisCucumberWithRA");
		System.out.println(json.toJSONString());
		factory.setRequestSpecification(factory.getRequestSpecification().body(json.toJSONString()));
	}

	@When("{string} is passed as URI with the {string} as endpoint and POST request is made")
	public void is_passed_as_uri_with_the_as_endpoint_and_post_request_is_made(String uri, String endpoint) {
	  
		System.out.println(uri + endpoint);
		factory.setResponse(factory.getRequestSpecification().post(uri+endpoint));
		System.out.println();
	}
	
	@Then("Response is sent back by server for post request")
	public void response_is_sent_back_by_server_for_post_request() {
	    
	factory.setResponse(factory.getResponse().then().extract().response());
	}
	
	@Then("Status code should be {string} for post request")
	public void status_code_should_be_for_post_request(String statuscode) {
		
		Assert.assertEquals(factory.getResponse().statusCode(), statuscode);
		
	}
}
