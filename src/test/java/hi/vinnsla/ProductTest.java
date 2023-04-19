package hi.vinnsla;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ProductTest {
    private Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product("Pepperoni pizza", 1290);
    }

    @Test
    public void testGetProduct() {
        assertNotNull("the product of the product should not  be null", product.getProduct());
        assertEquals("the product name should be Pepperoni pizza", "Pepperoni pizza", product.getProduct());

        //if there was a setter setProduct in Product, we would set it to something different and make sure it's correct
        //what if product is null? should we check that?
    }

    @Test
    public void testGetPrice() {
        assertEquals("the product price should be 1290", product.getPrice(), 1290);
    }

    @Test
    public void testToString() {
        assertEquals("The toString() method for this product should return Pepperoni pizza, 1290", product.toString(), "Pepperoni pizza, 1290");
    }
}
