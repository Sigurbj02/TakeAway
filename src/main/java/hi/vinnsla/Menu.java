package hi.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Menu {
    private ObservableList<Product> products = FXCollections.observableArrayList();//throw an exception when it's empty

    /**
     * The String in the method is split up and sorted to make different items on the menu.
     * Filtered out if the name is too long
     */
    public void setMenuData() {
        String menuString = "Pestópasta, 10900, Spagettí, 290, íslensk kjötsúpa, 1500, Pepperóní pizza, 2319, " +
                "Margaríta pizza, 2187, Hundamatur, 200, Einn banani, 3000, mjólk, 1090, " +
                "súrsaðir hrútspungar, 11, páfagaukavængir, 2500, DIY tómatsúpa, 2390, brjóstamjólkurís , 9999, " +
                "pulsa í brauði, 600, pylsa í brauði, 3400, ";
        String[] menuArray = menuString.split(", ");
        for (int i = 0; i < menuArray.length - 1; i = i + 2) {
            if (menuArray[i].length() <= 30) {
                products.add(new Product(menuArray[i], Integer.parseInt(menuArray[i + 1])));
            }
        }
    }

    public ObservableList<Product> getProducts() {
        return products;
    }
}
