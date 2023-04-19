package lk.ijse.rentabike.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.rentabike.model.UserModel;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class SettingFormController {
    private static final String URL = "jdbc:mysql://localhost:3306/rentabike";
    private static final Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "1234");
    }

    public JFXButton dashboardbtn;
    public JFXButton bookingbtn;
    public JFXButton vehiclebtn;
    public JFXButton customerbtn;
    public JFXButton employeebtn;
    public JFXButton billingbtn;
    public JFXButton settingbtn;

    public TextField txtUsername;
    public PasswordField txtPassword;

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

    public void btnAddOnActon(ActionEvent actionEvent) throws SQLException {
        String Username = txtUsername.getText();
        String Password = txtPassword.getText();


        if (isUsernameValid(Username)) {
            if (passwordValid(Password)) {
                if (UserModel.validateUsernameANDpassword(Username)) {

                    try (Connection con = DriverManager.getConnection(URL, props)) {
                        String sql = "INSERT INTO User(user_name, password)" +
                                "VALUES(?, ?)";
                        PreparedStatement pstm = con.prepareStatement(sql);
                        pstm.setString(1, Username);
                        pstm.setString(2, Password);

                        int affectedRows = pstm.executeUpdate();
                        if (affectedRows > 0) {
                            new Alert(Alert.AlertType.CONFIRMATION,
                                    "user added successfully..")
                                    .show();
                        }
                    }

                } else {
                    new Alert(Alert.AlertType.WARNING, "The Username already exists, So use different Username").show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid passowrd. Please enter a valid username that contains only letters, digits, periods, underscores, and hyphens, and is at least 3 characters long.");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username. Please enter a valid username that contains only letters, digits, periods, underscores, and hyphens, and is at least 3 characters long.");
        }
    }

    public boolean isUsernameValid(String username) {
        String usernameRegex = "^[a-zA-Z0-9._-]{3,}$"; // Allows letters, digits, periods, underscores, and hyphens. Must be at least 3 characters long.
        return username.matches(usernameRegex);
    }


    public boolean passwordValid(String password) {
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"; // Requires at least 1 letter, 1 digit, and must be at least 8 characters long.
        return password.matches(passwordRegex);
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException {
        String Username = txtUsername.getText();
        String Password = txtPassword.getText();

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "UPDATE User SET password = ? WHERE user_name = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, Password);
            pstm.setString(2, Username);

            boolean isUpdated = pstm.executeUpdate() > 0;
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "user updated!!").show();
            }
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException {
        String Username = txtUsername.getText();

        try (Connection con = DriverManager.getConnection(URL, props)) {
            String sql = "DELETE FROM User WHERE user_name = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, Username);

            if (pstm.executeUpdate() > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "deleted!").show();
            }
        }
    }


}
