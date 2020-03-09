package am.qa.inecobank.page.moneytransfer;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import am.qa.inecobank.page.fasttransfer.InecobankFastTransferPage;
import am.qa.inecobank.page.transactions.InecobankTransactionsPage;

import static am.qa.inecobank.page.moneytransfer.InecobankMoneyTransferTypePageXpaths.*;
import static am.qa.inecobank.page.transactions.InecobankTransactionsPageXpaths.*;

public class InecobankMoneyTransferTypePage  extends InecobankTransactionsPage {

	public InecobankMoneyTransferTypePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy (xpath=InecobankMoneyTransferTypePageXpaths.TRANSFER_TYPE_FIELD_XPATH)
	public WebElement transferTypeField;
	
	@FindBy (xpath=InecobankMoneyTransferTypePageXpaths.TRANSFER_BETWEEN_MY_ACCOUNTS_XPATH)
	public WebElement transferBetwwenMyAccounts;
	
	@FindBy (xpath= InecobankMoneyTransferTypePageXpaths.TRANSFER_IN_AMD_XPATH)
	public WebElement transferInAmd;
	
	@FindBy (xpath= InecobankMoneyTransferTypePageXpaths.TRANSFER_IN_OTHER_CURRENCY_XPATH)
	public WebElement transferInOtherCurrency;
	
	@FindBy (xpath= InecobankMoneyTransferTypePageXpaths.TRANSFER_TO_CARD_XPATH)
	public WebElement transferToCard;
	
	@FindBy (xpath= InecobankMoneyTransferTypePageXpaths.RECEIVE_FAST_TRANSFER_XPATH)
	public WebElement receiveFastTransfer;
	
	@FindBy (xpath= InecobankMoneyTransferTypePageXpaths.SCROLL_XPATH)
	public WebElement scroll;

	public InecobankMoneyTransferTypePage clickOnTransferTypeField() {
		transferTypeField.click();
		return new InecobankMoneyTransferTypePage(driver);
	}
	
	public InecobankFastTransferPage clickOnReceiveFastTransfer() {
		driver.navigate().to(BASE_URL+MONEY_TRANSFER_URI);
		return new InecobankFastTransferPage(driver);
	}

	
	
}
