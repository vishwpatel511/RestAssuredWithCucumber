package com.StepDefinitions;

import java.io.IOException;

import com.factory.ObjectFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.PropReader;

import POJO_Classes.POST_Repo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import junit.framework.Assert;

public class PATCHRequestStepDefinition {

	
	ObjectFactory factory = new ObjectFactory();
	private String finalresponse;
	// Assigning the mapper as the object mapper
	ObjectMapper mapper;
	//creating the object of POJO class which will help to create the request payload.
	POST_Repo createrepo = new POST_Repo();
	
	PropReader reader = new PropReader();
	
	@Given("Github APIs are running and operational")
	public void github_ap_is_are_running_and_operational() {
		
		factory.setRequestSpecification(RestAssured.given());
	}

	@When("{string} as a token and {string} as a cookies are passed")
	public void as_a_token_and_as_a_cookies_are_passed(String auth, String cookies) throws IOException {
	
		factory.setAuth(reader.getString("Token"));
		factory.setRequestSpecification(factory.getRequestSpecification().auth().preemptive().basic("vishwpatel511", factory.getAuth()).header("accept", "application/vnd.github.v3+json"));
		
	}

	@When("{string} is prepared to update a repo")
	public void is_prepared_to_update_a_repo(String payload) {
	  
		mapper = new ObjectMapper();
		createrepo.setName("bfvuwbrvbu");
		
		try {
			
			// converting create repo object into string
			this.finalresponse = mapper.writeValueAsString(createrepo);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		factory.setRequestSpecification(factory.getRequestSpecification().body(finalresponse));
	
	}

	@When("{string} is passed as URI with the {string} and {string} is passed as endpoint and PATCH request is made")
	public void is_passed_as_uri_with_the_and_is_passed_as_endpoint_and_patch_request_is_made(String uri, String endpoint, String reponame) {
	   
		System.out.println(uri + endpoint+"deletedrepo");
		factory.setResponse(factory.getRequestSpecification().patch(uri + endpoint+"RandomrepoTobeDeletedupdated"));
		System.out.println();
		
	}

	@Then("response is received from the server")
	public void response_is_received_from_the_server() {
	  
		factory.setResponse(factory.getResponse().then().extract().response());
	}

	@Then("response code should be {int} for PATCH request")
	public void response_code_should_be_for_patch_request(int statuscode) {
	
		Assert.assertEquals(factory.getResponse().statusCode(), statuscode);
	}
	
	
}
