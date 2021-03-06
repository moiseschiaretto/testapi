package api_crud;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;

//Teste com o Método GET ID realizando o Assert / Validacao no Registro Retornado
public class Test01_GET_Id_LISTA  {
	int id = 1;
	String email = "george.bluth@reqres.in";
	String first_name = "George";
	String last_name = "Bluth";
	String avatar = "https://reqres.in/img/faces/1-image.jpg";
	
	@Test
	public void getIdLista() {
		String uri = "https://reqres.in/api/users/" + id;
			
		given()
			.log().method()
			.log().uri()
		.when()
			.get(uri)
		.then()
			.statusCode(200)
			.log().body()
			.body("data.id", Matchers.is(id))
			.body("data.email", Matchers.is(email))
			.body("data.first_name", Matchers.is(first_name))
			.body("data.last_name", Matchers.is(last_name))
			.body("data.avatar", Matchers.is(avatar))
		;
	}
}
