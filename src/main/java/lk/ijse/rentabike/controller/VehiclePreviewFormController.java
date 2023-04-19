package lk.ijse.rentabike.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class VehiclePreviewFormController {
    public JFXButton dashboardbtn;
    public JFXButton bookingbtn;
    public JFXButton vehiclebtn;
    public JFXButton customerbtn;
    public JFXButton employeebtn;
    public JFXButton billingbtn;
    public JFXButton settingbtn;
    public JFXButton logoutbtn;

    public AnchorPane context;

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"));
        Stage window = (Stage)dashboardbtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Dashboard");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnBookingOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/BookingPart1Filling.fxml"));
        Stage window = (Stage)bookingbtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Booking");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnVehicleOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/VehiclePreviewForm.fxml"));
        Stage window = (Stage)vehiclebtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Vehicle Preview");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/CustomerManagementForm.fxml"));
        Stage window = (Stage)customerbtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Customer Management");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnEmployeeManagementOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/EmployeeManagementForm.fxml"));
        Stage window = (Stage)employeebtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Employee Management");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnBillingOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/PaymentsManagementForm.fxml"));
        Stage window = (Stage)billingbtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Payments Management");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnSettingOnAction(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader =  FXMLLoader.load(getClass().getResource("/view/SettingForm.fxml"));
        Stage window = (Stage)settingbtn.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader));
        window.setTitle("Setting");
        window.setMaximized(true);
        window.centerOnScreen();
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/LogOutPageForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Log out");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnVehicleManageOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/VehicleManagementForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Vehicle Management");
        stage.setMaximized(true);
        stage.centerOnScreen();
        stage.show();
    }

    public void btnBikesSelectOnAction(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/view/BikesPreviewForm.fxml"));
        context.getChildren().add(parent);
    }

    public void btnScooterSelectOnAction(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/view/ScooterPreviewForm.fxml"));
        context.getChildren().add(parent);
    }

    public void btnBicycleSelectOnAction(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/view/BicyclePreviewForm.fxml"));
        context.getChildren().add(parent);
    }

    public void btnCarSelectOnAction(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/view/CarPreviewForm.fxml"));
        context.getChildren().add(parent);
    }

    public void btnThreewheelSelectOnAction(ActionEvent actionEvent) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/view/ThreeWheelPreviewForm.fxml"));
        context.getChildren().add(parent);
    }
}
