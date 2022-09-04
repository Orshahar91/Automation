package pages._pages_mngt;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import applogic.ApplicationManager1;
import pages._pages_mngt.page_factory.DisplayedElementLocatorFactory;
import pages.super_pages.CheckoutSuperPage;
import pages.super_pages.MenuPage;
import pages.super_pages.Page;
import pages.util_pages.Checkout_AddressesPage;
import pages.util_pages.Checkout_ChoosePaymentPage;
import pages.util_pages.Checkout_EmbeddedSignInPage;
import pages.util_pages.Checkout_OrderConfirmationPage;
import pages.util_pages.Checkout_PaymentByCheckPage;
import pages.util_pages.Checkout_ShippingPage;
import pages.util_pages.Checkout_ShoppingCartSummaryPage;
import pages.util_pages.HomePage;
import pages.util_pages.ItemsPage;
import pages.util_pages.OrderHistoryPage;
import pages.util_pages.PreCheckoutDlg;
import util.ParamsUtils;
import util.SelUtils;

public class MainPageManager {

	private WebDriver driver;
	public SelUtils su;
	private Logger log;
	private ParamsUtils sessionParams;
	
	public CheckoutSuperPage checkoutSuperPage;
	public Checkout_ShoppingCartSummaryPage checkout_ShoppingCartSummaryPage;
	public Checkout_EmbeddedSignInPage checkout_EmbeddedSignInPage;
	public Checkout_AddressesPage checkout_AddressesPage;
	public Checkout_ShippingPage checkout_ShippingPage;
	public Checkout_ChoosePaymentPage checkout_ChoosePaymentPage;
	public Checkout_PaymentByCheckPage checkout_PaymentByCheckPage;
	public Checkout_OrderConfirmationPage checkout_OrderConfirmationPage;
	public PreCheckoutDlg preCheckoutDlg;
	public MenuPage menuPage;
	public HomePage homePage;
	public ItemsPage itemsPage;
	public OrderHistoryPage orderHistoryPage;


	public MainPageManager(ApplicationManager1 app) {
		driver = app.getDriver();
		su = app.su;
		log = app.getLogger();
		sessionParams = app.getParamsUtils();
		
		checkoutSuperPage = initElements(new CheckoutSuperPage(this));
		checkout_ShoppingCartSummaryPage = initElements(new Checkout_ShoppingCartSummaryPage(this));
		checkout_EmbeddedSignInPage = initElements(new Checkout_EmbeddedSignInPage(this));
		checkout_AddressesPage = initElements(new Checkout_AddressesPage(this));
		checkout_ShippingPage = initElements(new Checkout_ShippingPage(this));
		checkout_ChoosePaymentPage = initElements(new Checkout_ChoosePaymentPage(this));
		checkout_PaymentByCheckPage = initElements(new Checkout_PaymentByCheckPage(this));
		checkout_OrderConfirmationPage = initElements(new Checkout_OrderConfirmationPage(this));
		preCheckoutDlg = initElements(new PreCheckoutDlg(this));
		menuPage = initElements(new MenuPage(this));
		homePage = initElements(new HomePage(this));
		itemsPage = initElements(new ItemsPage(this));
		orderHistoryPage = initElements(new OrderHistoryPage(this));
	}

	public <T extends Page> T initElements(T page) {
		PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);
		return page;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public Logger gerLogger() {
		return log;
	}

	public ParamsUtils getSessionParams() {
		return sessionParams;
	}
}
