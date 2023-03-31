package hi.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Application klasi fyrir forritið. hleður inn fxml skrá fyrir fyrstu senuna og setur bæði svið
 * og senu, ásamt titli. Setur senu í ViewSwitcher
 */
public class TakeAwayApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TakeAwayApplication.class.getResource("ordering-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 400);
        stage.setTitle("TakeAway!");
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.ORDERING);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
