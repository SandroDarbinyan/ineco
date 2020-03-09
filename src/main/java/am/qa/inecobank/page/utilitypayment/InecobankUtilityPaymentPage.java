package am.qa.inecobank.page.utilitypayment;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.inecobank.page.base.InecobankBasePage;
import am.qa.inecobank.page.fasttransfer.InecobankFastTransferPage;
import am.qa.inecobank.page.fasttransfer.InecobankFastTransferPageXpaths;
import am.qa.inecobank.page.transactions.InecobankTransactionsPage;
import am.qa.inecobank.page.transactions.InecobankTransactionsPageXpaths;

public class InecobankUtilityPaymentPage extends InecobankBasePage {

	public InecobankUtilityPaymentPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = InecobankUtilityPaymentPageXpaths.UTILITY_PAYMENT_TYPE_FIELD)
	public WebElement typeField;

	@FindBy(xpath = InecobankUtilityPaymentPageXpaths.TYPE_ELECTRICITY_FIELD)
	public WebElement electricityField;
	
	@FindBy(xpath = InecobankUtilityPaymentPageXpaths.TYPE_GAS_FIELD)
	public WebElement gasField;
	
	@FindBy(xpath = InecobankUtilityPaymentPageXpaths.SERVICE_FIELD)
	public WebElement serviceField;
	
	@FindBy(xpath = InecobankUtilityPaymentPageXpaths.YEREVAN_GAS)
	public WebElement yerevanGas;
	

	@FindBy(xpath = InecobankUtilityPaymentPageXpaths.CUSTOMER_CODE_FIELD)
	public WebElement customerCodeField;

	@FindBy (xpath = InecobankUtilityPaymentPageXpaths.CONFIRM_BTN)
	public WebElement confirmBtn;
	
	@FindBy (xpath = InecobankUtilityPaymentPageXpaths.AMOUNT_FIELD)
	public WebElement amountField;
	
	@FindBy (xpath = InecobankUtilityPaymentPageXpaths.ERROR_MESSAGE)
	public WebElement errorMessage;

	public InecobankUtilityPaymentPage fillinTypeField(WebElement element) throws InterruptedException {
		Thread.sleep(11000);
		typeField.click();
		element.click();
		return new InecobankUtilityPaymentPage(driver);
	}
	
	public InecobankUtilityPaymentPage fillinServiceField(WebElement element) throws InterruptedException {
		Thread.sleep(4000);
		serviceField.click();
		element.click();
		return new InecobankUtilityPaymentPage(driver);
	}

	public InecobankUtilityPaymentPage fillinCustomerCodeField(String code) {
		customerCodeField.sendKeys(code);
		return new InecobankUtilityPaymentPage(driver);
	}

	public InecobankUtilityPaymentPage fillinAmountField(String amount) throws InterruptedException {
		Thread.sleep(4000);
		amountField.sendKeys(Keys.CONTROL + "a");
		amountField.sendKeys(Keys.DELETE);
		amountField.sendKeys(amount);
		return new InecobankUtilityPaymentPage(driver);
	}
	
	public InecobankBasePage clickOnConfirmBtn() {
		confirmBtn.click();
		if(isElementPresent(InecobankTransactionsPageXpaths.TRANSACTIONS_LIST_TXT))
			{return new InecobankTransactionsPage(driver);}
		else {return new InecobankUtilityPaymentPage(driver);}
	}
	
	

}
