package lk.ijse.rentabike.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageFormController {
    public TextField txtUsername;
    public TextField txtPassword;

    public void btnSignInToDashOnAction(ActionEvent actionEvent) throws IOException {


        /*String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (username.equals("root") && password.equals("1234")) {
            loadDashboardForm();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setContentText("Incorrect username or password.");
            alert.showAndWait();
        }

        private void loadDashboardForm() throws IOException {
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Dashboard");
            stage.setMaximized(true);
            stage.centerOnScreen();
            stage.show();
        }*/

        // Get the current stage
        Stage currentStage = (Stage) txtUsername.getScene().getWindow();

        // Close the current stage
        currentStage.close();

        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Dashboard");
        stage.setMaximized(true);
        stage.centerOnScreen();
        stage.show();




    }
}
