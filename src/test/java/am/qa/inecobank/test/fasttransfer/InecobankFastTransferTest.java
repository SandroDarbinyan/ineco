package am.qa.inecobank.test.fasttransfer;

import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.inecobank.page.fasttransfer.InecobankFastTransferPage;
import am.qa.inecobank.page.moneytransfer.InecobankMoneyTransferTypePage;
import am.qa.inecobank.page.transactions.InecobankTransactionsPage;
import am.qa.inecobank.page.transactions.InecobankTransactionsPageXpaths;
import am.qa.inecobank.test.base.InecobankBaseTest;

public class InecobankFastTransferTest extends InecobankBaseTest {

	@Test
	public void testUnistreamTransfer1() throws InterruptedException  {
		// Test Case ID: 1
		// Test Case Description: Given that the user is on the Receive fast transfer
		// page,when user chooses "Unistream" transfer type,
		// fills in next fields with correct values,clicks on "Confirm" button,types
		// token,clikcks on "Confirm" again,
		// then transaction should be confirmed

		// Step 1.1: Navigate to "Money transfer"
		InecobankTransactionsPage page = new InecobankTransactionsPage(driver);
		page.waitForElementPresent(page.moneyTransferIcon);
		page.navigateToMoneyTransfer();

		// Step 1.2: Click on "Receive fast transfer" from drop-down menu
		InecobankMoneyTransferTypePage type = new InecobankMoneyTransferTypePage(driver);
		type.waitForElementPresent(type.transferTypeField);
		type.clickOnTransferTypeField();
		InecobankFastTransferPage fastTransferPage = type.clickOnReceiveFastTransfer();

		// Step 1.3: Click on "Unistream" in "Transfer type" input
		
		fastTransferPage.waitForElementPresent(fastTransferPage.transferSystemField);
		fastTransferPage.clickOnUnistream();

		// Step 1.4: Type "111111111111" in "Transfer code" field
		fastTransferPage.fillinTransferCodeField("111111111111");

		// Step 1.5: Type "1" in "Amount" input field
		fastTransferPage.fillinAmountField("1");

		// Step 1.6: Fill "Armenia" in "Country"
		fastTransferPage.fillinCountryField("Armenia");

		// Step 1.7: Fill in "Sender" field
		fastTransferPage.fillinSenderField("anunazganun");

		// Step 1.8: Fill in "To" field
		fastTransferPage.fillinToField();

		// Step 1.9: Click on "Confirm"
		fastTransferPage.confirmBtn.click();

		// Step 1.10: Fill in "Token" field
		fastTransferPage.waitForElementPresent(fastTransferPage.tokenField);
		fastTransferPage.fillinToken();

		// Step 1.10: Click on "Confirm"
		fastTransferPage.clickOnConfirmBtn();
		InecobankTransactionsPage main = new InecobankTransactionsPage(driver);
		main.waitForElementPresent(main.transactionsListTxt);
		Assert.assertTrue(main.isElementPresent(InecobankTransactionsPageXpaths.TRANSACTIONS_LIST_TXT));
		main.waitForElementPresent(main.transactionValue);
		Assert.assertEquals(main.transactionValue.getText(), "1.00 USD");
		
		//Additional step:
	    driver.navigate().to("http://192.168.88.71:4000/transactions");
	}
	
