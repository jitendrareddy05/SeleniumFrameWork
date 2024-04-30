package practise.TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import practise.PageObjects.CartPage;
import practise.PageObjects.CheckoutPage;
import practise.PageObjects.OrderConfirmationPage;
import practise.PageObjects.PLP;
import practise.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String, String> data) throws IOException {

		PLP plp = landingPage.loginToApplication(data.get("email"), data.get("password"));

		plp.getAllProductList();
		CartPage cartPage = plp.addProductToCart(data.get("testProductName"));

		cartPage.navigateToCart();
		Boolean match = cartPage.identifyProductInCart(data.get("testProductName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.proceedToCheckOut();

		checkoutPage.chooseCountry("India");
		OrderConfirmationPage confirmPage = checkoutPage.placeOrder();

		String thankYouMessage = confirmPage.getTextOfOrderConfirmation();
		Assert.assertTrue(thankYouMessage.equalsIgnoreCase("Thankyou for the order."));
	}

	@DataProvider()
	public Object[][] getData() throws IOException {
		// Using Jsonfile
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "/src/test/java/practise/TestData/PurchaseOrder.json");
		return new Object[][] { { data.get(0) } };
	}

//	@DataProvider()
	// Using Object
//	public Object[][] getData() {
//		return new Object [][] {{"jitendrareddy05@gmail.com", "Test@123","zara coat 3"}};
//	}

	// Using HasMap
//	HashMap<String, String> map=new HashMap<String, String>();
//	map.put("email", "jitendrareddy05@gmail.com");
//	map.put("password", "Test@123");
//	map.put("testProductName", "zara coat 3");

}
