package hi.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {
    private Basket basket;
    private Basket emptyBasket;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        menu = new Menu();
        menu.setMenuData();

        basket = new Basket();
        basket.getProducts().add(new Product("Sour candy", 300));
        basket.getProducts().add(new Product("Shampoo", 1809));

        emptyBasket = new Basket();
    }

    @Test
    public void addToBasket() {
        emptyBasket.addToBasket(new Product("Sour candy", 300));
        emptyBasket.addToBasket(new Product("Shampoo", 1809));
        assertEquals("There should be two items in the basket", 2, basket.getProducts().size());
    }

    @Test
    public void addToBasketFromMenu() {
        assertEquals("the price of the product with the index 5 on the menu should be 200", menu.getProducts().get(5).getPrice(), 200);
        assertEquals("The product with the index 5 on the menu should be Hundamatur", menu.getProducts().get(5).getProduct(), "Hundamatur");
        emptyBasket.addToBasket(menu.getProducts().get(5));
        assertEquals("The first item in the basket should be Hundamatur, 200", emptyBasket.getProducts().get(0), menu.getProducts().get(5));
    }

    @Test
    public void getProducts() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Sour candy", 300));
        products.add(new Product("Shampoo", 1809));
        assertEquals(products.toString(), basket.getProducts().toString());
    }
    
    @Test
    public void totalPriceProperty() {
        assertNotNull("the priceProperty should not be null", basket.totalPriceProperty());
        int expectedPrice = 300 + 1809;
        assertEquals("The expected price for this basket is 2109", expectedPrice, basket.totalPriceProperty().get());
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
