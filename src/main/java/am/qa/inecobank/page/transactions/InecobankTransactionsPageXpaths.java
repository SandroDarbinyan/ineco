package am.qa.inecobank.page.transactions;

public class InecobankTransactionsPageXpaths {
	public static final String TRANSACTIONS_LIST_TXT = "//h5[text()='Transactions List']";
	public static final String INECO_FRIEND_ICON = "//span[text()='Ineco Friend']//../div[1]";
	public static final String MONEY_TRANSFER_ICON = "//span[text()='Money Transfer']//../div[1]";
	public static final String CURRENCY_EXCHANGE_ICON = "//span[text()='Currency Exchange']//../div[1]";
	public static final String LOAN_REPAYMENT_ICON = "//span[text()='Loan Repayment']//../div[1]";
	public static final String DEPOSIT_REPLENISHMENT_ICON = "/span[text()='Deposit Replenishment']//../div[1]";
	public static final String UTILITY_PAYMENT_ICON = "//span[text()='Utility Payment']//../div[1]";
	public static final String MONEY_TRANSFER_URI = "/transactions/money-transfer/fast-transfer";
	public static final String TRANSACTION_VALUE = "//app-table-body/div[1]/app-table-row[2]/app-table-row-cell[3]";
	public static final String TRANSACTION_BENEFICIARY = "//app-table-body/div[1]/app-table-row[2]/app-table-row-cell[2]";
}
