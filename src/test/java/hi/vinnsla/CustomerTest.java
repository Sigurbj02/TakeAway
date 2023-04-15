package hi.vinnsla;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
    private Customer customer;

    @Before
    public void createCustomer() throws Exception {
        customer = new Customer("nameExample", "addressExample");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void nameProperty() {
    }

    @Test
    public void addressProperty() {
    }
}
