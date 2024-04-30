package practise.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practise.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By suggestedCountries = By.cssSelector(".list-group button");

	@FindBy(css = "[placeholder='Select Country']")
	WebElement selectCountry;

	@FindBy(css = ".list-group button:last-child")
	WebElement desiredCountry;

	@FindBy(css = "[class*='submit']")
	WebElement placeOrder;

	public void chooseCountry(String country) {
		selectCountry.sendKeys(country);
		waitUntilElementIsVisible(suggestedCountries);
		desiredCountry.click();
	}

	public OrderConfirmationPage placeOrder() {
		javascriptClick(placeOrder);
		OrderConfirmationPage confirmPage = new OrderConfirmationPage(driver);

		return confirmPage;

	}

}
