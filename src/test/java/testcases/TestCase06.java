package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import routes.Routes;

public class TestCase06 extends BaseClass
{
	@Test
	void testPostSearchproductWithoutParameter()
	{
		
		
		response = given()
		.when()
			.post(Routes.POST_SEARCHPRODUCTWITHOUTPARAMETER)
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		JsonPath jsonpath = jsonpath(response);
		
		int responseCode = jsonpath.getInt("responseCode");
		String message = jsonpath.getString("message");
		
		assertThat(responseCode,is(400));
		assertThat(message,is("Bad request, search_product parameter is missing in POST request."));

	}

}
