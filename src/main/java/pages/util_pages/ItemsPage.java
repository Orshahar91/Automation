package pages.util_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenuPage;
import util.GenUtils;


public class ItemsPage extends MenuPage {
	

	public ItemsPage(MainPageManager pages) {
		super(pages);
	}
	
	public ItemsPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/div[2]/div[1]/ul")));
		return this;
	}
	
	public ItemsPage clickList() {
		
		log.info("Click the list view");
		
		driver.findElement(By.xpath("//*[@id=\"list\"]/a/i")).click();
		
		return this;
	}
	
	public String getFirstItemPrice() {
		
		
		GenUtils.sleepMillis(4000);
		
		String price = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div/div[3]/div/div[1]/span")).getText();
		
		log.info("Item price is = " + price);

		return price;
	}
	
	public PreCheckoutDlg clickAddToCart() {
		
		GenUtils.sleepMillis(2000);
		
		log.info("Click add to cart");
		
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div/div[3]/div/div[2]/a[1]/span")).click();
		
		GenUtils.sleepMillis(2000);
		
		return pages.preCheckoutDlg.ensurePageLoaded();
	}

}

