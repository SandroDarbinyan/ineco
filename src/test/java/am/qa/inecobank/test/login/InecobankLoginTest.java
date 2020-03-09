package am.qa.inecobank.test.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import am.qa.inecobank.page.login.InecobankLoginPage;
import am.qa.inecobank.page.transactions.InecobankTransactionsPage;
import am.qa.inecobank.page.transactions.InecobankTransactionsPageXpaths;
import am.qa.inecobank.test.base.InecobankBaseTest;


public class InecobankLoginTest extends InecobankBaseTest{

	@Test
	public void loginFunctionalityTest() {
		InecobankLoginPage page = new InecobankLoginPage(driver);
		page.fillFields();
		page.login();
		InecobankTransactionsPage main = new InecobankTransactionsPage(driver);
		main.waitForElementPresent(main.transactionsListTxt);
		Assert.assertTrue(main.isElementPresent(InecobankTransactionsPageXpaths.TRANSACTIONS_LIST_TXT));
	
	}
}



