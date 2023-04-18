package hi.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ListChangeListener;

public class Basket extends Menu {
    private IntegerProperty totalPrice = new SimpleIntegerProperty();

    public Basket() {
        totalPrice.setValue(0);
        addListener();
    }

    public IntegerProperty totalPriceProperty() {
        return totalPrice;
    }

    /**
     * Adds a ListChangeListener to the total price which updates when items are added to
     * or removed from the basket
     */
    private void addListener() {
        getProducts().addListener((ListChangeListener<Product>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    for (int i = 0; i < change.getAddedSize(); i++) {
                        Product added = change.getAddedSubList().get(i);
                        totalPrice.set(totalPrice.get() + added.getPrice());
                    }
                }
                if (change.wasRemoved()) {
                    for (int i = 0; i < change.getRemovedSize(); i++) {
                        Product removed = change.getRemoved().get(i);
                        totalPrice.set(totalPrice.get() - removed.getPrice());
                    }

                }
            }
        });
    }

    public void removeFromBasket(Product product) {
        getProducts().remove(product);
    }

    public void addToBasket(Product product) {
        getProducts().add(product);
    }
}
