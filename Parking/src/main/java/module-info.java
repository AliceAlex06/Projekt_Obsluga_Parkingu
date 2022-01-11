module Parking {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires persistence.api;
    requires java.sql;

    opens Parking to javafx.fxml;
    exports Parking;
    exports Parking.Controller;
    exports Parking.Config;
    opens Parking.Controller to javafx.fxml;
}