package testcases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import io.restassured.path.json.JsonPath;

import routes.Routes;

public class TestCase01 extends BaseClass
{
	@Test
	public void testGetAllProducts()
	{
		// Step 1: Send GET request
		response = given()
		.when()
			.get(Routes.GET_ALLPRODUCTS)
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
//		// Step 2: Get full HTML response as string
//        String htmlBody = response.getBody().asString();
//
//        // Step 3: Extract embedded JSON from <body>...</body>
//        // Find index of first { and last }
//        int start = htmlBody.indexOf('{');
//        int end = htmlBody.lastIndexOf('}') + 1;
//        String jsonString = htmlBody.substring(start, end);
//
//        // Step 4: Parse extracted string as JSON
//        JsonPath jsonPath = new JsonPath(jsonString);
		
		JsonPath jsonPath =jsonpath(response);

        // Step 5: Validate responseCode and products count
        int responseCode = jsonPath.getInt("responseCode");
        int productCount = jsonPath.getList("products").size();

        assertThat(responseCode, is(200));
        assertThat(productCount, greaterThan(1));
		
	}

}
