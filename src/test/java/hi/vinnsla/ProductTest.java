package hi.vinnsla;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ProductTest {
    private Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product("Pepperoni pizza", 1290);
        assertEquals(product.getProduct(), "Pepperoni pizza");
        assertEquals(product.getPrice(), 1290);
    }

    @Test
    public void testGetProduct() {
        assertNotNull(product.getProduct());
        assertEquals("Pepperoni pizza", product.getProduct());
        //if there was a setter setProduct in Product, we would set it to something different and make sure it's correct
        //what if product is null? should we check that?
    }

    @Test
    public void testGetPrice() {
        assertTrue(product.getPrice() > 0);
        assertEquals(product.getPrice(), 1290);
    }

    @Test
    public void testToString() {
        assertNotNull(product.toString());
        assertEquals(product.toString(), product.getProduct() + ", " + product.getPrice());
        //or assertEquals(product.toString(), "Pepperoni pizza, 1290");
    }
}