	@Test
	public void testUnistreamTransfer2() throws InterruptedException {
		// Test Case ID: 2
		// Test Case Description: Given that the user is on the Receive fast transfer page,when user chooses "Unistream" transfer type,
		                        //fills in all fields correct values besides "Transfer code" input field, 
		                        //then transaction should not be done and error message "The field is required" is displayed for "Transfer code" input field

		// Step 2.1: Navigate to "Money transfer"
		InecobankTransactionsPage page = new InecobankTransactionsPage(driver);
		page.waitForElementPresent(page.moneyTransferIcon);
		page.navigateToMoneyTransfer();

		// Step 2.2: Click on "Receive fast transfer" from drop-down menu
		InecobankMoneyTransferTypePage type = new InecobankMoneyTransferTypePage(driver);
		type.waitForElementPresent(type.transferTypeField);
		type.clickOnTransferTypeField();
		InecobankFastTransferPage fastTransferPage = type.clickOnReceiveFastTransfer();

		// Step 2.3: Click on "Unistream" in "Transfer type" input
		fastTransferPage.waitForElementPresent(fastTransferPage.transferSystemField);
		fastTransferPage.clickOnUnistream();
		     

		// Step 2.4: Type "1" in "Amount" input field
		fastTransferPage.fillinAmountField("1");

		// Step 2.5: Fill "Armenia" in "Country"
		fastTransferPage.fillinCountryField("Armenia");

		// Step 2.6: Fill in "Sender" field
		fastTransferPage.fillinSenderField("anunazganun");

		// Step 2.7: Fill in "To" field
		fastTransferPage.fillinToField();

		// Step 2.8: Click on "Confirm" button
		fastTransferPage.confirmBtn.click();
		fastTransferPage.waitForElementPresent(fastTransferPage.errMessageTransferCode);
		Assert.assertTrue(fastTransferPage.errMessageTransferCode.isDisplayed());
		
		//Additional step:
	    driver.navigate().to("http://192.168.88.71:4000/transactions");
	}
	
	@Test
	public void testUnistreamTransfer3() throws InterruptedException  {
		// Test Case ID: 3
		// Test Case Description: Given that the user is on the Receive fast transfer page,
		                        //when user chooses "Unistream" transfer type, fills in all fields correct values besides "Sender" input field, 
		                        //then transaction should  be done 

		// Step 3.1: Navigate to "Money transfer"
		InecobankTransactionsPage page = new InecobankTransactionsPage(driver);
		page.waitForElementPresent(page.moneyTransferIcon);
		page.navigateToMoneyTransfer();

		// Step 3.2: Click on "Receive fast transfer" from drop-down menu
		InecobankMoneyTransferTypePage type = new InecobankMoneyTransferTypePage(driver);
		type.waitForElementPresent(type.transferTypeField);
		type.clickOnTransferTypeField();
		InecobankFastTransferPage fastTransferPage = type.clickOnReceiveFastTransfer();

		// Step 3.3: Click on "Unistream" in "Transfer type" input
		fastTransferPage.waitForElementPresent(fastTransferPage.transferSystemField);
		fastTransferPage.clickOnUnistream();

		// Step 3.4: Type "111111111111" in "Transfer code" field
		fastTransferPage.fillinTransferCodeField("111111111111");

		// Step 3.5: Type "1" in "Amount" input field
		fastTransferPage.fillinAmountField("1");

		// Step 3.6: Fill "Armenia" in "Country"
		fastTransferPage.fillinCountryField("Armenia");

		// Step 3.7: Do not fill in "Sender" field
		fastTransferPage.fillinSenderField("");
		
		// Step 3.8: Fill in "To" field
		
		fastTransferPage.fillinToField();

		// Step 3.9: Click on "Confirm"
		fastTransferPage.confirmBtn.click();

		// Step 3.10: Fill in "Token" field
		fastTransferPage.waitForElementPresent(fastTransferPage.tokenField);
		fastTransferPage.fillinToken();

		// Step 3.11: Click on "Confirm"
		fastTransferPage.clickOnConfirmBtn();
		InecobankTransactionsPage main = new InecobankTransactionsPage(driver);
		main.waitForElementPresent(main.transactionsListTxt);
		Assert.assertTrue(main.isElementPresent(InecobankTransactionsPageXpaths.TRANSACTIONS_LIST_TXT));
		main.waitForElementPresent(main.transactionValue);
		Assert.assertEquals(main.transactionValue.getText(), "1.00 USD");
		
		//Additional step:
	    driver.navigate().to("http://192.168.88.71:4000/transactions");
	}
	
