package testsuite;
/**
 * Write down the following test into ‘MenTest’ class
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    // Individual open and close
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1. userShouldAddProductSuccessFullyToShoppingCart
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // Mouse Hover on Men Menu
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//span[normalize-space()='Men']"));
        // Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));
        // Click on Pants
        mouseHoverToElementAndClick(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        //  Mouse Hover on product name ‘Cronus Yoga Pant’
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        // click on size32
        mouseHoverToElementAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        // Mouse Hover on product name‘Cronus Yoga Pant’
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        // click on colour Black
        mouseHoverToElementAndClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        // Mouse Hover on product name ‘Cronus Yoga Pant’
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        // click on ‘Add To Cart’ Button
        mouseHoverToElementAndClick(By.xpath("//div[@class='actions-primary']/form//button/span"));
        // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        verifyTheStringMessage(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),"You added Cronus Yoga Pant to your shopping cart.");
        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // Verify the text ‘Shopping Cart.’
        verifyTheStringMessage(By.xpath("//span[@class='base']"),"Shopping Cart");
        // Verify the product name ‘Cronus Yoga Pant’
        verifyTheStringMessage(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"),"Cronus Yoga Pant");
        // Verify the product size ‘32’
        verifyTheStringMessage(By.xpath("//dd[contains(text(),'32')]"),"32");
        // Verify the product colour ‘Black’
        verifyTheStringMessage(By.xpath("//dd[contains(text(),'Black')]"),"Black");

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
