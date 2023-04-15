package hi.vinnsla;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
    private String productName;
    private int productPrice;

    private Product product;

    @Before
    public void setUp() throws Exception {
        productName = "Pepperoni pizza";
        productPrice = 450;
        product = new Product(productName, productPrice);
        assert (product.getPrice() == productPrice);
        assert (product.getProduct().equals(productName));
    }

    @Test
    public void getPrice() {

    }

    @Test
    public void testListViewFormat() {

    }

    @Test
    public void testToString() {
        assert (product.toString().equals(productName + ", " + productPrice));
    }
}
