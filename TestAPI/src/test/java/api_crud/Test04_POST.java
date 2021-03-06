package api_crud;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

	// Teste com o M?todo POST realizando o Assert / Validacao no Registro da Lista do Response
	public class Test04_POST {
		
		@Test
		public void post() {
			String uri = "https://reqres.in/api/users";
			String corpo = "{\"name\": \"Moises\", \"job\": \"QA - Post\"}";
						
			// Given
				Response responsePost = given()
				.contentType("application/json")
				.body(corpo)
				.log().method()
				.log().uri()
			// When
				.when()
				.post(uri);
			// Then
			responsePost.then()
				.log().body()
				.statusCode(201)
				.body("name", Matchers.is("Moises"))
				.body("job", Matchers.is("QA - Post"))
				.body("createdAt", Matchers.notNullValue())
			;		
		}
}

