package am.qa.inecobank.page.transactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import am.qa.inecobank.page.base.InecobankBasePage;
import am.qa.inecobank.page.moneytransfer.InecobankMoneyTransferTypePage;
import am.qa.inecobank.page.utilitypayment.InecobankUtilityPaymentPage;


public class InecobankTransactionsPage extends InecobankBasePage{

	public InecobankTransactionsPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = InecobankTransactionsPageXpaths.TRANSACTIONS_LIST_TXT)
	public static WebElement transactionsListTxt;
	
	@FindBy (xpath = InecobankTransactionsPageXpaths.INECO_FRIEND_ICON)
	public WebElement inecoFriendIcon;
	
	@FindBy (xpath = InecobankTransactionsPageXpaths.MONEY_TRANSFER_ICON)
	public WebElement moneyTransferIcon;
	
	@FindBy (xpath = InecobankTransactionsPageXpaths.CURRENCY_EXCHANGE_ICON)
	public WebElement currencyExchangeIcon;
	
	@FindBy (xpath = InecobankTransactionsPageXpaths.LOAN_REPAYMENT_ICON)
	public WebElement loanRepaymentIcon;
	
	@FindBy (xpath = InecobankTransactionsPageXpaths.DEPOSIT_REPLENISHMENT_ICON)
	public WebElement depositReplenishmentIcon;
	
	@FindBy (xpath = InecobankTransactionsPageXpaths.UTILITY_PAYMENT_ICON)
	public WebElement utilityPaymentIcon;
	
	@FindBy (xpath = InecobankTransactionsPageXpaths.TRANSACTION_VALUE)
	public WebElement transactionValue;
	
	@FindBy (xpath = InecobankTransactionsPageXpaths.TRANSACTION_BENEFICIARY)
	public WebElement beneficiary;
	

	public InecobankMoneyTransferTypePage navigateToMoneyTransfer() {
		moneyTransferIcon.click();
		return new InecobankMoneyTransferTypePage(driver);	
	}
	

	public InecobankUtilityPaymentPage navigateToUtilityPayment() {
		utilityPaymentIcon.click();
		return new InecobankUtilityPaymentPage(driver);
	}
	
}

 
