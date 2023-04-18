package hi.vinnsla;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CustomerTest {
    private Customer customer;

    @Before
    public void createCustomer() throws Exception {
        customer = new Customer("James", "12 Oak Lane");
        assertEquals("James", customer.nameProperty().get());
        assertEquals("12 Oak Lane", customer.addressProperty().get());
    }

    @Test
    public void testNameProperty() {
        assertNotNull(customer.nameProperty());
        assertEquals("James", customer.nameProperty().get());
        customer.nameProperty().set("Anna");
        assertEquals("Anna", customer.nameProperty().get());
    }

    @Test
    public void testAddressProperty() {
        assertNotNull(customer.addressProperty());
        assertEquals("12 Oak Lane", customer.addressProperty().get());
        customer.addressProperty().set("123 Sesame Street");
        assertEquals("123 Sesame Street", customer.addressProperty().get());
    }
}
