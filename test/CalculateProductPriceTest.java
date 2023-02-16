import com.java.grocery.CalculateProductPrice;

import com.utilities.GroceryShoppingConstants;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.time.LocalDate;


public class CalculateProductPriceTest {


    private CalculateProductPrice productPrice;


    @Test
    public void testCalculateBreadPrice() {
        double expected = 2.4;
        productPrice = new CalculateProductPrice();
        LocalDate purchaseDate = LocalDate.parse("2019-06-26");
        double actual = productPrice.calculateBreadPrice(LocalDate.now(), 0, GroceryShoppingConstants.BREAD_PRICE, 0,
                purchaseDate, 3);
        Assert.assertEquals(expected, Double.parseDouble(new DecimalFormat("#.##").format(actual)));
    }


    @Test
    public void testCalculateBreadPriceWithDiscount() {
        double expected = 3.95;
        productPrice = new CalculateProductPrice();
        LocalDate purchaseDate = LocalDate.parse("2019-06-26");
        double actual = productPrice.calculateBreadPrice(LocalDate.now(),
                productPrice.getSubTotal(0, GroceryShoppingConstants.SOUP_PRICE, 3),
                GroceryShoppingConstants.BREAD_PRICE, 3, purchaseDate, 3);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testCalculateBreadPriceWithDiscount1() {
        double expected = 3.4;
        productPrice = new CalculateProductPrice();
        LocalDate purchaseDate = LocalDate.parse("2019-06-26");
        double actual = productPrice.calculateBreadPrice(LocalDate.now(),
                productPrice.getSubTotal(0, GroceryShoppingConstants.SOUP_PRICE, 4),
                GroceryShoppingConstants.BREAD_PRICE, 4, purchaseDate, 2);
        Assert.assertEquals(expected, Double.parseDouble(new DecimalFormat("#.##").format(actual)));
    }


    @Test
    public void testCalculateApplePrice() {
        double expected = 0.30;
        productPrice = new CalculateProductPrice();
        LocalDate purchaseDate = LocalDate.parse("2019-08-26");
        double actual = productPrice.calculateApplePrice(LocalDate.now(), 0, GroceryShoppingConstants.APPLE_PRICE,
                purchaseDate, 3);
        Assert.assertEquals(expected, Double.parseDouble(new DecimalFormat("#.##").format(actual)));
    }


    @Test
    public void testCalculateApplePriceWithDiscount() {
        double expected = 0.27;
        productPrice = new CalculateProductPrice();
        LocalDate purchaseDate = LocalDate.parse("2019-07-02");
        double actual = productPrice.calculateApplePrice(LocalDate.now(), 0, GroceryShoppingConstants.APPLE_PRICE,
                purchaseDate, 3);
        Assert.assertEquals(expected, actual);
    }


}




