package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import routes.Routes;

public class TestCase07 extends BaseClass
{
	@Test
	void testPostLoginValidDetails()
	{
		String username = configReader.getProperty("email");
		String password = configReader.getProperty("password");
		
		response = given()
				
			.formParam("email", username)
		    .formParam("password", password)
		.when()
			.post(Routes.POST_VERIFYLOGINVALID)
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		JsonPath jsonpath = jsonpath(response);
		
		int responseCode = jsonpath.getInt("responseCode");
		String message = jsonpath.getString("message");
		
		assertThat(responseCode,is(200));
		assertThat(message,is("User exists!"));

	}

}
