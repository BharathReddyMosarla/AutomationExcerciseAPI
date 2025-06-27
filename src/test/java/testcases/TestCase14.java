package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import routes.Routes;

public class TestCase14 extends BaseClass
{
	@Test									//(dependsOnMethods="testcases.TestCase11.testCreateUser")
	void testUserDetailsByEmail()
	{
		String email = configReader.getProperty("email");
		
		response = given()
			//.formParam("email", TestCase11.email)
				.formParam("email", email)
		.when()
			.get(Routes.GET_USERDETAILSBYEMAIL)
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		JsonPath jsonpath = jsonpath(response);
		
		int responseCode = jsonpath.getInt("responseCode");
		Map<String,String> message = jsonpath.getMap("user");
		
		assertThat(responseCode,is(200));
		assertThat(message.get("email"),is(email));

	
	}

}
