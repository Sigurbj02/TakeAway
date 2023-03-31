package hi.vidmot;

import hi.vinnsla.Vidskiptavinur;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

/**
 * Klasi fyrir dialoginn sem kemur þegar það er notandi nú þegar í kerfinu, og hann skráir sig inn
 */
public class LoginDialog {
    private Optional<String> utkoma;//útkoma dialogsins þegar lykilorð er slegið inn. Ef tómt, þá null

    /**
     * smiður, tekur inn viskiptavinur. Setur Dialog og upplýsingar. athugar inntak og lokar
     *
     * @param vidskiptavinur
     */
    public LoginDialog(Vidskiptavinur vidskiptavinur) {
        TextInputDialog d = new TextInputDialog();
        d.setTitle("Innskráning");
        d.setHeaderText("Skrá inn viðskiptavin " + vidskiptavinur.nafnProperty().getValue());
        d.setContentText("Lykilorð: ");

        utkoma = d.showAndWait();

        d.close();
    }

    /**
     * athugar hvort lykilorð sem slegið var inn sé gilt
     *
     * @return true ef gilt, annars false
     */
    public boolean giltLykilord() {
        return utkoma.isPresent() && !utkoma.get().equals("");
    }
}
