package hi.vidmot;

import hi.vinnsla.Matsedill;
import hi.vinnsla.Veitingar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Sérhæfður klasi fyrir viðmót matseðils, erfir frá AnchorPane sem inniheldur ListView
 */
public class MatsedillView extends AnchorPane {

    @FXML
    private ListView<Veitingar> fxListi;//listview fyrir matseðil

    /**
     * smiður, gerir nýjan matseðil og kallar á aðferð til að setja gögn á hann. Setur það
     * upp í listview hlutinn
     */
    public MatsedillView() {
        uppsetning();
        Matsedill m = new Matsedill();
        m.setjaGogn();
        fxListi.setItems(m.getVeitingar());
    }

    //getter
    public ListView<Veitingar> getFxListi() {
        return fxListi;
    }
    
    /**
     * les inn .fxml skrána, setur rótina oc controller, og hleður loadernum
     */
    private void uppsetning() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("matsedill-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
