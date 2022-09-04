package pages.super_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;

public class CheckoutSuperPage extends MenuPage {


	public CheckoutSuperPage(MainPageManager pages) {
		super(pages);
	}

	public CheckoutSuperPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"order_step\"]")));
		return this;
	}

}