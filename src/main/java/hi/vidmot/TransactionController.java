package hi.vidmot;

import edu.princeton.cs.algs4.StdRandom;
import hi.vinnsla.Basket;
import hi.vinnsla.Product;
import javafx.beans.binding.Bindings;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller for the transaction scene
 */
public class TransactionController {
    @FXML
    private Label fxName;
    @FXML
    private Label fxAddress;
    @FXML
    private Label fxETA;
    @FXML
    private ListView<Product> fxBasket;
    @FXML
    private TextField fxTotalPrice;

    private Basket basket;

    private OrderingController orderingController;

    /**
     * runs automatically. Initializes the basket and pontunController. Sets customer as the same as in
     * the ordering scene. Calls mathods for listeners and bindings
     */
    public void initialize() {
        basket = new Basket();
        orderingController = (OrderingController) ViewSwitcher.lookup(View.ORDERING);
        addBasketListener();
        makeInformationBinding();
        makeBasketAndPriceBindings();
        fxBasket.setCellFactory(new ProductCellFactory());
    }

    /**
     * finds a random time with the format hh:mm
     */
    private String getTime() {
        String time = "";
        int hour = StdRandom.uniform(24);
        int minute = StdRandom.uniform(60);
        if ((hour + "".length()) == 1) {
            time = "0";
        }
        time = time.concat("" + hour + ":");
        if ((minute + "").length() == 1) {
            time = time.concat("0");
        }
        time = time.concat(minute + "");
        return time;
    }

    /**
     * makes a listener which changes the listview when the contents of the basket change
     */
    private void addBasketListener() {
        basket.getProducts().addListener((ListChangeListener<? super Product>) change -> {
            fxBasket.setItems(basket.getProducts());
        });
    }

    /**
     * makes a binding between the baskets in the transaction scene and the ordering scene and for the total price
     */
    private void makeBasketAndPriceBindings() {
        Bindings.bindContent(basket.getProducts(), orderingController.getBasket().getProducts());
        fxTotalPrice.textProperty().bind(basket.totalPriceProperty().asString().concat(" kr."));
    }

    /**
     * makes a binding for information about the order and delivery and puts in a label
     */
    private void makeInformationBinding() {
        fxName.textProperty().bind(orderingController.getCustomer().nameProperty());
        fxAddress.textProperty().bind(orderingController.getCustomer().addressProperty());
        fxETA.setText(getTime());
    }

    /**
     * shows a dialog to confirm that the order has been received, empties the basket and goes to the ordering scene
     *
     * @param actionEvent confirm button pressed
     */
    public void confirm(ActionEvent actionEvent) {
        String message = "The order has been confirmed";
        orderingController.makeDialog(message);
        orderingController.getBasket().getProducts().clear();
        ViewSwitcher.switchTo(View.ORDERING);
    }

    /**
     * goes to the ordering scene without making any changes
     *
     * @param actionEvent back/cancel button pressed
     */
    public void goBack(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.ORDERING);
    }
}
