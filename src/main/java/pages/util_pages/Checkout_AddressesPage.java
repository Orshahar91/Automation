package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.CheckoutSuperPage;
import util.GenUtils;

public class Checkout_AddressesPage extends CheckoutSuperPage   {

	public Checkout_AddressesPage(MainPageManager pages) {
		super(pages);

	}

	public Checkout_AddressesPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"order_step\"]")));
		return this;
	}

	public Checkout_ShippingPage clickProceed() {
		GenUtils.sleepMillis(2000);
		log.info("Click procced");
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
		return pages.checkout_ShippingPage.ensurePageLoaded();
	}
}
