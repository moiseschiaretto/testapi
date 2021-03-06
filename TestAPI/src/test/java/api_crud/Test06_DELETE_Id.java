package api_crud;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class Test06_DELETE_Id {
	 int id = 157;
	 
	 @Test
	 public void delete() {
		 String uri = "https://reqres.in/api/users/" + id;
		 
		 given()
		 	.log().method()
			.log().uri()
	 	.when()
	 		.delete(uri)
	 	.then()
	 		.statusCode(204)
	 		.log().all()
	 	;
	 }
	 
 }