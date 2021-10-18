package api_crud;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;

// Teste com o Método GET ALL realizando o Assert / Validacao somente no Primeiro Registro / Posicao
// do Array do Response
public class Test02_GET_Array_P0  {
	int id = 1;
	String email = "george.bluth@reqres.in";
	String first_name = "George";
	String last_name = "Bluth";
	String avatar = "https://reqres.in/img/faces/1-image.jpg";
	
	@Test
	public void getArray_P0() {
		String uri = "https://reqres.in/api/users";
			
		given()
			.log().method()
			.log().uri()
		.when()
			.get(uri)
		.then()
			.statusCode(200)
			.log().body()
			// Validar o Primeiro Registro [0] do ARRAY DO RESPONSE >> "data": [...]
			.body("data.id[0]", Matchers.is(id))
			.body("data.email[0]", Matchers.is(email))
			.body("data.first_name[0]", Matchers.is(first_name))
			.body("data.last_name[0]", Matchers.is(last_name))
			.body("data.avatar[0]", Matchers.is(avatar))
		;
	}
}
