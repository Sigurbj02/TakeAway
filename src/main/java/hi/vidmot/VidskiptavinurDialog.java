package hi.vidmot;

import hi.vinnsla.Vidskiptavinur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.IOException;

/**
 * Klasinn erfir frá Dialog<Vidskiptavinur> og sér um aðgerðir innan hans og túlkun gagna
 */
public class VidskiptavinurDialog extends Dialog<Vidskiptavinur> {

    @FXML
    private TextField fxNafn;//textfield til að slá inn nafn
    @FXML
    private TextField fxHeimilisfang;//textfield til að slá inn heimilisfang
    @FXML
    private ButtonType fxILagi;//í lagi hnappur

    private Vidskiptavinur notandi;//viðskiptavinur sem skráir sig

    /**
     * smiður fyrir klasann. Getur tekið inn Viðskiptavinur hlut. Kallar á fjórar aðferðir
     *
     * @param vidskiptavinur - Hlutur af klasanum viðskiptavinur, með auð gildi.
     */
    public VidskiptavinurDialog(Vidskiptavinur vidskiptavinur) {
        setDialogPane(upphafsstilling());
        notandi = vidskiptavinur;
        setRegla();
        setBinding();
        setResultConverter();
    }

    /**
     * setur binding á milli dialogs og vinnslu
     */
    private void setBinding() {
        fxNafn.textProperty().bindBidirectional(notandi.nafnProperty());
        fxHeimilisfang.textProperty().bindBidirectional(notandi.heimilisfangProperty());
    }

    /**
     * setur í lagi reglu sem virkjar/óvirkjar í lagi hnappinn
     */
    private void setRegla() {
        Node iLagi = getDialogPane().lookupButton(fxILagi);
        iLagi.disableProperty()
                .bind(fxNafn.textProperty().isEmpty()
                        .or(fxHeimilisfang.textProperty().isEmpty()));

    }

    /**
     * Setur resultConverter svo notanda er skilað ef ýtt er á ok
     */
    private void setResultConverter() {
        Callback<ButtonType, Vidskiptavinur> vidskiptavinurResultConverter = param -> {
            if (param.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return notandi;
            } else {
                return null;
            }
        };
        setResultConverter(vidskiptavinurResultConverter);
    }

    /**
     * upphafsstillir Dialoginn. Les inn .fxml skrána og setur controllerinn
     *
     * @return DialogPane sem er sýndur
     */
    private DialogPane upphafsstilling() {
        this.setTitle("Nýskráning");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(View.VIDSKIPTAVINUR.getFileName()));
        fxmlLoader.setController(this);
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
