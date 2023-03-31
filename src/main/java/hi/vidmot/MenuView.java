package hi.vidmot;

import hi.vinnsla.Menu;
import hi.vinnsla.Veitingar;
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
    private ListView<Veitingar> fxList;//listview for the menu

    /**
     * constructor. makes a new menu and calls a method to put the items on it. Puts the
     * menu in the listview object
     */
    public MenuView() {
        readFXML();
        Menu m = new Menu();
        m.setMenuData();
        fxList.setItems(m.getVeitingar());
    }

    //getter
    public ListView<Veitingar> getFxList() {
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
