package tests.basic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import tests.supers.TestBase;

public class ShoppingEndToEnd extends TestBase {

	String price;

	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date date = new Date();

	@Test
	public void test() {
		try {

			log.info("Open site in browser");

			app.getDriver().get("http://automationpractice.com/index.php/");

			price = app.pages()
					.menuPage
					.ensurePageLoaded()
					.clickTShirtsTab()
					.clickList()
					.getFirstItemPrice();

			String shippingPrice = app.pages()
					.itemsPage
					.clickAddToCart()
					.clickProceedToCheckout()
					.clickProceedReturnSignInPage()
					.setEMail("fff@fff.com")
					.setEPassword("123456")
					.clickSignIn()
					.clickProceed()
					.getShippingPrice();

			price = price.substring(1, price.length());
			shippingPrice = shippingPrice.substring(1,shippingPrice.length());
			String totalPrice =  String.valueOf(Double.parseDouble(price)+Double.parseDouble(shippingPrice));
			totalPrice = "$" + totalPrice;

			app.pages().checkout_ShippingPage
			.setTermsOfService(true)
			.clickProceed()
			.clickPayByCheck()
			.verifyPrice(totalPrice)
			.clickConfirmOrder()
			.verifyPrice(totalPrice).clickBackToOrders()
			.verifyFirstOrderDate(dateFormat.format(date))
			.verifyFirstPaymentMethod("Payment by check")
			.verifyFirstTotalPrice(totalPrice);

			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}
}
