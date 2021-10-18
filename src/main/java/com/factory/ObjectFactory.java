package com.factory;

import com.utils.PropReader;
import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ObjectFactory {

	
	private RequestSpecification requestSpecification;
	private Response response;
	private PropReader propreader;
	private String uri;
	private String org_endpoint;
	private String auth;
	
	public RequestSpecification getRequestSpecification() {
		return requestSpecification;
	}
	public void setRequestSpecification(RequestSpecification requestSpecification) {
		this.requestSpecification = requestSpecification;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getOrg_endpoint() {
		return org_endpoint;
	}
	public void setOrg_endpoint(String org_endpoint) {
		this.org_endpoint = org_endpoint;
	}
	
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	
	
	
}
