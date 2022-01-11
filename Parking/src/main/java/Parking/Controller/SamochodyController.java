package Parking.Controller;

import Parking.Config.DbConnect;
import Parking.Config.Samochody;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SamochodyController implements Initializable {

    @FXML
    private TableView<Samochody> samochodTableView;
    @FXML
    private TableColumn<Samochody, Integer> idColumn;
    @FXML
    private TableColumn<Samochody, String> markaColumn;
    @FXML
    private TableColumn<Samochody, Double> pojemnoscColumn;
    @FXML
    private TableColumn<Samochody, String> numerColumn;
    @FXML
    private TableColumn<Samochody, String> nazwiskoColumn;
    @FXML
    private TableColumn<Samochody, Void> parkingColumn;

    private ObservableList<Samochody> samochodyList;
    private Connection connection;
    DbConnect dbConnect;
    Stage stage3;

    public void cofnijButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/wybor.fxml"));
        AnchorPane ap = loader.load();
        WyborController wyborController = loader.getController();
        wyborController.setStageWybor(stage3);
        WyborController.anchorPane.getChildren().setAll(ap);
        stage3.sizeToScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnect = new DbConnect();
        connection = dbConnect.getConnection();
    }

    public void samochodyTableView() {
        try {
            samochodyList = FXCollections.observableArrayList();
            String query = "SELECT * FROM samochody";
            //String query = "SELECT * FROM samochody ORDER BY pojemnoscSilnika ASC";
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                Samochody s = new Samochody();
                s.setIdSamochodu(rs.getInt("idSamochodu"));
                s.setMarkaSamochodu(rs.getString("markaSamochodu"));
                s.setPojemnoscSilnika(rs.getDouble("pojemnoscSilnika"));
                s.setNumerRejestracyjny(rs.getString("numerRejestracyjny"));
                s.setNazwiskoWlasciciela(rs.getString("nazwiskoWlasciciela"));
                samochodyList.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<>("idSamochodu"));
        markaColumn.setCellValueFactory(new PropertyValueFactory<>("markaSamochodu"));
        pojemnoscColumn.setCellValueFactory(new PropertyValueFactory<>("pojemnoscSilnika"));
        numerColumn.setCellValueFactory(new PropertyValueFactory<>("numerRejestracyjny"));
        nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<>("nazwiskoWlasciciela"));

        samochodTableView.setItems(samochodyList);

        addButton();
    }

    public void samochodyTableViewNumerRejestracyjny(String numer) {
        try {
            samochodyList = FXCollections.observableArrayList();
            String query = "SELECT * FROM samochody WHERE numerRejestracyjny = '" + numer + "'";
            //String query = "SELECT * FROM samochody WHERE numerRejestracyjny = '"+numer+"' ORDER BY pojemnoscSilnika ASC";
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                Samochody s = new Samochody();
                s.setIdSamochodu(rs.getInt("idSamochodu"));
                s.setMarkaSamochodu(rs.getString("markaSamochodu"));
                s.setPojemnoscSilnika(rs.getDouble("pojemnoscSilnika"));
                s.setNumerRejestracyjny(rs.getString("numerRejestracyjny"));
                s.setNazwiskoWlasciciela(rs.getString("nazwiskoWlasciciela"));
                samochodyList.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<>("idSamochodu"));
        markaColumn.setCellValueFactory(new PropertyValueFactory<>("markaSamochodu"));
        pojemnoscColumn.setCellValueFactory(new PropertyValueFactory<>("pojemnoscSilnika"));
        numerColumn.setCellValueFactory(new PropertyValueFactory<>("numerRejestracyjny"));
        nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<>("nazwiskoWlasciciela"));

        samochodTableView.setItems(samochodyList);

        addButton();
    }

    public void samochodyTableViewMarka(String marka) {
        try {
            samochodyList = FXCollections.observableArrayList();
            String query = "SELECT * FROM samochody WHERE markaSamochodu = '" + marka + "'";
            //String query = "SELECT * FROM samochody WHERE markaSamochodu = '"+marka+"' ORDER BY pojemnoscSilnika ASC";
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                Samochody s = new Samochody();
                s.setIdSamochodu(rs.getInt("idSamochodu"));
                s.setMarkaSamochodu(rs.getString("markaSamochodu"));
                s.setPojemnoscSilnika(rs.getDouble("pojemnoscSilnika"));
                s.setNumerRejestracyjny(rs.getString("numerRejestracyjny"));
                s.setNazwiskoWlasciciela(rs.getString("nazwiskoWlasciciela"));
                samochodyList.add(s);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<>("idSamochodu"));
        markaColumn.setCellValueFactory(new PropertyValueFactory<>("markaSamochodu"));
        pojemnoscColumn.setCellValueFactory(new PropertyValueFactory<>("pojemnoscSilnika"));
        numerColumn.setCellValueFactory(new PropertyValueFactory<>("numerRejestracyjny"));
        nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<>("nazwiskoWlasciciela"));

        samochodTableView.setItems(samochodyList);

        addButton();
    }


    private void addButton() {
        Callback<TableColumn<Samochody, Void>, TableCell<Samochody, Void>> cellFactory = new Callback<TableColumn<Samochody, Void>, TableCell<Samochody, Void>>() {
            @Override
            public TableCell<Samochody, Void> call(TableColumn<Samochody, Void> samochodyVoidTableColumn) {
                return new TableCell<Samochody, Void>() {
                    private final Button button = new Button("Parking");

                    {
                        button.setOnAction((ActionEvent) -> {
                            try {
                                Samochody samochody = getTableView().getItems().get(getIndex());
                                Stage stage = new Stage();
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/parking.fxml"));
                                AnchorPane anchorPane = loader.load();
                                ParkingController parkingController = loader.getController();
                                parkingController.parking(samochody.getIdSamochodu());
                                Scene scene = new Scene(anchorPane);
                                stage.setScene(scene);
                                stage.setTitle("Szczegóły parkowania");
                                stage.show();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
            }
        };
        parkingColumn.setCellFactory(cellFactory);
    }

    public void setStageSamochody(Stage stage2) {
        stage3 = stage2;
    }
}
