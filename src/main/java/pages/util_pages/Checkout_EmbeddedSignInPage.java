package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.CheckoutSuperPage;
import util.GenUtils;


public class Checkout_EmbeddedSignInPage extends CheckoutSuperPage   {

	public Checkout_EmbeddedSignInPage(MainPageManager pages) {
		super(pages);

	}

	public Checkout_EmbeddedSignInPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]")));
		return this;
	}
	
	public Checkout_EmbeddedSignInPage setEMail(String email) {
		log.info("Set Email");
		GenUtils.sleepMillis(4000);
		driver.findElement(By.cssSelector("#email")).sendKeys(email);
		return this;
	}

	public Checkout_EmbeddedSignInPage setEPassword(String password) {
		log.info("Set Password");
		driver.findElement(By.cssSelector("#passwd")).sendKeys(password);
		return this;
	}

	public Checkout_AddressesPage clickSignIn() {

		log.info("Click Sign in");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
		return pages.checkout_AddressesPage.ensurePageLoaded();
	}	
}