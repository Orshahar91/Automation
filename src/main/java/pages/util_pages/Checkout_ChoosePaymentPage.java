package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.CheckoutSuperPage;


public class Checkout_ChoosePaymentPage extends CheckoutSuperPage   {

	public Checkout_ChoosePaymentPage(MainPageManager pages) {
		super(pages);

	}
	
	public Checkout_ChoosePaymentPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")));
		return this;
	}
	
	public Checkout_PaymentByCheckPage clickPayByCheck() {
		log.info("Click pay by check");
		driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")).click();
		return pages.checkout_PaymentByCheckPage.ensurePageLoaded();
	}
}