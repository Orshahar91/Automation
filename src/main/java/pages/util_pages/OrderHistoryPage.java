package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenuPage;

public class OrderHistoryPage extends MenuPage {


	public OrderHistoryPage(MainPageManager pages) {
		super(pages);
	}

	public OrderHistoryPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"order-list\"]")));
		return this;
	}

	public OrderHistoryPage verifyFirstOrderDate(String expectedDate) {

		log.info("Verify first order date");
		String actualDate = driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[2]")).getText();

		Assert.assertTrue(expectedDate.equals(actualDate),
				"Expected text is " + expectedDate + " but instead received " + actualDate);

		return this;
	}

	public OrderHistoryPage verifyFirstPaymentMethod(String expectedMethod) {
		log.info("Verify first payment method");
		String actualMethod = driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[4]")).getText();

		Assert.assertTrue(expectedMethod.equals(actualMethod),
				"Expected text is " + expectedMethod + " but instead received " + actualMethod);

		return this;
	}

	public OrderHistoryPage verifyFirstTotalPrice(String expectedTotal) {
		log.info("Verify first total price");
		String actualTotal = driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[3]/span")).getText();

		Assert.assertTrue(expectedTotal.equals(actualTotal),
				"Expected text is " + expectedTotal + " but instead received " + actualTotal);

		return this;
	}


}

