package hi.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * Vinnsluklasi sem inniheldur observable list af veitingum sem settar eru á matseðil og
 * aðferðina sem setur veitingar á matseðilinn
 */
public class Matsedill {
    protected ObservableList<Veitingar> veitingar = FXCollections.observableArrayList();

    /**
     * Strengnum sem er inni í aðferðinni er splittað og skipt niður í mismunandi Veitingar
     * sem settar eru á matseðil. Filterar út þær sem hafa of langt nafn
     */
    public void setjaGogn() {
        String veitingaStrengur = "Pestópasta, 10900, Spagettí, 290, íslensk kjötsúpa, 1500, Pepperóní pizza, 2319, " +
                "Margaríta pizza, 2187, Hundamatur, 200, Einn banani, 3000, mjólk, 1090, " +
                "súrsaðir hrútspungar, 11, páfagaukavængir, 2500, DIY tómatsúpa, 2390, brjóstamjólkurís , 9999, " +
                "pulsa í brauði, 600, pylsa í brauði, 3400, ";
        String[] veitingaFylki = veitingaStrengur.split(", ");
        for (int i = 0; i < veitingaFylki.length - 1; i = i + 2) {
            if (veitingaFylki[i].length() <= 30) {
                veitingar.add(new Veitingar(veitingaFylki[i], Integer.parseInt(veitingaFylki[i + 1])));
            }
        }
    }

    //getter
    public ObservableList<Veitingar> getVeitingar() {
        return veitingar;
    }

}
