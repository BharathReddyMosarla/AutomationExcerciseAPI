package testcases;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;


import io.restassured.path.json.JsonPath;
import routes.Routes;

public class TestCase02 extends BaseClass
{
	
	@Test
	public void testPostAllProducts()
	{
		response =	
		given()
		.when()
			.post(Routes.POST_ALLPRODUCTS)
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		JsonPath jsonPath =jsonpath(response);

	     int responseCode = jsonPath.getInt("responseCode");
	     String message = jsonPath.getString("message");

	     assertThat(responseCode, is(405));
	     assertThat(message, is("This request method is not supported."));
		
		
		
	}
}
