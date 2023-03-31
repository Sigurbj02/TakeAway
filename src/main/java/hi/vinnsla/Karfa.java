package hi.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * Vinnsluklasi sem erfir frá Matsedill, því báðir eru observable listi af Veitingar. Heildarverð körfu reiknað
 * út og hlutum bætt við og eytt úr körfu
 */
public class Karfa extends Matsedill {
    private IntegerProperty heildarVerd = new SimpleIntegerProperty();//vaktanlegt gildi fyrir heildarverð

    //smiður. Upphafsstillir heildarverð og kallar á aðferð sem bætir við listener
    public Karfa() {
        heildarVerd.setValue(0);
        addListener();
    }

    //getter
    public ObservableList<Veitingar> getVeitingarIKorfu() {
        return getVeitingar();
    }

    /**
     * property til að vakta heildarverð
     *
     * @return heildarverð, IntegerProperty
     */
    public IntegerProperty heildarVerdProperty() {
        return heildarVerd;
    }

    /**
     * Bætir ListChangeListener á heildarverðið sem uppfærist þegar veitingum er bætt
     * við eða eytt út körfunni
     */
    private void addListener() {
        getVeitingar().addListener((ListChangeListener<Veitingar>) change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    for (int i = 0; i < change.getAddedSize(); i++) {
                        Veitingar baettVid = change.getAddedSubList().get(i);
                        heildarVerd.set(heildarVerd.get() + baettVid.getVerd());
                    }
                }
                if (change.wasRemoved()) {
                    for (int i = 0; i < change.getRemovedSize(); i++) {
                        Veitingar eyttUt = change.getRemoved().get(i);
                        heildarVerd.set(heildarVerd.get() - eyttUt.getVerd());
                    }

                }
            }
        });
    }

    /**
     * Eyðir völdum hlut úr körfunni
     *
     * @param val - hlutur af Veitingar klasanum sem á að eyða úr körfu
     */
    public void delKarfa(Veitingar val) {
        getVeitingar().remove(val);
    }

    /**
     * Bætir völdum hlut við körfuna
     *
     * @param val - hlutur af Veitingar klasanum sem á að bæta við í körfuna
     */
    public void addKarfa(Veitingar val) {
        getVeitingar().add(val);
    }

    /**
     * prófunarfall. Ég vil taka það fram að ég náði ekki að keyra það, því ég get bara keyrt
     * með maven einhverra hluta vegna, og fattaði það ekki fyrr en ég var búin að gjörbreyta fallinu
     * Það má endilega hundsa þetta bara <3
     */
    public static void main(String[] args) {
        Matsedill matsedill = new Matsedill();
        Karfa karfa = new Karfa();
        matsedill.setjaGogn();
        System.out.println("Matsedill: ");
        for (int i = 0; i < matsedill.getVeitingar().size(); i++) {
            System.out.println(matsedill.getVeitingar().get(i));
        }

        System.out.println("setjum vörur nr 5 og 9 í körfuna");
        karfa.addKarfa(matsedill.getVeitingar().get(5));
        karfa.addKarfa(matsedill.getVeitingar().get(9));

        System.out.println("Svona lítur karfan út");
        for (int i = 0; i < karfa.getVeitingarIKorfu().size(); i++) {
            System.out.println(karfa.getVeitingarIKorfu().get(i));
        }
    }
}
