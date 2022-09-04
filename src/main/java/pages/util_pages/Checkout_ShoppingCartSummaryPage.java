package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.CheckoutSuperPage;

public class Checkout_ShoppingCartSummaryPage extends CheckoutSuperPage   {

	public Checkout_ShoppingCartSummaryPage(MainPageManager pages) {
		super(pages);

	}
	
	public Checkout_ShoppingCartSummaryPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#cart_title")));
		return this;
	}
	
	public Checkout_EmbeddedSignInPage clickProceedReturnSignInPage() {
		
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();

		return pages.checkout_EmbeddedSignInPage.ensurePageLoaded();
	}
}

