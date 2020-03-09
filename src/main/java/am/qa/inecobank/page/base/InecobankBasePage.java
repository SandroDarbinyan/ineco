package am.qa.inecobank.page.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InecobankBasePage {
	protected WebDriver driver;

	public InecobankBasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public boolean isElementPresent(String xpath) {
		if (driver.findElements(By.xpath(xpath)).size() > 0)
			return true;
		else
			return false;
	}

	public void waitForElementPresent(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@FindBy(xpath = "//button[@id='details-button']")
	WebElement acceptError;

	@FindBy(xpath = "//a[@id='proceed-link']")
	WebElement proceedLink;

	public void acceptError() {
		try {
			acceptError.click();
			proceedLink.click();
		} catch (Exception ex) {

		}
	}

}
