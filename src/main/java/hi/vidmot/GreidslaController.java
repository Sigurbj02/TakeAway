package hi.vidmot;

import edu.princeton.cs.algs4.StdRandom;
import hi.vinnsla.Karfa;
import hi.vinnsla.Veitingar;
import hi.vinnsla.Vidskiptavinur;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller fyrir greiðslusenu. Inniheldur atburðarhandlera, reglur og fleira.
 */
public class GreidslaController {
    @FXML
    private Label fxLabel;//label sem sýnir upplýsingar um afhendingu
    @FXML
    private ListView<Veitingar> fxKarfa;//listview hlutur með körfunni
    @FXML
    private TextField fxUpphaed; //textfield sem sýnir heildarupphæð í körfu

    private Karfa karfa;//karfa með hlutum sem voru valdir

    private Vidskiptavinur vidskiptavinur; //sá viðskiptavinur sem á að senda til

    private PontunController pontunController;//tilvik af PontunController til að geta notað aðferðir

    /**
     * keyrir sjálfkrafa. Upphafsstillir körfuna og pontunController. Setur viðskiptavininn sem þann sama og var
     * í pöntunarsenu. Kallar á aðferðir fyrir listener og bindings
     */
    public void initialize() {
        karfa = new Karfa();
        pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        vidskiptavinur = pontunController.getNotandi();
        karfaListener();
        geraUpplysingaBinding();
        geraKarfaOgVerdBinding();
    }

    /**
     * finnur slembitíma á sniðinu KK:MM
     *
     * @return Strengur, slembitími
     */
    private String getTime() {
        String timi = "";
        int klst = StdRandom.uniform(24);
        int min = StdRandom.uniform(60);
        if ((klst + "".length()) == 1) {
            timi = "0";
        }
        timi = timi.concat("" + klst + ":");
        if ((min + "").length() == 1) {
            timi = timi.concat("0");
        }
        timi = timi.concat(min + "");
        return timi;
    }

    /**
     * gerir listener sem breytir útliti ef innihald körfunnar breytist
     */
    private void karfaListener() {
        karfa.getVeitingarIKorfu().addListener((ListChangeListener<? super Veitingar>) change -> {
            fxKarfa.setItems(karfa.getVeitingarIKorfu());
        });
    }

    /**
     * gerir binding milli karfa í greiðslusenu og pöntunarsenu, fyrir heildarverð
     */
    private void geraKarfaOgVerdBinding() {

        Bindings.bindContent(karfa.getVeitingarIKorfu(), pontunController.getKarfa().getVeitingarIKorfu());
        fxUpphaed.textProperty().bind(karfa.heildarVerdProperty().asString().concat(" kr."));
    }

    /**
     * gerir binding fyrir upplýsingar um pöntun og setur í label
     */
    private void geraUpplysingaBinding() {
        StringBinding uppl = Bindings.createStringBinding(() ->
                "Viðtakandi: \t" + pontunController.getNotandi().nafnProperty().getValue() + "\n"
                        + "Heimilisfang: \t" + pontunController.getNotandi().heimilisfangProperty().getValue() + "\n" +
                        "Áætlaður afhendingartími: \t" + getTime()
        );
        fxLabel.textProperty().bind(uppl);
    }

    /**
     * gerir dialog til að staðfesta að pöntun sé móttekin, hreinsar körfu og fer á pöntunarsenu
     *
     * @param actionEvent ýtt á staðfesta hnapp
     */
    public void fxStadfestaHandler(ActionEvent actionEvent) {
        String skilabod = "Pöntunin hefur verið staðfest";
        pontunController.geraDialog(skilabod);
        pontunController.getKarfa().getVeitingarIKorfu().clear();
        ViewSwitcher.switchTo(View.PONTUN);
    }

    /**
     * fer á pöntunarsenu án þess að breyta neinu
     *
     * @param actionEvent ýtt á til baka hnapp
     */
    public void fxTilBaka(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.PONTUN);
    }
}
