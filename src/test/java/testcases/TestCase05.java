package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import routes.Routes;

public class TestCase05 extends BaseClass
{
	@Test
	void testPostSearchproduct()
	{
		String searchProduct = configReader.getProperty("searchProduct");
		
		response = given()
				.formParam("search_product", searchProduct)
		.when()
			.post(Routes.POST_SEARCHPRODUCT)
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		JsonPath jsonpath = jsonpath(response);
		
		int responseCode = jsonpath.getInt("responseCode");
		int searchProductCount = jsonpath.getList("products").size();
		
		assertThat(responseCode,is(200));
		assertThat(searchProductCount,greaterThan(0));

	}
}
