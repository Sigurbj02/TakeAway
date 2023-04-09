package hi.vinnsla;

import java.io.InputStream;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Menu {
    private ObservableList<Product> products = FXCollections.observableArrayList();//throw an exception when it's empty

    /**
     * The String in the method is split up and sorted to make different items on the menu.
     * Filtered out if the name is too long
     */
    public void setMenuData() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("menus.csv");
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(", ");
            if (line[0].length() <= 30) {
                products.add(new Product(line[0], Integer.parseInt(line[1])));
            }
        }
        scanner.close();
    }

    public ObservableList<Product> getProducts() {
        return products;
    }
}
