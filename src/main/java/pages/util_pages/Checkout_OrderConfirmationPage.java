package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.CheckoutSuperPage;
import util.GenUtils;


public class Checkout_OrderConfirmationPage extends CheckoutSuperPage   {

	public Checkout_OrderConfirmationPage(MainPageManager pages) {
		super(pages);

	}

	public Checkout_OrderConfirmationPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/div/strong[3]")));
		return this;
	}

	public Checkout_OrderConfirmationPage verifyPrice(String expectedPrice) {

		log.info("Verify payment in confirmation page");
		String actualPrice = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/span/strong")).getText();

		Assert.assertTrue(expectedPrice.equals(actualPrice),
				"Expected text is " + expectedPrice + " but instead received " + actualPrice);

		return this;
	}

	public OrderHistoryPage clickBackToOrders() {
        GenUtils.sleepMillis(3000);
		log.info("Click back to orders");
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a")).click();
		return pages.orderHistoryPage.ensurePageLoaded();
	}
}