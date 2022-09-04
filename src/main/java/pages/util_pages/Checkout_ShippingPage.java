package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.CheckoutSuperPage;



public class Checkout_ShippingPage extends CheckoutSuperPage   {

	public Checkout_ShippingPage(MainPageManager pages) {
		super(pages);

	}

	public Checkout_ShippingPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"carrier_area\"]/h1")));
		return this;
	}

	public String getShippingPrice() {
		String price = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[2]/div[1]/div/div/table/tbody/tr/td[4]/div")).getText();
		log.info("Shipping price is:" + price);
		return price;
	}

	public Checkout_ShippingPage setTermsOfService(boolean agree) {
		log.info("Check agreenmant check box");
		if (agree) {
			driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
		}
		return this;
	}

	public Checkout_ChoosePaymentPage clickProceed() {
		log.info("Click procced");
		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
		return pages.checkout_ChoosePaymentPage.ensurePageLoaded();
	}
}