package testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.path.json.JsonPath;
import routes.Routes;

public class TestCase10 extends BaseClass
{
	@Test
	void testPostLoginInValidDetails()
	{
		Faker faker =new Faker();
		String username = faker.internet().emailAddress();
		String password = faker.internet().password();
		
		response = given()
				
			.formParam("email", username)
		    .formParam("password", password)
		.when()
			.post(Routes.POST_VERIFYLOGININVALID)
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		JsonPath jsonpath = jsonpath(response);
		
		int responseCode = jsonpath.getInt("responseCode");
		String message = jsonpath.getString("message");
		
		assertThat(responseCode,is(404));
		assertThat(message,is("User not found!"));

	}

}
