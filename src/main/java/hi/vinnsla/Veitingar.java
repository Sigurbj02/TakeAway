package hi.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * vinnsluklasi sem inniheldur upplýsingar um veitingar sem hægt er að panta. Hjúpað í eigin gagnatagi,
 * sem inniheldur StingProperty fyrir vöruna og IntegerProperty fyrir verð hennar (hægt að vakta)
 */
public class Veitingar {
    private StringProperty vara = new SimpleStringProperty();//heiti réttar
    private IntegerProperty verd = new SimpleIntegerProperty();//verð réttar

    //smiðurinn
    public Veitingar(String vara, int verd) {
        this.vara.set(vara);
        this.verd.set(verd);
    }

    //getter
    public int getVerd() {
        return verd.get();
    }

    /**
     * toString aðferð, skilar uppsetningu eins og hún á að vera á matseðli. Notar tab til að
     * hafa verðið í línu
     *
     * @return Strengur, eins og varan er sýnd
     */
    public String toString() {
        int lengdVoru = vara.getValue().length();
        String skil = vara.getValue();
        while (lengdVoru < 32) {
            skil = skil.concat("\t");
            lengdVoru += 8;
        }
        skil = skil.concat(verd.getValue() + "");
        return skil;
    }
}
