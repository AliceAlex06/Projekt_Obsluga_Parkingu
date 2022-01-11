package Parking;

import Parking.Controller.WyborController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/FXML/wybor.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();
        WyborController wyborController = fxmlLoader.getController();
        wyborController.setStageWybor(stage);
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.setTitle("Parking");
        stage.show();
    }
}
