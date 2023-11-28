package testsuite;
/**
 * Write down the following test into WomenTestclass
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    // Individual open and close
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1. verifyTheSortByProductNameFilter
    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        // Mouse Hover on Women Menu
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        // Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));
        //    Click on Jackets
        mouseHoverToElementAndClick(By.id("ui-id-11"));
        // Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.id("sorter"),"Product Name ");
        //Verify the products name display in alphabetical order
        verifyTheListIsAscendingOrder(By.xpath("//a[@class='product-item-link']"));

    }
    // 2. verifyTheSortByPriceFilter
    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        // Mouse Hover on Women Menu
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        // Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));
        // Click on Jackets
        mouseHoverToElementAndClick(By.id("ui-id-11"));
        // Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.id("sorter"),"Price ");
        // Verify the products price display in Low to High
        verifyTheListIsAscendingOrder(By.xpath("//span[@class='price']"));
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
