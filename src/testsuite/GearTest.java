package testsuite;
/**
 * .Write down the following test into ‘GearTest’ class
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    // Individual open and close
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1 userShouldAddProductSuccessFullyToShoppingCart
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        Thread.sleep(2000);
        // Mouse Hover on Gear Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));
        // Click on Bags
        Thread.sleep(2000);
        mouseHoverToElementAndClick(By.xpath("//span[normalize-space()='Bags']"));
        // Click on Product Name ‘Overnight Duffle’
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        // Verify the text ‘Overnight Duffle’
        verifyTheStringMessage(By.xpath("//span[@class='base']"), "Overnight Duffle");
        // Change Qty 3
        clearTextFromField(By.xpath("//input[@id='qty']"));
        sendKeysToElement(By.xpath("//input[@id='qty']"), "3");
        // Click on ‘Add to Cart’ Button
        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));
        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        verifyTheStringMessage(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"), "You added Overnight Duffle to your shopping cart.");
        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // Verify the product name ‘Overnight Duffle’
        verifyTheStringMessage(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"), "Overnight Duffle");
        // Verify the Qty is ‘3’
        String actualQuantity = driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$45.00']"))).getAttribute("value");
        String expectedQuantity = "3";
        Assert.assertEquals(expectedQuantity, actualQuantity);
        // Verify the product price ‘$135.00’
        verifyTheStringMessage(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"), "$135.00");
        // Change Qty to ‘5’
        String s = Keys.CONTROL + "a";
        sendTextToElement(RelativeLocator.with(By.tagName("input")).toRightOf(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$45.00']")), s);
        sendTextToElement(RelativeLocator.with(By.tagName("input")).toRightOf(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$45.00']")), "5");
        // Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        // Verify the product price ‘$225.00’
        verifyTheStringMessage(By.xpath("//td[@class='col subtotal']//span[@class='price'][normalize-space()='$225.00']"), "$225.00");
    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}
