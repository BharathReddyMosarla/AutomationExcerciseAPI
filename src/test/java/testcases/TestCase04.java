package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import routes.Routes;

public class TestCase04 extends BaseClass
{
	@Test
	void testGetAllBarands()
	{
		response = given()
		.when()
			.put(Routes.PUT_ALLBRANDS)
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		JsonPath jsonpath = jsonpath(response);
		
		int responseCode = jsonpath.getInt("responseCode");
		String responseMessage = jsonpath.getString("message");
		
		assertThat(responseCode,is(405));
		assertThat(responseMessage,is("This request method is not supported."));	
	}
}