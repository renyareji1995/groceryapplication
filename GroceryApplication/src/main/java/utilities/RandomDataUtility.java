package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	Faker fakerobj=new Faker();
	
	
	public String randomUsername() {
		
		return fakerobj.name().username();
	}
	
	public String randomPassword() {
		
		return fakerobj.internet().password();
				
	}
	
	public String randomFullname() {
		
		return fakerobj.name().fullName();
	}
	
	public String randomEmail() {
		
		return fakerobj.internet().emailAddress();
	}
	
	public String randomMobileNumber() {
		
		return fakerobj.phoneNumber().cellPhone();
	}

}
