package hi.vinnsla;

import org.junit.Before;
import org.junit.Test;

public class BasketTest {
    private Basket basket;

    @Before
    public void setUp() throws Exception {
        basket = new Basket();
    }

    @Test
    public void addToBasket() {
        basket.addToBasket(new Product("Sour candy", 300));
    }

    @Test
    public void setMenuData() {
    }

    @Test
    public void getProducts() {
    }

    @Test
    public void getProductsInBasket() {
    }

    @Test
    public void totalPriceProperty() {
    }

    @Test
    public void removeFromBasket() {
    }


    /**
     * Some tests I had to do for the other project at some point. Can be deleted, but may be used for our tests
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        Basket basket = new Basket();
        menu.setMenuData();
        System.out.println("Menu: ");
        for (int i = 0; i < menu.getProducts().size(); i++) {
            System.out.println(menu.getProducts().get(i));
        }

        System.out.println("place items nr 5 and 9 in the basket");
        basket.addToBasket(menu.getProducts().get(5));
        basket.addToBasket(menu.getProducts().get(9));

        System.out.println("this is how the basket looks:");
        for (int i = 0; i < basket.getProductsInBasket().size(); i++) {
            System.out.println(basket.getProductsInBasket().get(i));
        }
    }
}
