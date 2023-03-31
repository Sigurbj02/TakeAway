package hi.vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * vinnsluklasi með sviðin nafn og heimilisfang, sem eru bæði StringProperty svo hægt sé að vakta þau.
 * Geymir upplýsingar um viðskiptavin, hjúpaðar í eigin gagnatagi
 */
public class Vidskiptavinur {
    private StringProperty nafn = new SimpleStringProperty();//nafn, hægt að vakta
    private StringProperty heimilisfang = new SimpleStringProperty();//vaktanlegt, heimilisfang
    
    /**
     * smiður fyrir klasann. Tekur inn nafn og setur það í tilviksbreytuna nafn, tekur svo inn
     * heimilisfang, sem fer í tilviksbreytuna heimilisfang
     *
     * @param nafn         - strengur, nafn viðskiptavinar
     * @param heimilisfang - strengur, heimilisfang viðskiptavinar
     */
    public Vidskiptavinur(String nafn, String heimilisfang) {
        this.nafn.set(nafn);
        this.heimilisfang.set(heimilisfang);
    }

    //property til að vakta nafn
    public StringProperty nafnProperty() {
        return nafn;
    }

    //property til að vakta heimilisfang
    public StringProperty heimilisfangProperty() {
        return heimilisfang;
    }
}
