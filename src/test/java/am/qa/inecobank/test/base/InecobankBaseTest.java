package am.qa.inecobank.test.base;

import static am.qa.inecobank.page.moneytransfer.InecobankMoneyTransferTypePageXpaths.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import am.qa.inecobank.page.base.InecobankBasePage;
import am.qa.inecobank.page.login.InecobankLoginPage;
import am.qa.inecobank.page.transactions.InecobankTransactionsPage;
import am.qa.inecobank.page.transactions.InecobankTransactionsPageXpaths;

public class InecobankBaseTest {
	protected WebDriver driver; 
	
	@BeforeTest()
	public void prepareEnv() throws IOException {
		Properties prop;
		prop = readPropertiesFile("src/test/resources/browser.properties");
		String browserType = prop.getProperty("type");
		String driverPath = prop.getProperty("path");
		System.setProperty(browserType, driverPath);
		openBrowser(browserType);
		
		
		

		
	}
	
	@BeforeClass
	public void login() throws IOException {
		InecobankLoginPage page = new InecobankLoginPage(driver);
		page.fillFields();
		page.login();
		InecobankTransactionsPage main = new InecobankTransactionsPage(driver);
		main.waitForElementPresent(main.transactionsListTxt);
		Assert.assertTrue(main.isElementPresent(InecobankTransactionsPageXpaths.TRANSACTIONS_LIST_TXT));
	}
	
	

	public Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}

	public void openBrowser(String browserType) {
		switch (browserType) {
		case "webdriver.chrome.driver":
			driver = new ChromeDriver();
			break;
		case "webdriver.gecko.driver":
			driver = new FirefoxDriver();
			break;
		default:
			driver = new InternetExplorerDriver();
		}

		driver.get(SECURITY_BASE_URL);
		InecobankBasePage base = new InecobankBasePage(driver);
		base.acceptError();
		driver.manage().window().maximize();
		
		driver.navigate().to(BASE_URL);
		driver.manage().window().maximize();
	}
	

	@AfterClass
	public void cleanup() {
	//driver.quit();
		
	}
	
	
//	@AfterTest
//	public void teardown() {
//		driver.quit();
//	}
//	
	 


}
