package lk.ijse.rentabike.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.rentabike.dto.Vehicle;
import lk.ijse.rentabike.dto.tm.VehicleTm;
import lk.ijse.rentabike.model.VehicleModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class VehicleManagementFormController implements Initializable {
    public TableView tblVehicleManagement;
    public TableColumn colVehicleId;
    public TableColumn colVehicleName;
    public TableColumn colType;
    public TableColumn colRentPrice;
    public TableColumn colMileage;
    public TableColumn colFirstAidKit;
    public TableColumn colTransmission;
    public TableColumn colRoadsideAssistance;
    public TableColumn colAvailable;

    public void btnVehicleManagementOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/AddVehicleForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Vehicle");
        stage.setMaximized(true);
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();


    }

    private void setCellValueFactory() {
        colVehicleId.setCellValueFactory(new PropertyValueFactory<>("vehicleId"));
        colVehicleName.setCellValueFactory(new PropertyValueFactory<>("vehicleName"));
        colType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colRentPrice.setCellValueFactory(new PropertyValueFactory<>("vehicleRent"));
        colMileage.setCellValueFactory(new PropertyValueFactory<>("vehicleMilage"));
        colFirstAidKit.setCellValueFactory(new PropertyValueFactory<>("vehicleFirstAidKit"));
        colTransmission.setCellValueFactory(new PropertyValueFactory<>("vehicleTransmission"));
        colRoadsideAssistance.setCellValueFactory(new PropertyValueFactory<>("vehicleRoadAssistance"));
        colAvailable.setCellValueFactory(new PropertyValueFactory<>("vehicleAvailale"));
    }

    private void getAll() {
        try {
            ObservableList<VehicleTm> obList = FXCollections.observableArrayList();
            List<Vehicle> vehicleList = VehicleModel.getAll();

            for (Vehicle vehicle : vehicleList) {
                obList.add(new VehicleTm(
                        vehicle.getVehicleId(),
                        vehicle.getVehicleName(),
                        vehicle.getType(),
                        vehicle.getRent(),
                        vehicle.getMilage(),
                        vehicle.getFirstAidKit(),
                        vehicle.getTransmission(),
                        vehicle.getRoadAssistance(),
                        vehicle.getAvailable()
                ));
            }
            tblVehicleManagement.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }
}
