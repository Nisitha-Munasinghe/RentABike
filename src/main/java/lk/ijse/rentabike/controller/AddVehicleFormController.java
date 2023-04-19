package lk.ijse.rentabike.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class AddVehicleFormController implements Initializable {
    private static final String URL = "jdbc:mysql://localhost:3306/rentabike";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public TextField txtVehicleId;
    public TextField txtVehicleName;
    public TextField txtVehicleType;
    public TextField txtRent;
    public ComboBox cmbFirstAidKit;
    public ComboBox cmbMilage;
    public ComboBox cmbTransmission;
    public ComboBox cmbRoadAssistance;
    public ComboBox cmbAvailable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> milageList = FXCollections.observableArrayList();
        milageList.add("Unlimited");
        milageList.add("limited");
        cmbMilage.setItems(milageList);

        ObservableList<String> FirstAidKitList = FXCollections.observableArrayList();
        FirstAidKitList.add("Yes");
        FirstAidKitList.add("No");
        cmbFirstAidKit.setItems(FirstAidKitList);

        ObservableList<String> TransmissionList = FXCollections.observableArrayList();
        TransmissionList.add("Automatic");
        TransmissionList.add("Manual");
        cmbTransmission.setItems(TransmissionList);

        ObservableList<String> RoadAssistanceList = FXCollections.observableArrayList();
        RoadAssistanceList.add("Yes");
        RoadAssistanceList.add("no");
        cmbRoadAssistance.setItems(RoadAssistanceList);

        ObservableList<String> AvailableList = FXCollections.observableArrayList();
        AvailableList.add("Yes");
        AvailableList.add("no");
        cmbAvailable.setItems(AvailableList);
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException {
        String VehicleId = txtVehicleId.getText();
        String VehicleName = txtVehicleName.getText();
        String VehicleType = txtVehicleType.getText();
        double Rent = Double.parseDouble(txtRent.getText());
        String Milage = cmbMilage.getValue().toString();
        String FirstAidKit = cmbFirstAidKit.getValue().toString();
        String Transmission = cmbTransmission.getValue().toString();
        String RoadAssistance = cmbRoadAssistance.getValue().toString();
        String Available = cmbAvailable.getValue().toString();

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "INSERT INTO Vehicle(vehicleId, name, type, rent_price, mileage, first_aid_kit, transmission, roadside_assistance, available)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, VehicleId);
            pstm.setString(2, VehicleName);
            pstm.setString(3, VehicleType);
            pstm.setDouble(4, Rent);
            pstm.setString(5, Milage);
            pstm.setString(6, FirstAidKit);
            pstm.setString(7, Transmission);
            pstm.setString(8, RoadAssistance);
            pstm.setString(9, Available);

            int affectedRows = pstm.executeUpdate();
            if (affectedRows > 0) {
                new Alert(Alert.AlertType.CONFIRMATION,
                        " vehicle added :)")
                        .show();
            }
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException {
        String VehicleId = txtVehicleId.getText();
        String VehicleName = txtVehicleName.getText();
        String VehicleType = txtVehicleType.getText();
        double Rent = Double.parseDouble(txtRent.getText());
        String Milage = cmbMilage.getValue().toString();
        String FirstAidKit = cmbFirstAidKit.getValue().toString();
        String Transmission = cmbTransmission.getValue().toString();
        String RoadAssistance = cmbRoadAssistance.getValue().toString();
        String Available = cmbAvailable.getValue().toString();

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "UPDATE Vehicle SET name = ?, type = ?, rent_price = ? , mileage = ? , first_aid_kit = ? , transmission = ?, roadside_assistance = ?, available = ? WHERE vehicleId = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, VehicleName);
            pstm.setString(2, VehicleType);
            pstm.setDouble(3, Rent);
            pstm.setString(4, Milage);
            pstm.setString(5, FirstAidKit);
            pstm.setString(6, Transmission);
            pstm.setString(7, RoadAssistance);
            pstm.setString(8, Available);
            pstm.setString(9, VehicleId);

            boolean isUpdated = pstm.executeUpdate() > 0;
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "updated!!").show();
            }
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException {
        String VehicleId = txtVehicleId.getText();
        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "DELETE FROM Vehicle WHERE vehicleId = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, VehicleId);

            if (pstm.executeUpdate() > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "deletd!").show();
            }
        }
    }

    @FXML
    void codeSearchOnAction(ActionEvent event) throws SQLException {
        String VehicleId = txtVehicleId.getText();



        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "SELECT * FROM Vehicle WHERE vehicleId = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, VehicleId);

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {
                String Vehicle_Id = resultSet.getString(1);
                String Vehicle_Name = resultSet.getString(2);
                String Vehicle_Type = resultSet.getString(3);
                double Vehicle_Rent = resultSet.getDouble(4);
                String Vehicle_Milage = resultSet.getString(5);
                String Vehicle_FirstAidKit = resultSet.getString(6);
                String Vehicle_Transmission = resultSet.getString(7);
                String Vehicle_RoadAssistance = resultSet.getString(8);
                String Vehicle_Available = resultSet.getString(9);

                txtVehicleId.setText(Vehicle_Id);
                txtVehicleName.setText(Vehicle_Name);
                txtVehicleType.setText(Vehicle_Type);
                txtRent.setText(String.valueOf(Vehicle_Rent));
                cmbMilage.setValue(Vehicle_Milage);
                cmbFirstAidKit.setValue(Vehicle_FirstAidKit);
                cmbTransmission.setValue(Vehicle_Transmission);
                cmbRoadAssistance.setValue(String.valueOf(Vehicle_RoadAssistance));
                cmbAvailable.setValue(Vehicle_Available);

            }
        }
    }
}
