module hi.vidmot {
    requires javafx.controls;
    requires javafx.fxml;
    requires algs4;


    opens hi.vidmot to javafx.fxml;
    exports hi.vidmot;
}
