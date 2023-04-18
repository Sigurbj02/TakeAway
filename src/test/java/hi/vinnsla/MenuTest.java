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
        assertNotNull(menu);
    }

    @Test
    public void testSetMenuData() {
        menu.setMenuData();
        assertFalse(menu.getProducts().isEmpty());
        assertEquals("Pestópasta", menu.getProducts().get(0).getProduct());
        assertEquals(menu.getProducts().get(0).getPrice(), 10900);
        int lastMenuIndex = menu.getProducts().size() - 1;
        assertEquals("asksk", "pylsa í brauði", menu.getProducts().get(lastMenuIndex).getProduct());
        assertEquals("sdf ", 3400, menu.getProducts().get(lastMenuIndex).getPrice());
    }

    @Test
    public void getProducts() {
        assert (menu.getProducts().equals(products));
    }
}
