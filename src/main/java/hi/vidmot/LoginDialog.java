package hi.vidmot;

import hi.vinnsla.Customer;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

/**
 * A class for the dialog that appears when there is already a user in the system
 * and he signs in
 */
public class LoginDialog {
    private Optional<String> result;//the result of the dialog when a password is typed in. If password field is empty, this is null

    public LoginDialog(Customer customer) {
        TextInputDialog d = new TextInputDialog();
        d.setTitle("Sign in");
        d.setHeaderText("Sign in as " + customer.nameProperty().getValue());
        d.setContentText("Password: ");
        result = d.showAndWait();
        d.close();
    }

    /**
     * checks whether the password that is typed in is valid (basically just present)
     */
    public boolean passwordIsValid() {
        return result.isPresent() && !result.get().equals("");
    }
}
