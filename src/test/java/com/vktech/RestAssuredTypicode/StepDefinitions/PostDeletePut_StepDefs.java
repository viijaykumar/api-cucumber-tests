package com.vktech.RestAssuredTypicode.StepDefinitions;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDeletePut_StepDefs {
	
	String url;
	String path = "/posts";
	private RequestSpecification request;
	private Response response;
	JSONObject json;
	
	
	@Given("^the api is up and running on \"([^\"]*)\"$")
	public void the_api_is_up_and_running_on(String BaseURI) throws Throwable {
			this.url = BaseURI;
			request = RestAssured.given();
			request.header("Content-Type","application/json");	
	}
		
		
		
	@SuppressWarnings("unchecked")
	@When("^user performs POST request for /posts$")
	public void user_performs_post_request_to_posts(DataTable dataTable) throws Throwable {
			
			Map<String, String> POSTbody = new HashMap<String, String>();
			
			for (DataTableRow row : dataTable.getGherkinRows()) {
				POSTbody.put(row.getCells().get(0), row.getCells().get(1));	
			}
			
			json = new JSONObject();
			json.putAll(POSTbody);
			request.body(json.toJSONString());
			
			System.out.println("POST Location Url is: "+ url+path);
			response = request.post(url+path);
			System.out.println("POST Response is: "+ response.prettyPrint());
	}
		
		
		
	@Then("^the user should receive status code for the /specific-request is (\\d+)$")
	public void the_user_should_receive_status_code_for_the_specificRequest_is(int StatusCode) throws Throwable {
		    //jsonValidatableResponse = response.then().statusCode(StatusCode).log().all();
			int code = response.getStatusCode();
			Assert.assertEquals(code, StatusCode);
	}

	
		
	@And("^the user validates the blog in json response with parameter \"([^\"]*)\"$")
	public void the_user_validates_the_blog_in_json_response_with_parameter(String IDNo) throws Throwable {
	    given()
	    	.param("id", IDNo)
	    		.when()
	    	.contentType(ContentType.JSON)
	    	.get(url+path)
	    		.then()
	    	.assertThat()
	    	.statusCode(200)
	    		.and()
	    	.body("title", hasItem("my blog post "+IDNo));
	    
	}
	
	
	@SuppressWarnings("unchecked")
	@When("^user performs PUT request for /posts/id \"([^\"]*)\"$")
	public void user_performs_PUT_request_for_posts_id(String pathID, DataTable dataTable) throws Throwable {
		Map<String, String> PUTbody = new HashMap<String, String>();
		
		for (DataTableRow row : dataTable.getGherkinRows()) {
			PUTbody.put(row.getCells().get(0), row.getCells().get(1));	
		}
		
		json = new JSONObject();
		json.putAll(PUTbody);
		request.body(json.toJSONString());
		
		System.out.println("PUT Location Url is: "+ url+path+"/"+pathID);
		
		response = request.put(url+path+"/"+pathID);
		
		System.out.println("PUT Response is: "+ response.prettyPrint());
	
	}
	
	@When("^user performs DELETE request for a specific ID$")
	public void user_performs_DELETE_request_for_a_specific_ID(DataTable id) throws Throwable {
		
		System.out.println("ID to be deleted is : "+url+path+"/"+id.asList(String.class).get(0));
	    
		response = request.delete(url+path+"/"+id.asList(String.class).get(0));

	}
	
}
