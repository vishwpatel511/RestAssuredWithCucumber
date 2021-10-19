package com.factory;

import com.utils.PropReader;
import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ObjectFactory {

	
	private RequestSpecification requestSpecification;
	private Response response;
	private PropReader propreader;
	private String auth;
//	private String uri;
	
	/*public ObjectFactory(RequestSpecification requestSpecification, Response response, PropReader propreader, String auth) {
		
		this.requestSpecification = requestSpecification;
		this.response = response;
		this.propreader = propreader;
		this.auth = auth;
	}
	*/
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
	
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
}
