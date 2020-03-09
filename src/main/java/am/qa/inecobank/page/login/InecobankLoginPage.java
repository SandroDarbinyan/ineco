package am.qa.inecobank.page.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.inecobank.page.base.InecobankBasePage;
import am.qa.inecobank.page.transactions.InecobankTransactionsPage;
import am.qa.inecobank.page.transactions.InecobankTransactionsPageXpaths;

public class InecobankLoginPage extends InecobankBasePage {

	public InecobankLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = InecobankLoginPageXpaths.USER_NAME)
	WebElement usernameField;

	@FindBy(xpath = InecobankLoginPageXpaths.PASSWORD)
	WebElement passwordField;

	@FindBy(xpath = InecobankLoginPageXpaths.SIGN_BUTTON)
	WebElement signButton;

	public void fillFields(){
	
		usernameField.sendKeys("user_713");
		passwordField.sendKeys("password");
		
	
		

	}
	
	public InecobankBasePage login() {
		signButton.click();
		if(isElementPresent(InecobankTransactionsPageXpaths.TRANSACTIONS_LIST_TXT)) {
			return new InecobankTransactionsPage(driver);
		} else {
		return new InecobankLoginPage(driver); }
		
	}

}
