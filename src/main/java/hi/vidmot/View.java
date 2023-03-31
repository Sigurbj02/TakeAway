package hi.vidmot;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum View {
    ORDERING("ordering-view.fxml"),
    TRANSACTION("transaction-view.fxml"),
    CUSTOMER("customer-view.fxml");
    private final String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
