package practise.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import practise.PageObjects.CartPage;
import practise.PageObjects.CheckoutPage;
import practise.PageObjects.LandingPage;
import practise.PageObjects.OrderConfirmationPage;
import practise.PageObjects.PLP;
import practise.TestComponents.BaseTest;

public class StepDefinitionImp extends BaseTest {

	public LandingPage landingPage;
	public PLP plp;
	public CartPage cartPage;
	public OrderConfirmationPage confirmPage;

	@Given("I landed on Home Page")
	public void I_landed_on_Home_Page() throws IOException {
		landingPage = navigateToApplication();
	}

	@Given("^I Logged in with username (.+) and password (.+)$")
	public void I_Logged_In_With_Username_And_Password(String userName, String password) {
		plp = landingPage.loginToApplication(userName, password);
	}

	@When("^I add the product (.+) to cart$")
	public void I_add_the_product_to_cart(String productName) {
		plp.getAllProductList();
		cartPage = plp.addProductToCart(productName);
	}

	@And("^Chekcout product (.+) and submit the order$")
	public void Chekcout_product_and_submit_the_order(String productName) {
		cartPage.navigateToCart();
		Boolean match = cartPage.identifyProductInCart(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.proceedToCheckOut();

		checkoutPage.chooseCountry("India");
		confirmPage = checkoutPage.placeOrder();
	}

	@Then("{string} message is displayed on Confirmation Page")
	public void Success_message_is_displayed_on_Confirmation_Page(String expectedThankYouMessage) {
		String actualThankYouMessage = confirmPage.getTextOfOrderConfirmation();
		Assert.assertTrue(actualThankYouMessage.equalsIgnoreCase(expectedThankYouMessage));

		driver.quit();
	}

	@Then("I validate the Error Message {string}")
	public void I_validate_the_Error_Message(String expectedErrorText) {
		Assert.assertEquals(expectedErrorText, landingPage.getErrorText());

		driver.quit();
	}
}
