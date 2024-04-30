package practise.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practise.AbstractComponents.AbstractComponent;

public class OrderConfirmationPage extends AbstractComponent {

	WebDriver driver;

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By suggestedCountries = By.cssSelector(".list-group button");

	@FindBy(css = ".hero-primary")
	WebElement confirmMessage;

	public String getTextOfOrderConfirmation() {
		String confirmMessageText = confirmMessage.getText();
		return confirmMessageText;
	}

}
