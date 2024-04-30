package practise.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practise.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement login;
	
	@FindBy(css="[role='alert']")
	WebElement errorMessage;

	public void navigate() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public PLP loginToApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		PLP plp = new PLP(driver);
		return plp;
	}
	
	public String getErrorText() {
		waitUntilWebElementIsVisible(errorMessage);
		return errorMessage.getText();
	}
}
