package hi.vidmot;

import hi.vinnsla.Karfa;
import hi.vinnsla.Veitingar;
import hi.vinnsla.Vidskiptavinur;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

/**
 * Controller fyrir pöntunarsenu forritsins. Inniheldur m.a. atburðahandlera, listenera og bindings
 */
public class PontunController {

    @FXML
    private Button fxInnskraningHnappur;//til að skrá sig inn

    @FXML
    private TextField fxHeildarupphaed;//sýnir heildarupphæð

    @FXML
    private Button fxGreidaHnappur;//til að greiða

    @FXML
    private ListView<Veitingar> fxKarfa;//sýnir hvað er í körfunni

    @FXML
    private MatsedillView fxMatsedill;//viðmót fyrir sérhæfða klasann sem sýnir matseðil

    private BooleanProperty innskraningarStada = new SimpleBooleanProperty(false);//vaktanlegt gildi sem segir til um
    //hvort einhver sé búinn að skrá sig inn
    private Vidskiptavinur notandi = new Vidskiptavinur("Sigurbjörg", "Hofgerði 5");//notandi forritsins
    private Karfa karfa;//listinn yfir hlutina í körfunni

    /**
     * keyrir sjálfkrafa. upphafsstillir körfuna og kallar á aðferðir til að setja bindings,
     * listenera og texta á innskráningarhnapp
     */
    public void initialize() {
        karfa = new Karfa();
        setjaBindings();
        innskraningartexti();
        setjaListenera();
    }

    //getter
    public Vidskiptavinur getNotandi() {
        return notandi;
    }

    //getter
    public Karfa getKarfa() {
        return karfa;
    }

    /**
     * setur listenera fyrir texta á innskráningrhnapp og fyrir hluti í listview fyrir körfuna
     */
    private void setjaListenera() {
        karfa.getVeitingarIKorfu().addListener((ListChangeListener<? super Veitingar>) change -> {
            fxKarfa.setItems(karfa.getVeitingarIKorfu());
        });
        innskraningarStada.addListener((observable, oldVal, newVal) -> {
            innskraningartexti();
        });
    }

    /**
     * setur bindings fyrir heildarupphæð, til að gera greiða hnappinn óvirkann ef karfan er tóm og til
     * að gera innskráningarhnappinn óvirkan eftir að notandi skráir sig inn
     */
    private void setjaBindings() {
        fxHeildarupphaed.textProperty().bind(karfa.heildarVerdProperty().asString().concat(" kr."));
        fxGreidaHnappur.disableProperty().bind(karfa.heildarVerdProperty().isEqualTo(0));
        fxInnskraningHnappur.disableProperty().bind(innskraningarStada);
    }

    /**
     * sýnir hvaða texti birtist á innskráningarhnapp eftir aðstæðum
     */
    private void innskraningartexti() {
        if (notandi == null) {
            fxInnskraningHnappur.setText("Nýskráning");
        } else if (!innskraningarStada.getValue()) {
            fxInnskraningHnappur.textProperty().set("Innskráning");
        } else if (innskraningarStada.getValue()) {
            fxInnskraningHnappur.setText(notandi.nafnProperty().getValue());
        }
    }

    /**
     * aðferð til að gera einfaldan dialog til að koma upplýsingum til skila
     *
     * @param skilabod - strengur, skilaboð sem á að birta í dialognum
     */
    public void geraDialog(String skilabod) {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("TakeAway");
        dialog.setContentText(skilabod);
        ButtonType okButtonType = new ButtonType("Í lagi");
        dialog.getDialogPane().getButtonTypes().add(okButtonType);
        dialog.showAndWait();
    }

    /**
     * atburðahandler. Ef það er enginn notandi í kerfinu er VidskiptavinurDialog opnað þar sem hægt er
     * að skrá nýjan notanda. Annars þarf bara að slá inn lykilorð
     *
     * @param actionEvent - ýtt á innskráningarhnapp
     */
    public void fxInnskraningHandler(ActionEvent actionEvent) {
        if (notandi == null) {
            VidskiptavinurDialog d = new VidskiptavinurDialog(new Vidskiptavinur("", ""));
            Optional<Vidskiptavinur> result = d.showAndWait();
            if (result.isPresent()) {
                notandi = result.get();
                innskraningarStada.set(true);
            }
        } else if (!innskraningarStada.getValue()) {
            LoginDialog a = new LoginDialog(notandi);
            if (a.giltLykilord()) {
                innskraningarStada.set(true);
            }
        }
    }

    /**
     * atburðahandler. Ef eitthvað í listview fyrir matseðil er valið er það sett í körfuna
     *
     * @param actionEvent - ýtt á hnapp til að bæta við í körfu
     */
    public void fxSetjaKorfuHandler(ActionEvent actionEvent) {
        if (fxMatsedill.getFxListi().getSelectionModel().getSelectedItem() != null) {
            karfa.addKarfa(fxMatsedill.getFxListi().getSelectionModel().getSelectedItem());
        }
    }

    /**
     * atburðahandler. Ef einhvað í ListView fyrir körfuna er valið er það tekið úr körfunni
     *
     * @param actionEvent - ýtt á taka úr körfu hnapp
     */
    public void fxTakaUrKorfuHandler(ActionEvent actionEvent) {
        if (fxKarfa.getSelectionModel().getSelectedItem() != null) {
            karfa.delKarfa(fxKarfa.getSelectionModel().getSelectedItem());
        }
    }

    /**
     * atburðahandler. Ef það er einhver notandi skráður inn er skipt yfir í greiðslusenu, annars kemur dialog sem
     * segir að það þurfi að skrá sig inn til að halda áfram
     *
     * @param actionEvent ýtt á greiða
     */
    public void fxGreidaHandler(ActionEvent actionEvent) {
        if (!innskraningarStada.getValue()) {
            String skilabod = "Skráðu þig inn til að fara í greiðslusenu";
            geraDialog(skilabod);
        } else ViewSwitcher.switchTo(View.GREIDSLA);
    }
}
