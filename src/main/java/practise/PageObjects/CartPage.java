package practise.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practise.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;

	@FindBy(css = ".totalRow button")
	WebElement checkout;

	@FindBy(css = ".cartSection h3")
	List<WebElement> productTitles;

	public void navigateToCart() {
		cart.click();
	}

	public boolean identifyProductInCart(String testProductName) {
		Boolean match = productTitles.stream()
				.anyMatch(productText -> productText.getText().equalsIgnoreCase(testProductName));
		return match;

	}

	public CheckoutPage proceedToCheckOut() {
		checkout.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);

		return checkoutPage;
	}

}
