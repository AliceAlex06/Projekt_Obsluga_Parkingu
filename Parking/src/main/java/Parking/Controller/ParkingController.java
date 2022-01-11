package Parking.Controller;

import Parking.Config.DbConnect;
import Parking.Config.Parking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ParkingController {

    @FXML
    private TableView<Parking> parkingTableView;
    @FXML
    private TableColumn<Parking, Integer> idParkowaniaColumn;
    @FXML
    private TableColumn<Parking, Integer> idSamochoduColumn;
    @FXML
    private TableColumn<Parking, Date> dataColumn;

    private ObservableList<Parking> parkingList;
    private Connection connection;
    DbConnect dbConnect;


    public void parking(int id) {
        try {
            parkingList = FXCollections.observableArrayList();
            String query = "SELECT * FROM parking WHERE idSamochodu = '" + id + "'";
            dbConnect = new DbConnect();
            connection = dbConnect.getConnection();
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()) {
                Parking parking = new Parking();
                parking.setIdParkowania(rs.getInt("idParkowania"));
                parking.setIdSamochodu(rs.getInt("idSamochodu"));
                parking.setDataParkowania(rs.getDate("dataParkowania"));
                parkingList.add(parking);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        idParkowaniaColumn.setCellValueFactory(new PropertyValueFactory<>("idParkowania"));
        idSamochoduColumn.setCellValueFactory(new PropertyValueFactory<>("idSamochodu"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("dataParkowania"));

        parkingTableView.setItems(parkingList);
    }
}
