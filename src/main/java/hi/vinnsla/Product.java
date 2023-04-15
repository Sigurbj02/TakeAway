package hi.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * this class was called Veitingar, which means food and drinks, but i can't think of a direct translation
 */
public class Product {
    private StringProperty product = new SimpleStringProperty();
    private IntegerProperty price = new SimpleIntegerProperty();

    public Product(String product, int price) {
        this.product.set(product);
        this.price.set(price);
    }

    public int getPrice() {
        return price.get();
    }

    /**
     * toString method to combine the name and price of the item into one string, but not like
     * in ListViews
     */
    public String toString() {
        return product.get() + ", " + price.get();
    }
}
