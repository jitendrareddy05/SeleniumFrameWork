package practise.TestCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import practise.TestComponents.BaseTest;

public class ErrorMessageValidation extends BaseTest{

	@Test
	public void validateSignInErrorMessage() {
		landingPage.loginToApplication("jitendrareddy05@gmail.com", "123456");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorText());
	}
}
