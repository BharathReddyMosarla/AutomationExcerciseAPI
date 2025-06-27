package testcases;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;


import io.restassured.path.json.JsonPath;
import routes.Routes;

public class TestCase03 extends BaseClass
{
	@Test
	void testGetAllBarands()
	{
		response = given()
		.when()
			.get(Routes.GET_ALLBRANDS)
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		JsonPath jsonpath = jsonpath(response);
		
		int responseCode = jsonpath.getInt("responseCode");
		int brandsCount = jsonpath.getList("brands").size();
		
		assertThat(responseCode,is(200));
		assertThat(brandsCount,greaterThan(0));
		
	}
}
