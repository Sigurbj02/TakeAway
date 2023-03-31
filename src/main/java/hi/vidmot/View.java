package hi.vidmot;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum View {
    PONTUN("pontun-view.fxml"),
    GREIDSLA("greida-view.fxml"),
    VIDSKIPTAVINUR("vidskiptavinur-view.fxml");
    private final String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
