package api_crud;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.json.simple.JSONObject;

//Teste com o M?todo GET ALL realizando o Assert / Validacao nos Registros do Array do Response
public class Test03_GET_All  {
	
	// Dados dos Registros da API para o Assert / Valida??o do Response	
	@DataProvider(name = "dataGetAll")
	public Object[][] dataGetAll() {
				
		return new Object [][] {
			{1, "george.bluth@reqres.in", "George" ,"Bluth", "https://reqres.in/img/faces/1-image.jpg"},
			{2, "janet.weaver@reqres.in", "Janet" , "Weaver", "https://reqres.in/img/faces/2-image.jpg"},
			{3, "emma.wong@reqres.in", "Emma", "Wong", "https://reqres.in/img/faces/3-image.jpg"},
			{4, "eve.holt@reqres.in", "Eve", "Holt", "https://reqres.in/img/faces/4-image.jpg"},
			{5, "charles.morris@reqres.in", "Charles", "Morris", "https://reqres.in/img/faces/5-image.jpg"},
			{6, "tracey.ramos@reqres.in", "Tracey", "Ramos", "https://reqres.in/img/faces/6-image.jpg"}
		};
	}
	
	
	@Test(dataProvider = "dataGetAll")
	public void getId(int id, String email, String first_name, String last_name, String avatar) {
		JSONObject response = new JSONObject();
		String uri = "https://reqres.in/api/users/";
		int i;
		for (i=0; i<=5; i++) { 	
			given()
				.log().method()
				.log().uri()
			.when()
				.get(uri)
			.then()
				.statusCode(200)
				.log().body()
				.body("data.id[" + i + "]", Matchers.is(response(id)))
				.body("data.email[" + i + "]", Matchers.is(response(email)))
				.body("data.first_name[" + i + "]", Matchers.is(response(first_name)))
				.body("data.last_name[" + i + "]", Matchers.is(response(last_name)))
				.body("data.avatar[" + i + "]", Matchers.is(response(avatar)))
			;
		}	
			
	}
	
	
	private Matcher<Object> response(String info_registro) {
		// TODO Auto-generated method stub
		return null;
	}


	private Matcher<Object> response(int id_registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
