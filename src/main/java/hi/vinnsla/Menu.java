package hi.vinnsla;

import java.io.IOException;
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
    public void setMenuData() throws IOException {
        /*
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
        */
        populateFromFile();
    }

    public ObservableList<Product> getProducts() {
        return products;
    }
    public void populateFromFile() throws IOException {
        /* String[] line;
        String filepath = new File("src/main/java/menus.csv").getAbsolutePath();
        System.out.println("Full filepath is: " + new File("src/main/java/menus.csv").getCanonicalPath());
        System.out.println("which can also be written as: " + filepath);
        */
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("menus.csv");
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(", ");
            System.out.println("line is: '" + line[0] + "' for name; and '" + line[1] + "' for price.");
            if (line[0].length() <= 30) {
                products.add(new Product(line[0], Integer.parseInt(line[1])));
            }
        }
        scanner.close();
    }
}
