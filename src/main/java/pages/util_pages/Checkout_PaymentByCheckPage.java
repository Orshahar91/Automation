package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.CheckoutSuperPage;
import util.GenUtils;


public class Checkout_PaymentByCheckPage extends CheckoutSuperPage   {

	public Checkout_PaymentByCheckPage(MainPageManager pages) {
		super(pages);

	}

	public Checkout_PaymentByCheckPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/form/div/p[1]/strong")));
		return this;
	}

	public Checkout_PaymentByCheckPage verifyPrice(String expectedPrice) {

		log.info("Verify price");
		String actualPrice = driver.findElement(By.xpath("//*[@id=\"amount\"]")).getText();

		Assert.assertTrue(expectedPrice.equals(actualPrice), 
				"Expected price is " + expectedPrice + " but instead received " + actualPrice);

		return this;
	}

	public Checkout_OrderConfirmationPage clickConfirmOrder() {

		log.info("Click confirm order");
		GenUtils.sleepMillis(2000);
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
		return pages.checkout_OrderConfirmationPage.ensurePageLoaded();
	}
}