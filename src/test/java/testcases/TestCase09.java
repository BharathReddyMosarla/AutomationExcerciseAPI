package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import routes.Routes;

public class TestCase09 extends BaseClass
{
	@Test
	void testDeleteLogin()
	{
		
		response = given()
		.when()
			.delete(Routes.DELETE_DELETELOGIN)
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		JsonPath jsonpath = jsonpath(response);
		
		int responseCode = jsonpath.getInt("responseCode");
		String message = jsonpath.getString("message");
		
		assertThat(responseCode,is(405));
		assertThat(message,is("This request method is not supported."));

	}

}
