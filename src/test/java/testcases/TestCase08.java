package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import routes.Routes;

public class TestCase08 extends BaseClass
{
	@Test
	void testPostLoginonlypassword()
	{
		
		String password = configReader.getProperty("password");
		
		response = given()
		    .formParam("password", password)
		.when()
			.post(Routes.POST_VERIFYLOGINWITHOUTPARAMETER)
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		JsonPath jsonpath = jsonpath(response);
		
		int responseCode = jsonpath.getInt("responseCode");
		String message = jsonpath.getString("message");
		
		assertThat(responseCode,is(400));
		assertThat(message,is("Bad request, email or password parameter is missing in POST request."));

	}

}
