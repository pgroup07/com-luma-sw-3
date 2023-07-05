package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Gear Menu
        mouseHover(By.xpath("//a[@id='ui-id-6']"));
        //Click on Bags
        mouseHoverAndClick(By.xpath("//a[@id='ui-id-25']"));
        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        Thread.sleep(1000);
        // Verify the text ‘Overnight Duffle’
        String expectedMessage = "Overnight Duffle";
        String actualMessage = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        //Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        Thread.sleep(1000);
        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        Thread.sleep(1000);
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedText = "You added Overnight Duffle to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals(expectedText, actualText);
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("(//span[@class='counter qty'])[1]"));
        Thread.sleep(2000);
        //Verify the Qty is ‘3’
        String expectedMessag = "3";
        String actualMessag = getTextFromElement(By.xpath("//input[@id='cart-item-238048-qty']"));
        Assert.assertEquals(expectedMessag, actualMessag);
        // Verify the product price ‘$135.00’
        String expectedMess = "$135.00";
        String actualMess = getTextFromElement(By.xpath("//span[contains(text(),'$135.00')]"));
        Assert.assertEquals(expectedMess, actualMess);
        Thread.sleep(1000);
        //Change Qty to ‘5’
        driver.findElement(By.xpath("//input[@id='cart-item-238048-qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='cart-item-238048-qty']"), "5");
        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
        //Verify the product price ‘$225.00’
        String expectedM = "$225.00";
        String actualM = getTextFromElement(By.xpath("//span[contains(text(),'$225.00')]"));
        Assert.assertEquals(expectedM, actualM);

    }
}
