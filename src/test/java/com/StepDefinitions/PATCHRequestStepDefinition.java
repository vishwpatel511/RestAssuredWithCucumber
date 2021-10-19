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

	
	ObjectFactory factory;
	private String finalresponse;
	// Assigning the mapper as the object mapper
	ObjectMapper mapper;
	//creating the object of POJO class which will help to create the request payload.
	POST_Repo createrepo = new POST_Repo();
	
	PropReader reader = new PropReader();
	
	public PATCHRequestStepDefinition(ObjectFactory factory) {
		
		this.factory = factory;
		
	}


	@When("{string} is prepared to update a repo")
	public void is_prepared_to_update_a_repo(String payload) throws IOException {
	  
		mapper = new ObjectMapper();
		createrepo.setName(reader.getString("NewName"));
		
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
	public void is_passed_as_uri_with_the_and_is_passed_as_endpoint_and_patch_request_is_made(String uri, String endpoint, String reponame) throws IOException {
		uri = reader.getString("URI");
		reponame = reader.getString("RepoName");
		System.out.println(uri + endpoint+reponame);
		factory.setResponse(factory.getRequestSpecification().patch(uri + endpoint+ reponame));
		System.out.println();
		
	}


	@Then("response code should be {int} for PATCH request")
	public void response_code_should_be_for_patch_request(int statuscode) {
	
		Assert.assertEquals(factory.getResponse().statusCode(), statuscode);
	}
	
	
}
