package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class WomenTest extends Utility {


    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        //Mouse Hover on Women Menu
        mouseHover(By.xpath("//span[normalize-space()='Women']"));
        // Mouse Hover on Tops
        mouseHover(By.xpath("(//a[@id='ui-id-9'])[1]"));
        // Click on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        //Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), "Product Name ");
        Thread.sleep(1000);
//        // Verify the products name display in alphabetical order
//        String actualText = "\n" +
//                "Product Name ";
//        String expectedText = getTextFromElement(By.xpath(""));
//        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        // Mouse Hover on Women Menu
        mouseHover(By.xpath("//span[normalize-space()='Women']"));
        // Mouse Hover on Tops
        Thread.sleep(1000);
        mouseHover(By.xpath("//a[@id='ui-id-9']"));
        // Click on Jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        Thread.sleep(1000);
        // Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), "Price ");
        // Verify the products price display in Low to High
//        String expectedMessage = "";
//        String actualMessage = getTextFromElement(By.xpath(""));
//        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @After
    public void tearDown() {
        //  closeBrowser();
    }
}
