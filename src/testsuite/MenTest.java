package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // Mouse Hover on Men Menu
        mouseHover(By.xpath("//span[normalize-space()='Men']"));
        // Mouse Hover on Bottoms
        Thread.sleep(2000);
        mouseHover(By.xpath("(//span[contains(text(),'Bottoms')])[2]"));
        // Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHover(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverAndClick(By.xpath("(//div[@id='option-label-size-143-item-175'])[1]"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black
        mouseHoverAndClick(By.xpath("(//div[@id='option-label-color-93-item-49'])[1]"));
        // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        clickOnElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));

        // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedMessage = "You added Cronus Yoga Pant to your shopping cart.";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='message-success success message']"));
        Assert.assertEquals(expectedMessage, actualMessage);

        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("(//span[@class='counter qty'])[1]"));
        // Verify the text ‘Shopping Cart.’
        String expectedMessage1 = "shopping cart";
        String actualMessage1 = getTextFromElement(By.xpath("//a[normalize-space()='shopping cart']"));
        Assert.assertEquals(expectedMessage1, actualMessage1);
        // Verify the product name ‘Cronus Yoga Pant’
        String expectedMessage2 = "Cronus Yoga Pant";
        String actualMessage2 = getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals(expectedMessage2, actualMessage2);
        // Verify the product size ‘32’
        String expectedMessage3 = "32";
        String actualMessage3 = getTextFromElement(By.xpath("//div[@id='option-label-size-143-item-175']"));
        Assert.assertEquals(expectedMessage3, actualMessage3);
        // Verify the product colour ‘Black’
        String expectedMessage4 = "Black";
        String actualMessage4 = getTextFromElement(By.xpath("//div[@id='option-label-color-93-item-49']"));
        Assert.assertEquals(expectedMessage4, actualMessage4);
    }
}


