package hi.vidmot;

import hi.vinnsla.Product;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ProductCellFactory implements Callback<ListView<Product>, ListCell<Product>> {
    @Override
    public ListCell<Product> call(ListView<Product> productListView) {
        return new ListCell<>() {
            @Override
            public void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);
                if (empty) {
                    setText(null);
                } else if (product != null) {
                    int nameLength = product.getProduct().length();
                    String string = product.getProduct();
                    while (nameLength < 32) {
                        string = string.concat("\t");
                        nameLength += 8;
                    }
                    string = string.concat(product.getPrice() + "");
                    setText(string);
                } else {
                    setText("null");
                }
            }
        };
    }

}
