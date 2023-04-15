package hi.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;

public class MenuTest {
    private ObservableList<Product> products = FXCollections.observableArrayList();//throw an exception when it's empty
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        menu = new Menu();
    }

    @Test
    public void setMenuData() {
       
    }

    @Test
    public void getProducts() {
        assert (menu.getProducts().equals(products));
    }
}
