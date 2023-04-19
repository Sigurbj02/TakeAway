package hi.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {
    private ObservableList<Product> products = FXCollections.observableArrayList();//throw an exception when it's empty
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        menu = new Menu();
    }

    @Test
    public void testSetMenuData() {
        menu.setMenuData();
        assertFalse("The menu should not be empty", menu.getProducts().isEmpty());
        assertEquals("The name of the first product on the menu should be Pestópasta", "Pestópasta", menu.getProducts().get(0).getProduct());
        assertEquals("The price of the first product on the menu should be 10900", menu.getProducts().get(0).getPrice(), 10900);
        int lastMenuIndex = menu.getProducts().size() - 1;
        assertEquals("The last item on the menu should be pylsa í brauði", "pylsa í brauði", menu.getProducts().get(lastMenuIndex).getProduct());
        assertEquals("The last item on the menu should cost 3400 ", 3400, menu.getProducts().get(lastMenuIndex).getPrice());
    }

    @Test
    public void getProducts() {
        assertEquals("The items on the empty menu should have the same string value as an empty ObservableList<Product>", menu.getProducts().toString(), products.toString());
        menu.setMenuData();
        assertNotEquals("The items on the menu should not have the same string value as an empty ObservableList<Product>", menu.getProducts(), products);
    }
}
