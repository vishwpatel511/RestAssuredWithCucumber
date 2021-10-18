package com.StepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import com.utils.PropReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETRequestStepDefinition {

	private RequestSpecification requestSpecification;
	private Response response;
	private PropReader propreader;
	private String uri;
	private String org_endpoint;
	
	@Given("Github APIs are operational")
	public void github_ap_is_are_operational() {
	
		this.requestSpecification = RestAssured.given();
	}

	@When("{string} and cookies are passed")
	public void and_cookies_are_passed(String string) {
	
		this.requestSpecification = requestSpecification.auth().basic("vishwpatel511", string).header("accept", "application/vnd.github.v3+json");
	}

	@When("{string} is pass as URI with the necassary {string} as params and {string} as endpoint and GET request is made")
	public void is_pass_as_uri_with_the_necassary_as_params_and_as_endpoint_and_get_request_is_made(String uri, String params, String endpoints) throws IOException {

		System.out.println(uri + endpoints);
		this.response = this.requestSpecification.get(uri+endpoints);
		System.out.println(response.then().log().all());
	}

	@Then("Response is sent back by server")
	public void response_is_sent_back_by_server() {
	   
		response = response.andReturn();

	}

	@Then("Status code should be {string}")
	public void status_code_should_be(String statuscode) {
		System.out.println(response.statusCode());
		System.out.println(response.then().log().all());
		
		Assert.assertEquals(Integer.toString(response.statusCode()), statuscode);
	}
	
	@Then("repo namely {string} should be present")
	public void repo_namely_should_be_present(String reponame) {
	
		System.out.println(response.body().prettyPrint().contains(reponame));
		Assert.assertTrue(response.body().prettyPrint().contains(reponame));
	}
	
}
