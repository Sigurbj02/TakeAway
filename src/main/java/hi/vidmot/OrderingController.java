package hi.vidmot;

import hi.vinnsla.Basket;
import hi.vinnsla.Customer;
import hi.vinnsla.Product;
import java.util.Optional;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller for the ordering scene (Pöntunarsena). Contains action handlers, listeners and bindings and more
 */
public class OrderingController {

    @FXML
    private Button fxLoginButton;//to sign in

    @FXML
    private TextField fxTotalPrice;//shows the total price

    @FXML
    private Button fxPayButton;//to pay (go to transaction scene)

    @FXML
    private ListView<Product> fxBasket;//shows what's in the basket

    @FXML
    private MenuView fxMenu;//interface for the custom component showing the menu

    private BooleanProperty loggedIn = new SimpleBooleanProperty(false);//observable value saying whether a user has logged in

    private Customer customer;//customer if there is no customer in the system
    //private Customer customer = new Customer("Sigurbjörg", "Hofgerði 5");//customer, if there is a customer in the system
    private Basket basket;//list for the items in the basket

    /**
     * Runs automatically. Initializes the basket and calls methods for bindings, listeners
     * and text on the login button
     */
    public void initialize() {
        basket = new Basket();
        setBindings();
        loginText();
        setListeners();
    }

    //getter
    public Customer getCustomer() {
        return customer;
    }

    //getter
    public Basket getBasket() {
        return basket;
    }

    /**
     * sets listeners for text on the login button and for items in the listview for the basket
     */
    private void setListeners() {
        basket.getProductsInBasket().addListener((ListChangeListener<? super Product>) change -> {
            fxBasket.setItems(basket.getProductsInBasket());
        });
        loggedIn.addListener((observable, oldVal, newVal) -> {
            loginText();
        });
    }

    /**
     * sets bindings for the total price, for disabling the pay button when the basket is empty and to
     * disable the login button after customer has logged in
     */
    private void setBindings() {
        fxTotalPrice.textProperty().bind(basket.totalPriceProperty().asString().concat(" kr."));
        fxPayButton.disableProperty().bind(basket.totalPriceProperty().isEqualTo(0));
        fxLoginButton.disableProperty().bind(loggedIn);
    }

    /**
     * sets the text on the login button depending on the situation
     */
    private void loginText() {
        if (customer == null) {
            fxLoginButton.setText("Sign up");
        } else if (!loggedIn.getValue()) {
            fxLoginButton.textProperty().set("Sign in");
        } else if (loggedIn.getValue()) {
            fxLoginButton.setText(customer.nameProperty().getValue());
        }
    }

    /**
     * method to make a simple dialog to convey information
     *
     * @param message - String, message to show
     */
    public void makeDialog(String message) {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("TakeAway");
        dialog.setContentText(message);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();
    }

    /**
     * action handler. Opens CustomerDialog if there is no customer in the system where a new customer can be
     * put in the system. Opens a LoginDialog if there is a customer in the system where the user needs to type
     * in a password to log in.
     *
     * @param actionEvent - login button pressed
     */
    public void login() {
        if (customer == null) {
            CustomerDialog d = new CustomerDialog(new Customer("", ""));
            Optional<Customer> result = d.showAndWait();
            if (result.isPresent()) {
                customer = result.get();
                loggedIn.set(true);
            }
        } else if (!loggedIn.getValue()) {
            LoginDialog a = new LoginDialog(customer);
            if (a.passwordIsValid()) {
                loggedIn.set(true);
            }
        }
    }

    /**
     * Action handler. If something in the listview for the Menu is selected it is put in the basket
     *
     * @param actionEvent - button pressed to add to basket
     */
    public void addToBasket() {
        if (fxMenu.getFxList().getSelectionModel().getSelectedItem() != null) {
            basket.addToBasket(fxMenu.getFxList().getSelectionModel().getSelectedItem());
        }
    }

    /**
     * Action handler. If something in the listview for the basket is selected it is removed from the basket
     *
     * @param actionEvent - button pressed to remove from basket
     */
    public void removeFromBasket() {
        if (fxBasket.getSelectionModel().getSelectedItem() != null) {
            basket.removeFromBasket(fxBasket.getSelectionModel().getSelectedItem());
        }
    }

    /**
     * action handler. If the customer is signed in it switches to the transaction scene, otherwise a dialog
     * appears telling the user to log in to continue
     *
     * @param actionEvent button pressed to pay
     */
    public void pay() {
        if (!loggedIn.getValue()) {
            String message = "Log in to go on to the transaction scene";
            makeDialog(message);
        } else ViewSwitcher.switchTo(View.TRANSACTION);
    }
}
