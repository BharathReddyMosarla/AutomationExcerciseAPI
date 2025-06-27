package testcases;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.given;
import routes.Routes;

public class TestCase12 extends BaseClass
{
/*	@Test(dependsOnMethods="testcases.TestCase11.testCreateUser")
	void testDeleteUser()
	{ 
  		response = given()
				.formParam("email", TestCase11.email)
	            .formParam("password", TestCase11.password)
			.when()
				.delete(Routes.DELETE_DELETEUSER)
			.then()
				.statusCode(200)
				.log().body()
				.extract().response();
		JsonPath jsonpath = jsonpath(response);
		
		int responseCode = jsonpath.getInt("responseCode");
		String message = jsonpath.getString("message");
		
		assertThat(responseCode,is(200));
		assertThat(message,is("Account deleted!"));
	}
  	 */
		Faker faker = new Faker();
	    String name = faker.name().fullName();
	    String email = "asdfedfg@gmail.com";//faker.internet().emailAddress();
	    String password = "asdGH098fedfg";//faker.internet().password();
	    String title = faker.name().title();
	    String birth_date = "01";
	    String birth_month = "01";
	    String birth_year = "1990";
	    String firstname = faker.name().firstName();
	    String lastname = faker.name().lastName();
	    String company = faker.company().name();
	    String address1 = faker.address().streetAddress();
	    String address2 = faker.address().secondaryAddress();
	    String country = faker.address().country();
	    String zipcode = faker.address().zipCode();
	    String state = faker.address().state();
	    String city = faker.address().city();
	    String mobile_number = faker.phoneNumber().cellPhone();
	        
	
@Test
void testDeleteUser()
{
	given()
		.header("Content-Type", "application/x-www-form-urlencoded")
        	.formParam("name", name)
        	.formParam("email", email)
        	.formParam("password", password)
        	.formParam("title", title)
        	.formParam("birth_date", birth_date)
        	.formParam("birth_month", birth_month)
        	.formParam("birth_year", birth_year)
        	.formParam("firstname", firstname)
        	.formParam("lastname", lastname)
        	.formParam("company", company)
        	.formParam("address1", address1)
        	.formParam("address2", address2)
        	.formParam("country", country)
        	.formParam("zipcode", zipcode)
        	.formParam("state", state)
        	.formParam("city", city)
        	.formParam("mobile_number", mobile_number)
	.when()
		.post(Routes.POST_CREATEUSER)
	.then()
		.statusCode(200)
		.log().body();
		
response = given()
		.formParam("email", email)
	        .formParam("password", password)
	.when()
		.delete(Routes.DELETE_DELETEUSER)
	.then()
		.statusCode(200)
		.log().body()
		.extract().response();

	JsonPath jsonpath = jsonpath(response);
		
		int responseCode = jsonpath.getInt("responseCode");
		String message = jsonpath.getString("message");
		
		assertThat(responseCode,is(200));
		assertThat(message,is("Account deleted!"));
		
	}
}
