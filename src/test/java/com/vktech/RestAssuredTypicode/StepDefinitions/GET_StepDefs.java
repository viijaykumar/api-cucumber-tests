package com.vktech.RestAssuredTypicode.StepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GET_StepDefs {
	
	
	@Given("^the API is up and running for \"([^\"]*)\"$")
	public void the_API_is_up_and_running_for(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user performs a GET request for below$")
	public void user_performs_a_GET_request_for_below(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    
	}

	@Then("^the user should receive status code of (\\d+)$")
	public void the_user_should_receive_status_code_of(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@And("^the user verifies book volumes on Endpoint for a given \"([^\"]*)\"$")
	public void the_user_verifies_book_volumes_on_Endpoint_for_a_given(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

}
