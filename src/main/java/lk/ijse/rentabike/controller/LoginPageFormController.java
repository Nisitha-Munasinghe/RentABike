package lk.ijse.rentabike.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.rentabike.model.LoginModel;

import java.io.IOException;
import java.sql.SQLException;

public class LoginPageFormController {


    public TextField txtUsername;
    public PasswordField txtPassword;

    public void btnSignInToDashOnAction(ActionEvent actionEvent) throws IOException {

        String username = txtUsername.getText();
        String password = txtPassword.getText();

        try {
            LoginModel loginModel = new LoginModel();
            boolean isUserValid = loginModel.isUserValid(username, password);

            if(isUserValid){
                Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"));
                Scene scene = new Scene(anchorPane);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Login");
                stage.setMaximized(true);
                stage.centerOnScreen();
                stage.show();
                currentStage.close();
            }else {

                new Alert(Alert.AlertType.ERROR,"wrong User Name And Password..!").show();
            }
        } catch (SQLException | IOException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }
}
