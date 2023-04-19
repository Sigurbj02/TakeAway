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
    }

    @Test
    public void testNameProperty() {
        assertNotNull("the nameProperty of the customer should not be null", customer.nameProperty());
        assertEquals("The name of the customer should be James", "James", customer.nameProperty().get());
        customer.nameProperty().set("Anna");
        assertEquals("The name of the customer should be Anna", "Anna", customer.nameProperty().get());
    }

    @Test
    public void testAddressProperty() {
        assertNotNull("the addressProperty of the customer should not be null", customer.addressProperty());
        assertEquals("The address of the customer should be 12 Oak Lane", "12 Oak Lane", customer.addressProperty().get());
        customer.addressProperty().set("123 Sesame Street");
        assertEquals("The address of the customer should be 123 Sesame Street", "123 Sesame Street", customer.addressProperty().get());
    }
}
