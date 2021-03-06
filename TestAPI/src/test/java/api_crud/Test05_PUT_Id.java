package api_crud;

import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;

public class Test05_PUT_Id {
	int id = 200; 
	
	 @Test
	 public void put() {
		 		String uri = "https://reqres.in/api/users/" + id;
				String corpo = "{\"name\": \"Maria\", \"job\": \"QA - Put\"}";
							
				// Given
					Response responsePost = given()
					.contentType("application/json")
					.body(corpo)
					.log().method()
					.log().uri()
				// When
					.when()
					.put(uri);
				// Then
				responsePost.then()
					.log().body()
					.statusCode(200)
					.body("name", Matchers.is("Maria"))
					.body("job", Matchers.is("QA - Put"))
					.body("updatedAt", Matchers.notNullValue())
				;		
	 
	 }
}