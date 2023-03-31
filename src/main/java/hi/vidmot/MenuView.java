package hi.vidmot;

import hi.vinnsla.Menu;
import hi.vinnsla.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Custom component for the interface of the menu
 */
public class MenuView extends AnchorPane {
    @FXML
    private ListView<Product> fxList;

    public MenuView() {
        readFXML();
        Menu m = new Menu();
        m.setMenuData();
        fxList.setItems(m.getProducts());
    }

    public ListView<Product> getFxList() {
        return fxList;
    }

    /**
     * reads the .fxml file, sets the root and controller and loads the loader
     */
    private void readFXML() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
