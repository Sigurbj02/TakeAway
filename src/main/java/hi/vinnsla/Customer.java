package hi.vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {
    private StringProperty name = new SimpleStringProperty();
    private StringProperty address = new SimpleStringProperty();
    
    public Customer(String name, String address) {
        this.name.set(name);
        this.address.set(address);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty addressProperty() {
        return address;
    }
}