	@Test
	public void testMoneyGramTransfer() throws InterruptedException {
		//Test case ID:4
		//4.1.Navigate to Money Transfer
		InecobankTransactionsPage page = new InecobankTransactionsPage(driver);
		page.navigateToMoneyTransfer();
		
		//4.2.Click on "Receive fast transfer" in the "Transaction type" field 
		InecobankMoneyTransferTypePage type = new InecobankMoneyTransferTypePage(driver);
		type.waitForElementPresent(type.transferTypeField);
		type.clickOnTransferTypeField();
		InecobankFastTransferPage fastTransferPage = type.clickOnReceiveFastTransfer();
		
		//4.3.Select the "MoneyGram" option in the "Transfer system" field
		fastTransferPage.waitForElementPresent(fastTransferPage.transferSystemField);
		fastTransferPage.clickOnMoneygram();
		
		//4.4.Enter 12345678 in the "Transfer code" field
		fastTransferPage.fillinTransferCodeField("12345678");

		//4.5.Enter any positive amount in the "Amount" field
		fastTransferPage.fillinAmountField("1");

		//4.6.Select "Armenia" in the "Country" field
		fastTransferPage.fillinCountryField("Armenia");

		//4.7.Enter any sender name in the "Sender" field
		fastTransferPage.fillinSenderField("Sender");

		//4.8.Select the first AMD current account in the "To" field
		fastTransferPage.fillinToField();

		//4.9.Click on the "Confirm" button
		fastTransferPage.confirmBtn.click();

		
		//4.10.Fill in the "Two Factor Token" field
		fastTransferPage.waitForElementPresent(fastTransferPage.tokenField);
		fastTransferPage.fillinToken();

		//4.11.Click on the "Confirm" button
		fastTransferPage.clickOnConfirmBtn();
		InecobankTransactionsPage main = new InecobankTransactionsPage(driver);
		
		//Validate that the transaction was successful
		main.waitForElementPresent(main.transactionsListTxt);
		Assert.assertTrue(main.isElementPresent(InecobankTransactionsPageXpaths.TRANSACTIONS_LIST_TXT));
		main.waitForElementPresent(main.transactionValue);
		Assert.assertEquals(main.transactionValue.getText(), "1.00 AMD");
		
		//Additional step:
	    driver.navigate().to("http://192.168.88.71:4000/transactions");
		
	}

