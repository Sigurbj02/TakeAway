package hi.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {
    private Basket basket;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        basket = new Basket();
        assertTrue(basket.getProducts().isEmpty());
        menu = new Menu();
        menu.setMenuData();
        basket.getProducts().add(new Product("Sour candy", 300));
        basket.getProducts().add(new Product("Shampoo", 1809));
    }


    @Test
    public void addToBasket() {
        basket.getProducts().clear();
        assertTrue(basket.getProducts().isEmpty());
        basket.addToBasket(new Product("Sour candy", 300));
        assertFalse(basket.getProducts().isEmpty());
        basket.addToBasket(new Product("Shampoo", 1809));
        assertEquals(2, basket.getProducts().size());
    }

    @Test
    public void addToBasketFromMenu() {
        assertFalse(menu.getProducts().isEmpty());
        assertFalse(basket.getProducts().isEmpty());
        basket.getProducts().clear();
        assertTrue(basket.getProducts().isEmpty());

        assertEquals(menu.getProducts().get(5).getPrice(), 200);
        assertEquals(menu.getProducts().get(5).getProduct(), "Hundamatur");
        basket.addToBasket(menu.getProducts().get(5));
        assertEquals(basket.getProducts().get(0), menu.getProducts().get(5));
    }

    @Test
    public void getProducts() {
        addToBasket();
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Sour candy", 300));
        products.add(new Product("Shampoo", 1809));
        assertEquals(products.toString(), basket.getProducts().toString());
    }


    @Test
    public void totalPriceProperty() {//remove from basket and add to it again?
        assertNotNull(basket.totalPriceProperty());
        int price = 300 + 1809;
        assertEquals(price, basket.totalPriceProperty().get());
    }


    @Test
    public void removeFromBasket() {
        assertEquals("The first item in the basket is " + basket.getProducts().get(0).getProduct(), basket.getProducts().get(0).getProduct(), "Sour candy");
        basket.removeFromBasket(basket.getProducts().get(0));
        assertEquals(basket.getProducts().size(), 1);
        basket.removeFromBasket(basket.getProducts().get(0));
        assertTrue(basket.getProducts().isEmpty());
    }
}
