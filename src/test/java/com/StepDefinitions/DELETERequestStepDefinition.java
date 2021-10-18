package com.StepDefinitions;

import java.io.IOException;

import com.factory.ObjectFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.PropReader;

import POJO_Classes.POST_Repo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import junit.framework.Assert;

public class DELETERequestStepDefinition {

	ObjectFactory factory = new ObjectFactory();
	private String finalresponse;
	// Assigning the mapper as the object mapper
	ObjectMapper mapper;
	//creating the object of POJO class which will help to create the request payload.
	POST_Repo createrepo = new POST_Repo();
	
	PropReader reader = new PropReader();
	
	@Given("Github APIs are operational to perform actions")
	public void github_ap_is_are_operational_to_perform_actions() {
	   
		factory.setRequestSpecification(RestAssured.given());	
	}

	@When("{string} and cookies are passed for DELETE request")
	public void and_cookies_are_passed_for_delete_request(String string) throws IOException {
	
		factory.setAuth(reader.getString("Token"));
		factory.setRequestSpecification(factory.getRequestSpecification().auth().preemptive().basic("vishwpatel511", factory.getAuth()).header("accept", "application/vnd.github.v3+json"));
		
	}

	@When("{string} is pass as URI with the necassary {string} as params and {string} as a repo to delete and DELETE request is made")
	public void is_pass_as_uri_with_the_necassary_as_params_and_as_a_repo_to_delete_and_delete_request_is_made(String uri, String endpoint, String repo) {
		System.out.println(uri + endpoint+repo);
		factory.setResponse(factory.getRequestSpecification().delete(uri + endpoint+repo));
		System.out.println();
	}

	@Then("Response would be sent back by server")
	public void response_would_be_sent_back_by_server() {

		factory.setResponse(factory.getResponse().then().extract().response());
	}

	@Then("Status code should be {int} for DELETE request")
	public void status_code_should_be_for_delete_request(int statuscode) {
		Assert.assertEquals(factory.getResponse().statusCode(), statuscode);
	}

}