	@Test
	public void testMoneyGramTransfer2() throws InterruptedException {
		//Test case ID:5
				//5.1.Navigate to Money Transfer.
				InecobankTransactionsPage page = new InecobankTransactionsPage(driver);
				page.navigateToMoneyTransfer();
				
				//5.2.Click on "Receive fast transfer" in the "Transaction type" field. 
				InecobankMoneyTransferTypePage type = new InecobankMoneyTransferTypePage(driver);
				type.waitForElementPresent(type.transferTypeField);
				type.clickOnTransferTypeField();
				InecobankFastTransferPage fastTransferPage = type.clickOnReceiveFastTransfer();
				
				//5.3.Select the "MoneyGram" option in the "Transfer system" field.
				fastTransferPage.waitForElementPresent(fastTransferPage.transferSystemField);
				fastTransferPage.clickOnMoneygram();
				
				//5.4.Type "12345678" in the "Transfer code" field.
				fastTransferPage.fillinTransferCodeField("12345678");

				//5.5.Type "10" in the "Amount" field.
				fastTransferPage.fillinAmountField("10");

				//5.6.Select "Armenia" in the "Country" field.
				fastTransferPage.fillinCountryField("Armenia");

				//5.7.Type any sender name in the "Sender" field.
				fastTransferPage.fillinSenderField("Sender");
				
				//5.8.Click on the "Confirm" button.
				fastTransferPage.confirmBtn.click();
				
				fastTransferPage.confirmBtn.click();
				fastTransferPage.waitForElementPresent(fastTransferPage.errMessageTransferCode);
				Assert.assertTrue(fastTransferPage.errMessageTransferCode.isDisplayed());
				
				//Additional step:
			    driver.navigate().to("http://192.168.88.71:4000/transactions");
		
	}
	
	
	@Test
	public void testConverseTransferPositive() throws InterruptedException {
		//Test case ID:6
		//6.1.Navigate to Money Transfer
		InecobankTransactionsPage page = new InecobankTransactionsPage(driver);
		page.navigateToMoneyTransfer();
		
		//6.2.Click on "Receive fast transfer" in the "Transaction type" field 
		InecobankMoneyTransferTypePage type = new InecobankMoneyTransferTypePage(driver);
		type.waitForElementPresent(type.transferTypeField);
		type.clickOnTransferTypeField();
		InecobankFastTransferPage fastTransferPage = type.clickOnReceiveFastTransfer();
		
		//6.3.Select the "Converse transfer" option in the "Transfer system" field
		fastTransferPage.waitForElementPresent(fastTransferPage.transferSystemField);
		fastTransferPage.clickOnConverseTransfer();
		
		//6.4.Type 10 digits in the "Transfer code" field.
		fastTransferPage.fillinTransferCodeField("1234567891");

		//6.5. Enter positive amount in "Amount" field
		fastTransferPage.fillinAmountField("10");

		//6.6. Select UKraine from the "Country" field
		fastTransferPage.fillinCountryField("Ukraine");
		fastTransferPage.fillinSenderField("");

		//6.7.Select the first AMD current account from the "To" field
		fastTransferPage.fillinToField();

		//6.8.Click on the "Confirm" button
		fastTransferPage.confirmBtn.click();
	
		//6.9.Fill in the "Two Factor Token" field
		fastTransferPage.waitForElementPresent(fastTransferPage.tokenField);
		fastTransferPage.fillinToken();

		//6.10.Click on the "Confirm" button
		fastTransferPage.clickOnConfirmBtn();
		InecobankTransactionsPage main = new InecobankTransactionsPage(driver);
		main.waitForElementPresent(main.transactionsListTxt);
		Assert.assertTrue(main.isElementPresent(InecobankTransactionsPageXpaths.TRANSACTIONS_LIST_TXT));
		main.waitForElementPresent(main.transactionValue);
		Assert.assertEquals(main.transactionValue.getText(), "10.00 AMD");
		
		//Additional step:
	    driver.navigate().to("http://192.168.88.71:4000/transactions");
	}
		
	@Test
	public void testConverseTransferNegative() throws InterruptedException {
		//Test case ID:7
		//7.1.Navigate to Money Transfer
		InecobankTransactionsPage page = new InecobankTransactionsPage(driver);
		page.navigateToMoneyTransfer();
		
		//7.2.Click on "Receive fast transfer" in the "Transaction type" field 
		InecobankMoneyTransferTypePage type = new InecobankMoneyTransferTypePage(driver);
		type.waitForElementPresent(type.transferTypeField);
		type.clickOnTransferTypeField();
		InecobankFastTransferPage fastTransferPage = type.clickOnReceiveFastTransfer();
		
		//7.3.Select the "Converse transfer" option in the "Transfer system" field
		fastTransferPage.waitForElementPresent(fastTransferPage.transferSystemField);
		fastTransferPage.clickOnConverseTransfer();
		
		//7.4.Type 10 digits in the "Transfer code" field.
		fastTransferPage.fillinTransferCodeField("1234567891");

		//7.5. Select Armenia from the "Country" field
		fastTransferPage.fillinCountryField("Armenia");
		fastTransferPage.fillinSenderField("");

		//7.6.Select the first AMD current account from the "To" field
		fastTransferPage.fillinToField();

		//7.7.Click on the "Confirm" button
		fastTransferPage.clickOnConfirmBtn();
		fastTransferPage.waitForElementPresent(fastTransferPage.errorMessageAmountField);
		Assert.assertTrue(fastTransferPage.errorMessageAmountField.isDisplayed());	
		
		//Additional step:
	    driver.navigate().to("http://192.168.88.71:4000/transactions");
	}
	
	@Test

