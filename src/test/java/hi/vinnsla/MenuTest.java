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
        String menuString = "Pestópasta, 10900, Spagettí, 290, íslensk kjötsúpa, 1500, Pepperóní pizza, 2319, " +
                "Margaríta pizza, 2187, Hundamatur, 200, Einn banani, 3000, mjólk, 1090, " +
                "súrsaðir hrútspungar, 11, páfagaukavængir, 2500, DIY tómatsúpa, 2390, brjóstamjólkurís , 9999, " +
                "pulsa í brauði, 600, pylsa í brauði, 3400";
        String[] menuArray = menuString.split(", ");
        for (int i = 0; i < menuArray.length - 1; i = i + 2) {
            if (menuArray[i].length() <= 30) {
                products.add(new Product(menuArray[i], Integer.parseInt(menuArray[i + 1])));
            }
        }
    }

    @Test
    public void getProducts() {
        assert (menu.getProducts().equals(products));
    }
}
