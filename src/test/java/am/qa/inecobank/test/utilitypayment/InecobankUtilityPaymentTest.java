package am.qa.inecobank.test.utilitypayment;

import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.inecobank.page.transactions.InecobankTransactionsPage;
import am.qa.inecobank.page.transactions.InecobankTransactionsPageXpaths;
import am.qa.inecobank.page.utilitypayment.InecobankUtilityPaymentPage;
import am.qa.inecobank.test.base.InecobankBaseTest;

public class InecobankUtilityPaymentTest extends InecobankBaseTest {

	@Test
	public void testElectricityPaymentPositive() throws InterruptedException {
		// Test Case ID: 1
		// Test Case Description: Given that the user is on the Utility Payment page,
		// when user chooses "Electricity" in "Category" field, fills in next fields
		// with correct values,clicks on "Confirm" button,
		// then transaction should be confirmed

		// Step 1.1: Navigate to "Utility Payment" page
		InecobankTransactionsPage page = new InecobankTransactionsPage(driver);
		page.waitForElementPresent(page.utilityPaymentIcon);
		page.navigateToUtilityPayment();

		// Step 1.2: Choose "Electricity" in "Category" field
		InecobankUtilityPaymentPage type = new InecobankUtilityPaymentPage(driver);
		type.fillinTypeField(type.electricityField);

		// Step 1.3: Type "010222223" in "Transfer code" field
		type.fillinCustomerCodeField("010222223");

		// Step 1.4: Type "1" in "Amount" field
		type.fillinAmountField("1");

		// Step 1.5: Click on "Confirm" button
		type.clickOnConfirmBtn();
		InecobankTransactionsPage main = new InecobankTransactionsPage(driver);
		main.waitForElementPresent(main.transactionsListTxt);
		Assert.assertTrue(main.isElementPresent(InecobankTransactionsPageXpaths.TRANSACTIONS_LIST_TXT));
		main.waitForElementPresent(main.transactionValue);
		Assert.assertEquals(main.beneficiary.getText(), "Payment for Electricity");
		Assert.assertEquals(main.transactionValue.getText(), "1.00 AMD");
		
		//Additional step:
	    driver.navigate().to("http://192.168.88.71:4000/transactions");

	}

	@Test
	public void testElectricityPaymentNegative() throws InterruptedException {
		// Test Case ID: 2
		// Test Case Description: Given that the user is on the Utility Payment
		// page,when user chooses "Electricity" in "Category" field,
		// fills in "Amount" field besides "Customer code" input field,and clicks on
		// "Confirm" button,
		// then transaction should not be done and error message "The field is required"
		// is displayed for "Customer code" input field

		// Step 2.1: Navigate to "Utility Payment" page
		InecobankTransactionsPage page = new InecobankTransactionsPage(driver);
		page.waitForElementPresent(page.utilityPaymentIcon);
		page.navigateToUtilityPayment();

		// Step 2.2: Choose "Electricity" in "Category" field
		InecobankUtilityPaymentPage type = new InecobankUtilityPaymentPage(driver);
		type.fillinTypeField(type.electricityField);

		// Step 2.3: Type "1" in "Amount" field
		type.fillinAmountField("1");

		// Step 2.4: Click on "Confirm"
		type.clickOnConfirmBtn();
		Assert.assertTrue(type.errorMessage.isDisplayed());
		
		
		//Additional step:
		driver.navigate().to("http://192.168.88.71:4000/transactions");
		
	}

	@Test
	public void testGasPaymentPositive() throws InterruptedException {
		// Test Case ID: 3
		// Test Case Description: Given that the user is on the Utility Payment page,
		// when user chooses "Gas" in "Category" field,fills in "Service" filed,fills in
		// "Customer" filed,fills in "Amount" field,
		// and clicks on"Confirm" button,then transaction should be done

		// Step 3.1: Navigate to "Utility Payment" page
		InecobankTransactionsPage page = new InecobankTransactionsPage(driver);
		InecobankUtilityPaymentPage type = page.navigateToUtilityPayment();

		// Step 3.2: Choose "Gas" in "Category" field
		type.fillinTypeField(type.gasField);

		// Step 3.3: Select "Yerevan Gas" in "Service" field
		type.fillinServiceField(type.yerevanGas);

		// Step 3.4: Type "010222223" in "Transfer code" field
		type.fillinCustomerCodeField("010222223");

		// Step 3.5: Type "1" in "Amount" field
		type.fillinAmountField("1");

		// Step 3.6: Click on "Confirm"
		type.clickOnConfirmBtn();
		InecobankTransactionsPage main = new InecobankTransactionsPage(driver);
		main.waitForElementPresent(main.transactionsListTxt);
		Assert.assertTrue(main.isElementPresent(InecobankTransactionsPageXpaths.TRANSACTIONS_LIST_TXT));
		main.waitForElementPresent(main.transactionValue);
		Assert.assertEquals(main.beneficiary.getText(), "Yerevan Gas");
		Assert.assertEquals(main.transactionValue.getText(), "1.00 AMD");
		
		
		//Additional step:
		driver.navigate().to("http://192.168.88.71:4000/transactions");
		
	}

	@Test
	public void testGasPaymentNegative() throws InterruptedException {
		// Test Case ID: 4
		// Test Case Description: Given that the user is on the Utility Payment page,
		// when user chooses "Gas" in "Category" field,does not fill in "Service" filed,fills in
		// "Customer" filed,fills in "Amount" field,
		// and clicks on"Confirm" button,then transaction should not be done and error message "The field is required"
		// is displayed for "Service" input field

		// Step 4.1: Navigate to "Utility Payment" page
		InecobankTransactionsPage page = new InecobankTransactionsPage(driver);
		InecobankUtilityPaymentPage type = page.navigateToUtilityPayment();

		// Step 4.2: Choose "Gas" in "Category" field
		type.fillinTypeField(type.gasField);

		// Step 4.3: Type "010222223" in "Transfer code" field
		type.fillinCustomerCodeField("010222223");

		// Step 4.4: Type "1" in "Amount" field
		type.fillinAmountField("1");

		// Step 4.5: Click on "Confirm"
		type.clickOnConfirmBtn();
		Assert.assertTrue(type.errorMessage.isDisplayed());
		
		
		//Additional step:
		driver.navigate().to("http://192.168.88.71:4000/transactions");
		
	}

}
