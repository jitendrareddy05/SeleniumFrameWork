package practise.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practise.AbstractComponents.AbstractComponent;

public class PLP extends AbstractComponent {

	WebDriver driver;

	public PLP(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> allProducts;
	
	@FindBy(css=".ng-animating")
	WebElement loadingIcon;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-child");
	By toaster=By.id("toast-container");

	public List<WebElement> getAllProductList() {
		waitUntilElementIsVisible(productsBy);
		return allProducts;
	}

	public WebElement getProductByName(String testProductName) {
		WebElement desiredProduct = allProducts.stream().filter(
				eachProduct -> eachProduct.findElement(By.tagName("b")).getText().equalsIgnoreCase(testProductName))
				.findFirst().orElse(null);
		return desiredProduct;
	}
	
	public CartPage addProductToCart(String testProductName) {
		WebElement desiredProduct=getProductByName(testProductName);
		desiredProduct.findElement(addToCart).click();
		waitUntilElementIsVisible(toaster);
		waitUntilELementIsInvisible(loadingIcon);
		CartPage cartPage = new CartPage(driver);
		
		return cartPage;
	}
}
