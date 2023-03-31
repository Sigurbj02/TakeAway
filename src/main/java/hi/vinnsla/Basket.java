package hi.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Basket extends Menu {
    private IntegerProperty totalPrice = new SimpleIntegerProperty();

    public Basket() {
        totalPrice.setValue(0);
        addListener();
    }

    public ObservableList<Veitingar> getVeitingarInBasket() {
        return getVeitingar();
    }


    public IntegerProperty totalPriceProperty() {
        return totalPrice;
    }

    /**
     * Adds a ListChangeListener to the total price which updates when items are added to
     * or removed from the basket
     */
    private void addListener() {
        getVeitingar().addListener((ListChangeListener<Veitingar>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    for (int i = 0; i < change.getAddedSize(); i++) {
                        Veitingar added = change.getAddedSubList().get(i);
                        totalPrice.set(totalPrice.get() + added.getPrice());
                    }
                }
                if (change.wasRemoved()) {
                    for (int i = 0; i < change.getRemovedSize(); i++) {
                        Veitingar removed = change.getRemoved().get(i);
                        totalPrice.set(totalPrice.get() - removed.getPrice());
                    }

                }
            }
        });
    }

    public void removeFromBasket(Veitingar veitingar) {
        getVeitingar().remove(veitingar);
    }

    public void addToBasket(Veitingar veitingar) {
        getVeitingar().add(veitingar);
    }

    /**
     * Some tests i had to do for the other project at some point. Can be deleted, but may be used for our tests
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        Basket basket = new Basket();
        menu.setMenuData();
        System.out.println("Menu: ");
        for (int i = 0; i < menu.getVeitingar().size(); i++) {
            System.out.println(menu.getVeitingar().get(i));
        }

        System.out.println("place items nr 5 and 9 in the basket");
        basket.addToBasket(menu.getVeitingar().get(5));
        basket.addToBasket(menu.getVeitingar().get(9));

        System.out.println("this is how the basket looks:");
        for (int i = 0; i < basket.getVeitingarInBasket().size(); i++) {
            System.out.println(basket.getVeitingarInBasket().get(i));
        }
    }
}
