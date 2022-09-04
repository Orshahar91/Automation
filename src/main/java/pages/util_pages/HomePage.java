package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenuPage;



public class HomePage extends MenuPage {


	public HomePage(MainPageManager pages) {
		super(pages);
	}

	public HomePage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"home-page-tabs\"]")));
		return this;
	}

}

