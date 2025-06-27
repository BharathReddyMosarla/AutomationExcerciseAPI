package payloads;

// import java.util.Random;

import com.github.javafaker.Faker;

import pojo.Login;
import pojo.User;

public class Payloads 
{
	private static final Faker faker =new Faker();
//	private static final Random random=new Random();

	public User userpayload()
	{
		
		String name=faker.name().fullName();
		String email = faker.internet().emailAddress();
		String password =faker.internet().password();
        String title = faker.name().prefix(); // e.g., Mr., Mrs.
        int birth_date = faker.number().numberBetween(1, 28); // day of birth
        int birth_month =faker.number().numberBetween(1, 12);
        int birth_year = faker.number().numberBetween(1970, 2005);
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String company = faker.company().name();
        String address1 = faker.address().streetAddress();
        String address2 = faker.address().secondaryAddress();
        String country = faker.country().name();
        int zipcode = Integer.parseInt(faker.address().zipCode());
        String state = faker.address().state();
        String city = faker.address().city();
        String mobile_number = faker.phoneNumber().cellPhone();
		
		return new User(name, email, password, title , birth_date, birth_month, birth_year, firstname, lastname, company, address1, address2, country, zipcode, state, city, mobile_number);
	}
	
	//Login
		public static Login loginPayload()
		{
			String username=faker.name().username();
			String password=faker.internet().password();
			
			Login login=new Login(username,password);
			return login;
			
		}
}
