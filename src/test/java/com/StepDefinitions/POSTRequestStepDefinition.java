package com.StepDefinitions;

import org.json.simple.JSONObject;

import com.factory.ObjectFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJO_Classes.POST_Repo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import junit.framework.Assert;

public class POSTRequestStepDefinition {
	
	ObjectFactory factory = new ObjectFactory();
	private String finalresponse;
	// Assigning the mapper as the object mapper
	ObjectMapper mapper;
	
	//creating the object of POJO class which will help to create the request payload.
	POST_Repo createrepo = new POST_Repo();
	
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
	   
		mapper = new ObjectMapper();
		createrepo.setName("RandomrepoTobeDeleted");
		createrepo.setPrivate(true);
		createrepo.setDescription("This repo is supposed to be deleted");
		createrepo.setHasIssues(true);
		createrepo.setHomepage("https://www.github.com");
		createrepo.setHasProjects(false);
		createrepo.setHasWiki(true);
		
		
		try {
			
			// converting create repo object into string
			this.finalresponse = mapper.writeValueAsString(createrepo);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		factory.setRequestSpecification(factory.getRequestSpecification().body(finalresponse));
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
	
	@Then("Status code should be {int} for post request")
	public void status_code_should_be_for_post_request(int statuscode) {
		
		Assert.assertEquals(factory.getResponse().statusCode(), statuscode);
		
	}
}
