package pages.super_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gargoylesoftware.htmlunit.javascript.host.Console;

import pages._pages_mngt.MainPageManager;
import pages.util_pages.ItemsPage;

public class MenuPage extends AnyPage {

	public MenuPage(MainPageManager pages) {
		super(pages);
	}

	public MenuPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header_logo\"]/a")));
		return this;
	}

	public ItemsPage clickTShirtsTab() {

		log.info("Click t-shirt tab");

		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();

		return pages.itemsPage.ensurePageLoaded();
	}
}
