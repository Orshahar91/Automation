package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.AnyPage;

public class PreCheckoutDlg extends AnyPage {
	

	public PreCheckoutDlg(MainPageManager pages) {
		super(pages);
	}
	
	public PreCheckoutDlg ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")));
		return this;
	}
	
	public Checkout_ShoppingCartSummaryPage clickProceedToCheckout() {
		
		log.info("Click proceed to checkout");
		driver.findElement(By.xpath("//a[contains(@title, 'Proceed to checkout')]")).click();
		return pages.checkout_ShoppingCartSummaryPage.ensurePageLoaded();
	}

}

