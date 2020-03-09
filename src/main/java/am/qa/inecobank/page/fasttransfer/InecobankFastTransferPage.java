package am.qa.inecobank.page.fasttransfer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.inecobank.page.base.InecobankBasePage;
import am.qa.inecobank.page.transactions.InecobankTransactionsPage;
import am.qa.inecobank.page.transactions.InecobankTransactionsPageXpaths;

public class InecobankFastTransferPage extends InecobankBasePage{

	public InecobankFastTransferPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.UNISTREAM_XPATH)
	 public WebElement unistream;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.MONEYGRAM_XPATH)
	 public WebElement moneygram;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.CONVERSE_TRANSFER_XPATH)
	 public WebElement converseTransfer;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.INTEL_EXPRESS_XPATH)
	 public WebElement intelExpress;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.TRANSFER_CODE_FIELD_XPATH)
	public WebElement transferCodeField;

	@FindBy (xpath = InecobankFastTransferPageXpaths.AMOUNT_FIELD_XPATH)
	public WebElement amountField;
	
	//@FindBy (xpath = InecobankFastTransferPageXpaths.CURRENCY_FIELD_XPATH)
	//public WebElement currencyField;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.COUNTRY_FIELD_XPATH)
	public WebElement countryField;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.COUNTRY_ARMENIA_XPATH)
	public WebElement countryArmenia;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.TRANSFER_SYSTEM_FIELD_XPATH)
	public WebElement transferSystemField;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.SENDER_FIELD_XPATH)
	public WebElement senderField;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.TO_FIELD_XPATH)
	public WebElement toField;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.ACCOUNT_XPATH)
	public WebElement account;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.CONFIRM_BTN)
	public WebElement confirmBtn;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.TOKEN_FIELD_XPATH)
	public WebElement tokenField;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.TRANSFER_CODE_ERROR_MESSAGE)
	public WebElement errMessageTransferCode;
	
	@FindBy (xpath = InecobankFastTransferPageXpaths.AMOUNT_FIELD_ERROR_MESSAGE)
	public WebElement errorMessageAmountField;
	
	
	
	
	public InecobankFastTransferPage clickOnUnistream() throws InterruptedException {
		Thread.sleep(11000);
		transferSystemField.click();
		unistream.click();
		return new InecobankFastTransferPage(driver);
	}
	
	
	public InecobankFastTransferPage clickOnMoneygram() throws InterruptedException {
		Thread.sleep(11000);
		transferSystemField.click();
		moneygram.click();
		return new InecobankFastTransferPage(driver);
	}
	
	public InecobankFastTransferPage clickOnConverseTransfer() throws InterruptedException {
		Thread.sleep(11000);
		transferSystemField.click();
		converseTransfer.click();
		return new InecobankFastTransferPage(driver);
	}
	
	public InecobankFastTransferPage clickOnIntelExpress() throws InterruptedException {
		Thread.sleep(11000);
		transferSystemField.click();
		intelExpress.click();
		return new InecobankFastTransferPage(driver);
	}
	
	public InecobankFastTransferPage fillinTransferCodeField(String transferCode) {
		transferCodeField.sendKeys(transferCode);;
		return new InecobankFastTransferPage(driver);
	}
	
	
	
	public InecobankFastTransferPage fillinAmountField(String amount) {
		amountField.sendKeys(amount);
		return new InecobankFastTransferPage(driver);
	}
	
//	public InecobankFastTransferPage clickOnCurrencyField() {
//		currencyField.click();
//		return new InecobankFastTransferPage(driver);
//	}
	
	public InecobankFastTransferPage fillinCountryField(String country) throws InterruptedException {
        countryField.sendKeys(country);
		return new InecobankFastTransferPage(driver);
	}
		
	public InecobankFastTransferPage fillinSenderField(String sender) {
		senderField.sendKeys(sender);
		return new  InecobankFastTransferPage(driver);
	}
	
	public InecobankFastTransferPage fillinToField() throws InterruptedException {
		toField.click();
		account.click();
		return new InecobankFastTransferPage(driver);
	}
	
	public InecobankFastTransferPage fillinToken(){
		tokenField.sendKeys("token");
		return new InecobankFastTransferPage(driver);
	}
	
	public InecobankBasePage clickOnConfirmBtn() {
		confirmBtn.click();
		if(isElementPresent(InecobankTransactionsPageXpaths.TRANSACTIONS_LIST_TXT))
			{return new InecobankTransactionsPage(driver);}
		else {return new InecobankFastTransferPage(driver);}
	}
	
}
