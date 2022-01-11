package Parking.Controller;

import Parking.Config.DbConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WyborController implements Initializable {

    @FXML
    private AnchorPane mainView;

    public static AnchorPane anchorPane;

    @FXML
    private ComboBox markaCombo;
    @FXML
    private TextField numerText;

    private Connection connection;
    DbConnect dbConnect;
    Stage stage2;

    public void wszystkieButton(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/samochody.fxml"));
            AnchorPane ap = loader.load();
            SamochodyController samochodyController = loader.getController();
            samochodyController.samochodyTableView();
            samochodyController.setStageSamochody(stage2);
            mainView.getChildren().setAll(ap);
            stage2.sizeToScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void szukajButton(ActionEvent actionEvent) throws IOException {
        if (markaCombo.getSelectionModel().isEmpty() && numerText.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Musisz wybrać markę samochodu lub podać numer rejestracyjny");
            alert.showAndWait();
        } else if (!numerText.getText().isEmpty()) {
            try {
                int i = 0;
                String query = "SELECT numerRejestracyjny FROM samochody WHERE numerRejestracyjny = '" + numerText.getText() + "'";
                connection = dbConnect.getConnection();
                ResultSet rs = connection.createStatement().executeQuery(query);
                while (rs.next()) {
                    i++;
                }

                if (i != 0) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/samochody.fxml"));
                    AnchorPane ap = loader.load();
                    SamochodyController samochodyController = loader.getController();
                    samochodyController.samochodyTableViewNumerRejestracyjny(numerText.getText());
                    samochodyController.setStageSamochody(stage2);
                    mainView.getChildren().setAll(ap);
                    stage2.sizeToScene();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Błąd");
                    alert.setHeaderText("Nie ma takiego pojazdu w bazie danych");
                    alert.showAndWait();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if (!markaCombo.getItems().isEmpty()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/samochody.fxml"));
            AnchorPane ap = loader.load();
            SamochodyController samochodyController = loader.getController();
            samochodyController.samochodyTableViewMarka((String) markaCombo.getSelectionModel().getSelectedItem());
            mainView.getChildren().setAll(ap);
            samochodyController.setStageSamochody(stage2);
            mainView.getChildren().setAll(ap);
            stage2.sizeToScene();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (anchorPane == null) {
            anchorPane = mainView;
        }

        dbConnect = new DbConnect();
        markaCombo();
    }

    private void markaCombo() {
        try {
            String query = "SELECT markaSamochodu FROM samochody GROUP BY markaSamochodu";
            connection = dbConnect.getConnection();
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                markaCombo.getItems().add(rs.getString("markaSamochodu"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setStageWybor(Stage stage) {
        stage2 = stage;
    }
}
