package com.StepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import com.factory.ObjectFactory;
import com.utils.PropReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETRequestStepDefinition {

	ObjectFactory factory;
	PropReader reader = new PropReader();
	private RequestSpecification requestSpecification;
	private Response response;
	private PropReader propreader;
	
	public GETRequestStepDefinition(ObjectFactory factory) {
		
		this.factory = factory;
		
	}
	
	@Given("Github APIs are operational")
	public void github_ap_is_are_operational() throws InterruptedException {
	  
		Thread.sleep(5000);
		factory.setRequestSpecification(RestAssured.given());
	}


	@When("{string} is pass as URI with the necassary {string} as params and {string} as endpoint and GET request is made")
	public void is_pass_as_uri_with_the_necassary_as_params_and_as_endpoint_and_get_request_is_made(String uri, String string2, String endpoints) throws IOException {
	
		uri = reader.getString("URI");
		System.out.println(uri + endpoints);
		factory.setResponse(factory.getRequestSpecification().get(uri+endpoints));
	//	System.out.println(factory.getResponse().then().log().all());
	}

	@Then("Response is sent back by server")
	public void response_is_sent_back_by_server() {
	    
//		factory.setResponse(factory.getResponse().andReturn());
	}

	@Then("Status code should be {int}")
	public void status_code_should_be(int statuscode) {
	
	//	System.out.println(factory.getResponse().then().log().all());
		Assert.assertEquals(factory.getResponse().statusCode(), 200);
		
	}

	@Then("repo namely {string} should be present")
	public void repo_namely_should_be_present(String reponame) throws IOException {
		
		reponame = reader.getString("RepoName");
		System.out.println(reponame);
		System.out.println(factory.getResponse().body().prettyPrint().contains(reponame));
		Assert.assertTrue(factory.getResponse().body().prettyPrint().contains(reponame));
	}

}