	public void testIntelExpressPositive() throws InterruptedException {

		// Test case ID:8
		// 8.1.Navigate to Money Transfer.
		InecobankTransactionsPage page = new InecobankTransactionsPage(driver);
		page.navigateToMoneyTransfer();

		// 8.2.Click on "Receive fast transfer" in the "Transaction type" field.
		InecobankMoneyTransferTypePage type = new InecobankMoneyTransferTypePage(driver);
		type.waitForElementPresent(type.transferTypeField);
		type.clickOnTransferTypeField();
		InecobankFastTransferPage fastTransferPage = type.clickOnReceiveFastTransfer();

		// 8.3.Select the "MoneyGram" option in the "Transfer system" field.
		fastTransferPage.waitForElementPresent(fastTransferPage.transferSystemField);
		fastTransferPage.clickOnIntelExpress();

		// 8.4.Type "12345678" in the "Transfer code" field.
		fastTransferPage.fillinTransferCodeField("12345678");

		// 8.5.Enter any positive amount in the "Amount" field
		fastTransferPage.fillinAmountField("15");

		// 8.6.Select "Armenia" in the "Country" field.
		fastTransferPage.fillinCountryField("Armenia");

		// 8.7.Enter any sender name in the "Sender" field
		fastTransferPage.fillinSenderField("Sender");

		// 8.8.Select the first AMD current account in the "To" field
		fastTransferPage.fillinToField();

		// 8.9.Click on the "Confirm" button
		fastTransferPage.confirmBtn.click();

		// 8.10.Fill in the "Two Factor Token" field
		fastTransferPage.waitForElementPresent(fastTransferPage.tokenField);
		fastTransferPage.fillinToken();

		// 8.11.Click on the "Confirm" button
		fastTransferPage.clickOnConfirmBtn();
		InecobankTransactionsPage main = new InecobankTransactionsPage(driver);

		// Validate that the transaction was successful
		main.waitForElementPresent(main.transactionsListTxt);
		Assert.assertTrue(main.isElementPresent(InecobankTransactionsPageXpaths.TRANSACTIONS_LIST_TXT));
		main.waitForElementPresent(main.transactionValue);
		Assert.assertEquals(main.transactionValue.getText(), "15.00 AMD");
		
		//Additional step:
	    driver.navigate().to("http://192.168.88.71:4000/transactions");

	}

	@Test

	public void testIntelExpressNegative() throws InterruptedException {

		// Test case ID:9
		// 9.1.Navigate to Money Transfer.
		InecobankTransactionsPage page = new InecobankTransactionsPage(driver);
		page.navigateToMoneyTransfer();

		// 9.2.Click on "Receive fast transfer" in the "Transaction type" field.
		InecobankMoneyTransferTypePage type = new InecobankMoneyTransferTypePage(driver);
		type.waitForElementPresent(type.transferTypeField);
		type.clickOnTransferTypeField();
		InecobankFastTransferPage fastTransferPage = type.clickOnReceiveFastTransfer();

		// 9.3.Select the "Intel Express" option in the "Transfer system" field.
		fastTransferPage.waitForElementPresent(fastTransferPage.transferSystemField);
		fastTransferPage.clickOnIntelExpress();

		// 9.4.Type "12345678" in the "Transfer code" field.
		fastTransferPage.fillinTransferCodeField("12345678");

		// 9.5.Enter any positive amount in the "Amount" field
		fastTransferPage.fillinAmountField("15");

		// 9.6.Select "Armenia" in the "Country" field.
		fastTransferPage.fillinCountryField("Armenia");

		// 9.7.Enter any sender name in the "Sender" field
		fastTransferPage.fillinSenderField("Sender");

		// 9.8.Click on the "Confirm" button.
		fastTransferPage.confirmBtn.click();
		
		//Validate that the transaction doesnt complete and the error message is displayed
		fastTransferPage.confirmBtn.click();
		fastTransferPage.waitForElementPresent(fastTransferPage.errMessageTransferCode);
		Assert.assertTrue(fastTransferPage.errMessageTransferCode.isDisplayed());
		
		//Additional step:
	    driver.navigate().to("http://192.168.88.71:4000/transactions");
	}
	
	}

