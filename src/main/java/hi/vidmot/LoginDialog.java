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
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Sign in");
        textInputDialog.setHeaderText("Sign in as " + customer.nameProperty().getValue());
        textInputDialog.setContentText("Password: ");
        result = textInputDialog.showAndWait();
        textInputDialog.close();
    }

    /**
     * checks whether the password that is typed in is valid (basically just present)
     */
    public boolean passwordIsValid() {
        return result.isPresent() && !result.get().equals("");
    }
}
