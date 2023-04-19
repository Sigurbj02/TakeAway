package hi.vidmot;

import hi.vinnsla.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.IOException;

public class CustomerDialog extends Dialog<Customer> {
    @FXML
    private TextField fxName;
    @FXML
    private TextField fxAddress;
    @FXML
    private ButtonType fxOK;
    private Customer customer;//the customer who signs up

    public CustomerDialog() {
        setDialogPane(initialization());
        this.customer = new Customer("", "");
        setOKRule();
        setBinding();
        setResultConverter();
    }

    /**
     * Sets binding between the dialog and the backend
     */
    private void setBinding() {
        customer.nameProperty().bind(fxName.textProperty());
        customer.addressProperty().bind(fxAddress.textProperty());
    }

    /**
     * sets rule to able/disable the ok button
     */
    private void setOKRule() {
        Node ok = getDialogPane().lookupButton(fxOK);
        ok.disableProperty()
                .bind(fxName.textProperty().isEmpty()
                        .or(fxAddress.textProperty().isEmpty()));

    }

    /**
     * sets a resultConverter so customer is returned when ok is pressed
     */
    private void setResultConverter() {
        Callback<ButtonType, Customer> customerResultConverter = param -> {
            if (param.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return customer;
            } else {
                return null;
            }
        };
        setResultConverter(customerResultConverter);
    }

    /**
     * Initializes the dialog, reads in the .fxml file and sets the controller
     *
     * @return the dialogPane that is shown
     */
    private DialogPane initialization() {
        this.setTitle("Sign up");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(View.CUSTOMER.getFileName()));
        fxmlLoader.setController(this);
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
