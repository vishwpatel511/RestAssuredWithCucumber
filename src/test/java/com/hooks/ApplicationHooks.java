package com.hooks;

import java.io.IOException;

import com.factory.ObjectFactory;
import com.utils.PropReader;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class ApplicationHooks {


	ObjectFactory factory;
	PropReader reader = new PropReader();
	
	public ApplicationHooks(ObjectFactory factory) {
		
		this.factory = factory;
		
	}
	
	@Before(order = 0)
	public void github_ap_is_are_operational(Scenario sc) throws InterruptedException {
		  
		Thread.sleep(5000);
		factory.setRequestSpecification(RestAssured.given());
	}
	
}
